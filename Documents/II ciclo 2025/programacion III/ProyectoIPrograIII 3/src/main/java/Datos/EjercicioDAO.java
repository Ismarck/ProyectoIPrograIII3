/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Ejercicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class EjercicioDAO {

    private Connection conn;

    public EjercicioDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertarEjercicio(Ejercicio e) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call insertarEjercicio(?, ?)}");
            cs.setString(1, e.getNombre());
            cs.setString(2, e.getArea());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public void modificarEjercicio(Ejercicio e) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call modificarEjercicio(?, ?)}");
            cs.setString(1, e.getNombre());
            cs.setString(2, e.getArea());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public void eliminarEjercicio(String nombre) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call eliminarEjercicio(?)}");
            cs.setString(1, nombre);
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public Ejercicio buscarEjercicio(String nombre) throws SQLException {
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{? = call buscarEjercicio(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, nombre);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);
            if (rs.next()) {
                return new Ejercicio(
                        rs.getString("NOMBRE"),
                        rs.getString("AREA")
                );
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
        }
    }

    public List<Ejercicio> listarEjercicios() throws SQLException {
        List<Ejercicio> lista = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{? = call listarEjercicio()}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                Ejercicio e = new Ejercicio(
                        rs.getString("NOMBRE"),
                        rs.getString("AREA")
                );
                lista.add(e);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
        }
        return lista;
    }
}
