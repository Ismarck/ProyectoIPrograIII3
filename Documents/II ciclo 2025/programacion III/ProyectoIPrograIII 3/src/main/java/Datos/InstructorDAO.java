/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import Modelo.Instructor;
import Modelo.Sucursal;
import Modelo.Cliente;
import oracle.jdbc.OracleTypes;
import Controlador.Controlador_Sucursal;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class InstructorDAO {

    private Connection conn;
    private Controlador_Sucursal controladorSucursal;

    public InstructorDAO(Connection conn) {
        this.conn = conn;
        this.controladorSucursal = new Controlador_Sucursal(conn);
    }

    public void insertarInstructor(Instructor i) throws SQLException {
        CallableStatement csPersona = conn.prepareCall("{call insertarPersona(?,?,?,?,?,?)}");
        csPersona.setLong(1, i.getCedula());
        csPersona.setString(2, i.getNombre());
        csPersona.setDate(3, convertirFecha(i.getFecha_Nacimiento()));
        csPersona.setString(4, i.getCorreo());
        csPersona.setString(5, String.valueOf(i.getNumero_Celular()));
        csPersona.setString(6, String.valueOf(i.getSexo()));
        csPersona.execute();
        csPersona.close();

        CallableStatement csInstructor = conn.prepareCall("{call insertarInstructor(?,?,?)}");
        csInstructor.setLong(1, i.getCedula());
        csInstructor.setString(2, i.getEspecialidad());
        csInstructor.setInt(3, i.getSucursal().getCodigo());
        csInstructor.execute();
        csInstructor.close();
    }

    public void modificarInstructor(Instructor i) throws SQLException {
        CallableStatement csPersona = conn.prepareCall("{call modificarPersona(?,?,?,?,?,?)}");
        csPersona.setLong(1, i.getCedula());
        csPersona.setString(2, i.getNombre());
        csPersona.setDate(3, convertirFecha(i.getFecha_Nacimiento()));
        csPersona.setString(4, i.getCorreo());
        csPersona.setString(5, String.valueOf(i.getNumero_Celular()));
        csPersona.setString(6, String.valueOf(i.getSexo()));
        csPersona.execute();
        csPersona.close();

        CallableStatement csInstructor = conn.prepareCall("{call modificarInstructor(?,?,?)}");
        csInstructor.setLong(1, i.getCedula());
        csInstructor.setString(2, i.getEspecialidad());
        csInstructor.setInt(3, i.getSucursal().getCodigo());
        csInstructor.execute();
        csInstructor.close();
    }

    public void eliminarInstructor(long cedula) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call eliminarInstructor(?)}");
        cs.setLong(1, cedula);
        cs.execute();
        cs.close();
    }

    public List<Instructor> listarInstructores() throws SQLException {
        List<Instructor> lista = new ArrayList<>();
        CallableStatement cs = conn.prepareCall("{ ? = call listarInstructores() }");
        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.execute();

        ResultSet rs = (ResultSet) cs.getObject(1);
        while (rs.next()) {
            Sucursal sucursal = new Sucursal();
            sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));

            Sucursal sucCompleta = controladorSucursal.buscarPorCodigo(sucursal.getCodigo());
            if (sucCompleta != null) {
                sucursal.setProvincia(sucCompleta.getProvincia());
            }

            java.sql.Date fecha = rs.getDate("FECHA_NACIMIENTO");

            Instructor i = new Instructor(
                    rs.getString("ESPECIALIDAD"),
                    rs.getString("NOMBRE"),
                    (fecha != null) ? fecha.toString() : "",
                    rs.getString("CORREO"),
                    rs.getInt("NUMERO_CELULAR"),
                    rs.getInt("CEDULA"),
                    rs.getString("SEXO").charAt(0),
                    sucursal
            );
            lista.add(i);
        }

        rs.close();
        cs.close();
        return lista;
    }

    
    public List<Cliente> listarClientesPorInstructorDB(String nombreInstructor) throws SQLException {
        List<Cliente> resultado = new ArrayList<>();
        String sql = "{ ? = call listarClientesPorInstructor(?) }";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, nombreInstructor);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setCedula(rs.getInt("CEDULA"));
                    c.setNombre(rs.getString("NOMBRE_CLIENTE"));
                    c.setSexo(rs.getString("SEXO").charAt(0));
                    java.sql.Date fecha = rs.getDate("FECHA_NACIMIENTO");
                    c.setFecha_Nacimiento(fecha != null ? fecha.toString() : "");
                    c.setCorreo(rs.getString("CORREO"));
                    c.setNumero_Celular(rs.getInt("NUMERO_CELULAR"));

                    java.sql.Date fechains = rs.getDate("FECHA_NACIMIENTO");
                    c.setFecha_Inscripcion(fechains != null ? fechains.toString() : "");

                    String nombreIns = rs.getString("NOMBRE_INSTRUCTOR");
                    if (nombreIns != null) {
                        Instructor ins = new Instructor();
                        ins.setNombre(nombreIns);
                        c.setInstructorAsignado(ins);
                    }

                    int codSuc = rs.getInt("COD_SUCURSAL");
                    String provincia = rs.getString("PROVINCIA");
                    Sucursal suc = new Sucursal();
                    suc.setCodigo(codSuc);
                    suc.setProvincia(provincia);
                    c.setSucursal(suc);

                    resultado.add(c);
                }
            }
        }

        return resultado;
    }

    public List<Instructor> listarPorSucursal(int codigoSucursal) throws SQLException {
        List<Instructor> resultado = new ArrayList<>();
        String sql = "{ ? = call buscarInstructorPorSucursalCod(?) }";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, codigoSucursal);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Instructor ins = new Instructor();
                    ins.setCedula(rs.getInt("CEDULA"));
                    ins.setEspecialidad(rs.getString("ESPECIALIDAD"));
                    ins.setCorreo(rs.getString("CORREO"));
                    ins.setNumero_Celular(rs.getInt("NUMERO_CELULAR"));
                    ins.setNombre(rs.getString("NOMBRE"));

                    java.sql.Date fecha = rs.getDate("FECHA_NACIMIENTO");
                    ins.setFecha_Nacimiento(fecha != null ? fecha.toString() : "");

                    ins.setSexo(rs.getString("SEXO").charAt(0));

                    Sucursal suc = controladorSucursal.buscarPorCodigo(rs.getInt("SUCURSAL_COD"));
                    ins.setSucursal(suc);

                    resultado.add(ins);
                }
            }
        }
        return resultado;
    }

    public Instructor buscarPorCedula(long cedula) throws SQLException {
        List<Instructor> lista = listarInstructores();
        for (Instructor i : lista) {
            if (i.getCedula() == cedula) {
                return i;
            }
        }
        return null;
    }

    public List<Instructor> listarPorEspecialidad(String especialidad) throws SQLException {
        List<Instructor> resultado = new ArrayList<>();
        String sql = "{ ? = call buscarInstructorPorEspecialidad(?) }";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, especialidad);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Instructor ins = new Instructor();
                    ins.setCedula(rs.getInt("CEDULA"));
                    ins.setEspecialidad(rs.getString("ESPECIALIDAD"));
                    ins.setCorreo(rs.getString("CORREO"));
                    ins.setNumero_Celular(rs.getInt("NUMERO_CELULAR"));
                    ins.setNombre(rs.getString("NOMBRE"));

                    java.sql.Date fecha = rs.getDate("FECHA_NACIMIENTO");
                    ins.setFecha_Nacimiento(fecha != null ? fecha.toString() : "");
                    ins.setSexo(rs.getString("SEXO").charAt(0));

                    Sucursal suc = controladorSucursal.buscarPorCodigo(rs.getInt("SUCURSAL_COD"));
                    ins.setSucursal(suc);

                    resultado.add(ins);
                }
            }
        }
        return resultado;
    }

    private java.sql.Date convertirFecha(String fechaStr) {
        if (fechaStr == null || fechaStr.isEmpty()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fecha = sdf.parse(fechaStr);
            return new java.sql.Date(fecha.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
