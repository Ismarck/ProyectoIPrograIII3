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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marcosisaacarayaabarca
 */

public class InstructorDAO {
    private Connection conn;

    public InstructorDAO(Connection conn) {
        this.conn = conn;
    }

    // INSERTAR INSTRUCTOR
    public void insertarInstructor(Instructor i) throws SQLException {
        // Primero insertar la persona
        CallableStatement csPersona = conn.prepareCall("{call insertarPersona(?,?,?,?,?,?)}");
        csPersona.setLong(1, i.getCedula());
        csPersona.setString(2, i.getNombre());
        csPersona.setDate(3, convertirFecha(i.getFecha_Nacimiento()));
        csPersona.setString(4, i.getCorreo());
        csPersona.setString(5, String.valueOf(i.getNumero_Celular()));
        csPersona.setString(6, String.valueOf(i.getSexo()));
        csPersona.execute();
        csPersona.close();

        // Luego insertar el instructor
        CallableStatement csInstructor = conn.prepareCall("{call insertarInstructor(?,?,?)}");
        csInstructor.setLong(1, i.getCedula());
        csInstructor.setString(2, i.getEspecialidad());
        csInstructor.setInt(3, i.getSucursal().getCodigo());
        csInstructor.execute();
        csInstructor.close();
    }

    // MODIFICAR INSTRUCTOR
    public void modificarInstructor(Instructor i) throws SQLException {
        // Modificar datos de persona
        CallableStatement csPersona = conn.prepareCall("{call modificarPersona(?,?,?,?,?,?)}");
        csPersona.setLong(1, i.getCedula());
        csPersona.setString(2, i.getNombre());
        csPersona.setDate(3, convertirFecha(i.getFecha_Nacimiento()));
        csPersona.setString(4, i.getCorreo());
        csPersona.setString(5, String.valueOf(i.getNumero_Celular()));
        csPersona.setString(6, String.valueOf(i.getSexo()));
        csPersona.execute();
        csPersona.close();

        // Modificar datos de instructor
        CallableStatement csInstructor = conn.prepareCall("{call modificarInstructor(?,?,?)}");
        csInstructor.setLong(1, i.getCedula());
        csInstructor.setString(2, i.getEspecialidad());
        csInstructor.setInt(3, i.getSucursal().getCodigo());
        csInstructor.execute();
        csInstructor.close();
    }

    // ELIMINAR INSTRUCTOR
    public void eliminarInstructor(long cedula) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call eliminarInstructor(?)}");
        cs.setLong(1, cedula);
        cs.execute();
        cs.close();
    }

    // LISTAR INSTRUCTORES
    public List<Instructor> listarInstructores() throws SQLException {
        List<Instructor> lista = new ArrayList<>();
        CallableStatement cs = conn.prepareCall("{call listarInstructores(?)}");
        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.execute();

        ResultSet rs = (ResultSet) cs.getObject(1);
        while(rs.next()) {
            Sucursal sucursal = new Sucursal();
            sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));

            // Convertir fecha SQL a String
            String fechaStr = rs.getDate("FECHA_NACIMIENTO").toString();

            Instructor i = new Instructor(
                    rs.getString("ESPECIALIDAD"), // especialidad
                    rs.getString("NOMBRE"), // nombre
                    fechaStr, // fechaNacimiento
                    rs.getString("CORREO"), // correo
                    rs.getInt("NUMERO_CELULAR"), // numeroCelular
                    rs.getInt("CEDULA"), // cedula
                    rs.getString("SEXO").charAt(0),// sexo
                    sucursal // objeto Sucursal
            );


            lista.add(i);
        }
        rs.close();
        cs.close();
        return lista;
    }

    // Método auxiliar para convertir String a java.sql.Date
    private java.sql.Date convertirFecha(String fechaStr) {
        if (fechaStr == null || fechaStr.isEmpty()) return null;
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
