/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.ClaseGrupal;
import Modelo.Instructor;
import Modelo.Sucursal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class ClaseGrupalDAO {

    private Connection conn;

    public ClaseGrupalDAO(Connection conn) {
        this.conn = conn;
    }

    
    public void insertarClaseGrupal(ClaseGrupal c) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call insertarClaseGrupal(?, ?, ?, ?, ?, ?, ?)}");
        cs.setInt(1, c.getIdClase());
        cs.setString(2, c.getTipoClase());
        cs.setLong(3, c.getInstructor().getCedula());
        cs.setString(4, c.getHorario());
        cs.setInt(5, c.getCupoMaximo());
        cs.setInt(6, c.getCuposDisponibles());
        cs.setInt(7, c.getSucursal().getCodigo());
        cs.execute();
        cs.close();
    }

    
    public List<ClaseGrupal> listarClases() throws SQLException {
        List<ClaseGrupal> lista = new ArrayList<>();
        CallableStatement cs = conn.prepareCall("{? = call listarClaseGrupal()}");
        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.execute();
        ResultSet rs = (ResultSet) cs.getObject(1);

        while (rs.next()) {
            ClaseGrupal c = new ClaseGrupal(
                rs.getInt("ID_CLASE"),
                rs.getString("TIPO_CLASE"),
                new Instructor(rs.getInt("INSTRUCTOR_CEDULA")),
                rs.getString("HORARIO"),
                rs.getInt("CUPO_MAXIMO"),
                new Sucursal(rs.getInt("SUCURSAL_COD"))
            );
            c.setCuposDisponibles(rs.getInt("CUPOS_DISPONIBLES"));
            lista.add(c);
        }

        rs.close();
        cs.close();
        return lista;
    }

    
    public ClaseGrupal buscarClaseGrupal(int id) throws SQLException {
        CallableStatement cs = conn.prepareCall("{? = call buscarClaseGrupal(?)}");
        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.setInt(2, id);
        cs.execute();
        ResultSet rs = (ResultSet) cs.getObject(1);

        ClaseGrupal c = null;
        if (rs.next()) {
            c = new ClaseGrupal(
                rs.getInt("ID_CLASE"),
                rs.getString("TIPO_CLASE"),
                new Instructor(rs.getInt("INSTRUCTOR_CEDULA")),
                rs.getString("HORARIO"),
                rs.getInt("CUPO_MAXIMO"),
                new Sucursal(rs.getInt("SUCURSAL_COD"))
            );
            c.setCuposDisponibles(rs.getInt("CUPOS_DISPONIBLES"));
        }

        rs.close();
        cs.close();
        return c;
    }

    
    public void actualizarClaseGrupal(ClaseGrupal c) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call actualizarClaseGrupal(?, ?, ?, ?, ?, ?, ?)}");
        cs.setInt(1, c.getIdClase());
        cs.setString(2, c.getTipoClase());
        cs.setLong(3, c.getInstructor().getCedula());
        cs.setString(4, c.getHorario());
        cs.setInt(5, c.getCupoMaximo());
        cs.setInt(6, c.getCuposDisponibles());
        cs.setInt(7, c.getSucursal().getCodigo());
        cs.execute();
        cs.close();
    }

    
    public void eliminarClaseGrupal(int id) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call eliminarClaseGrupal(?)}");
        cs.setInt(1, id);
        cs.execute();
        cs.close();
    }
}
