/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Cliente;
import Modelo.Instructor;
import Modelo.Medicion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class MedicionDAO {

    private Connection conn;

    public MedicionDAO(Connection conn) {
        this.conn = conn;
    }

    // ---------------------------
    // INSERTAR MEDICION
    // ---------------------------
    public void insertarMedicion(Medicion m, int idMedicion, int cedulaCliente, int cedulaInstructor) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call insertarMedicion(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, idMedicion);
            cs.setInt(2, cedulaCliente);
            cs.setInt(3, cedulaInstructor);
            cs.setDate(4, Date.valueOf(m.getFecha()));
            cs.setDouble(5, m.getPeso());
            cs.setDouble(6, m.getEstatura());
            cs.setDouble(7, m.getPorcentajeGrasa());
            cs.setDouble(8, m.getCintura());
            cs.setDouble(9, m.getCadera());
            cs.setDouble(10, m.getPecho());
            cs.setDouble(11, m.getMuslo());
            cs.executeUpdate();
        } finally {
            if (cs != null) cs.close();
        }
    }

    // ---------------------------
    // MODIFICAR MEDICION
    // ---------------------------
    public void modificarMedicion(Medicion m, int idMedicion, int cedulaCliente, int cedulaInstructor) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call modificarMedicion(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, idMedicion);
            cs.setInt(2, cedulaCliente);
            cs.setInt(3, cedulaInstructor);
            cs.setDate(4, Date.valueOf(m.getFecha()));
            cs.setDouble(5, m.getPeso());
            cs.setDouble(6, m.getEstatura());
            cs.setDouble(7, m.getPorcentajeGrasa());
            cs.setDouble(8, m.getCintura());
            cs.setDouble(9, m.getCadera());
            cs.setDouble(10, m.getPecho());
            cs.setDouble(11, m.getMuslo());
            cs.executeUpdate();
        } finally {
            if (cs != null) cs.close();
        }
    }

    // ---------------------------
    // ELIMINAR MEDICION
    // ---------------------------
    public void eliminarMedicion(int idMedicion) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call eliminarMedicion(?)}");
            cs.setInt(1, idMedicion);
            cs.executeUpdate();
        } finally {
            if (cs != null) cs.close();
        }
    }

    // ---------------------------
    // BUSCAR MEDICION POR ID
    // ---------------------------
    public Medicion buscarMedicion(int idMedicion, Cliente cliente, Instructor instructor) throws SQLException {
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{? = call buscarMedicion(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, idMedicion);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);
            if (rs.next()) {
                Medicion m = new Medicion();
                m.setCliente(cliente);
                m.setInstructor(instructor);
                m.setFecha(rs.getDate("FECHA").toLocalDate());
                m.setPeso(rs.getDouble("PESO"));
                m.setEstatura(rs.getDouble("ESTATURA"));
                m.setPorcentajeGrasa(rs.getDouble("PORC_GRASA"));
                m.setCintura(rs.getDouble("CINTURA"));
                m.setCadera(rs.getDouble("CADERA"));
                m.setPecho(rs.getDouble("PECHO"));
                m.setMuslo(rs.getDouble("MUSLO"));
                return m;
            } else {
                return null;
            }
        } finally {
            if (rs != null) rs.close();
            if (cs != null) cs.close();
        }
    }

    // ---------------------------
    // LISTAR TODAS LAS MEDICIONES
    // ---------------------------
    public List<Medicion> listarMediciones(List<Cliente> clientes, List<Instructor> instructores) throws SQLException {
        List<Medicion> lista = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{? = call listarMedicion()}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                int cedulaCliente = rs.getInt("CLIENTE_CED");
                int cedulaInstructor = rs.getInt("INSTRUCTOR_CED");

                Cliente c = clientes.stream().filter(cli -> cli.getCedula() == cedulaCliente).findFirst().orElse(null);
                Instructor i = instructores.stream().filter(ins -> ins.getCedula() == cedulaInstructor).findFirst().orElse(null);

                if (c != null && i != null) {
                    Medicion m = new Medicion();
                    m.setCliente(c);
                    m.setInstructor(i);
                    m.setFecha(rs.getDate("FECHA").toLocalDate());
                    m.setPeso(rs.getDouble("PESO"));
                    m.setEstatura(rs.getDouble("ESTATURA"));
                    m.setPorcentajeGrasa(rs.getDouble("PORC_GRASA"));
                    m.setCintura(rs.getDouble("CINTURA"));
                    m.setCadera(rs.getDouble("CADERA"));
                    m.setPecho(rs.getDouble("PECHO"));
                    m.setMuslo(rs.getDouble("MUSLO"));
                    lista.add(m);
                }
            }
        } finally {
            if (rs != null) rs.close();
            if (cs != null) cs.close();
        }
        return lista;
    }
}


