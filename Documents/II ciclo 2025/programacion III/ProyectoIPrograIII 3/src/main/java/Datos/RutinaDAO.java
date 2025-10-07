/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Cliente;
import Modelo.Rutina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class RutinaDAO {

    private Connection conn;

    public RutinaDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertarRutina(Rutina r, int idRutina, int cedulaCliente) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call insertarRutina(?, ?, ?, ?)}");
            cs.setInt(1, idRutina);
            cs.setInt(2, cedulaCliente);
            cs.setString(3, r.getCliente().getNombre());
            cs.setString(4, r.toString());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public void modificarRutina(Rutina r, int idRutina, int cedulaCliente) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call modificarRutina(?, ?, ?, ?)}");
            cs.setInt(1, idRutina);
            cs.setInt(2, cedulaCliente);
            cs.setString(3, r.getCliente().getNombre());
            cs.setString(4, r.toString());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public void eliminarRutina(int idRutina) throws SQLException {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call eliminarRutina(?)}");
            cs.setInt(1, idRutina);
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public Rutina buscarRutina(int idRutina, Cliente cliente) throws SQLException {
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{? = call buscarRutina(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, idRutina);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);
            if (rs.next()) {
                Rutina r = new Rutina(cliente);
                return r;
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

    public List<Rutina> listarRutinas(List<Cliente> clientes) throws SQLException {
        List<Rutina> lista = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{? = call listarRutina()}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                int cedula = rs.getInt("CLIENTE_CED");
                Cliente c = clientes.stream()
                        .filter(cli -> cli.getCedula() == cedula)
                        .findFirst()
                        .orElse(null);
                if (c != null) {
                    Rutina r = new Rutina(c);
                    lista.add(r);
                }
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
