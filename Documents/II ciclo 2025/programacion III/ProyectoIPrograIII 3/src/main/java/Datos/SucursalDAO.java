/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Cliente;
import Modelo.Sucursal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class SucursalDAO {

    private Connection conn;

    public SucursalDAO(Connection conn) {
        this.conn = conn;
    }

    
    public void insertar(Sucursal sucursal) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call insertarSucursal(?, ?, ?)}");
        cs.setInt(1, sucursal.getCodigo());
        cs.setString(2, sucursal.getProvincia());
        cs.setString(3, sucursal.getCanton());
        cs.execute();
        cs.close();
    }

    
    public void modificar(Sucursal sucursal) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call modificarSucursal(?, ?, ?)}");
        cs.setInt(1, sucursal.getCodigo());
        cs.setString(2, sucursal.getProvincia());
        cs.setString(3, sucursal.getCanton());
        cs.execute();
        cs.close();
    }

    
    public void eliminar(int codigo) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call eliminarSucursal(?)}");
        cs.setInt(1, codigo);
        cs.execute();
        cs.close();
    }

    
    public Sucursal buscar(int codigo) throws SQLException {
        CallableStatement cs = conn.prepareCall("{? = call buscarSucursal(?)}");
        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.setInt(2, codigo);
        cs.execute();

        ResultSet rs = (ResultSet) cs.getObject(1);
        Sucursal sucursal = null;

        if (rs.next()) {
            sucursal = new Sucursal();
            sucursal.setCodigo(rs.getInt("CODIGO"));
            sucursal.setProvincia(rs.getString("PROVINCIA"));
            sucursal.setCanton(rs.getString("CANTON"));
        }

        rs.close();
        cs.close();
        return sucursal;
    }


    public List<Sucursal> listar() throws SQLException {
        CallableStatement cs = conn.prepareCall("{? = call listarSucursal()}");
        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.execute();

        ResultSet rs = (ResultSet) cs.getObject(1);
        List<Sucursal> lista = new ArrayList<>();

        while (rs.next()) {
            Sucursal sucursal = new Sucursal();
            sucursal.setCodigo(rs.getInt("CODIGO"));
            sucursal.setProvincia(rs.getString("PROVINCIA"));
            sucursal.setCanton(rs.getString("CANTON"));
            lista.add(sucursal);
        }

        rs.close();
        cs.close();
        return lista;
    }
    //
    public List<Sucursal> listarSucursales() throws SQLException {
        List<Sucursal> lista = new ArrayList<>();
        String sql = "SELECT CODIGO, PROVINCIA, CANTON FROM SUCURSAL";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Sucursal s = new Sucursal(
                    rs.getInt("CODIGO"),
                    rs.getString("PROVINCIA"),
                    rs.getString("CANTON")
            );
            lista.add(s);
        }

        return lista;
    }

    //
    public List<Cliente> listarClientesPorSucursal(int codigoSucursal) throws SQLException {
    CallableStatement cs = conn.prepareCall("{? = call listarClientesPorSucursal(?)}");
    cs.registerOutParameter(1, OracleTypes.CURSOR);
    cs.setInt(2, codigoSucursal);
    cs.execute();

    ResultSet rs = (ResultSet) cs.getObject(1);
    List<Cliente> listaClientes = new ArrayList<>();

    while (rs.next()) {
        Cliente cliente = new Cliente();
        cliente.setCedula(rs.getInt("CEDULA"));
        cliente.setNombre(rs.getString("NOMBRE"));
        cliente.setFecha_Inscripcion(rs.getString("FECHA_INSCRIPCION"));

        // Si tu clase Cliente tiene una referencia a la sucursal:
        Sucursal sucursal = buscar(codigoSucursal);
        cliente.setSucursal(sucursal);

        listaClientes.add(cliente);
    }

    rs.close();
    cs.close();
    return listaClientes;
}

    
}
