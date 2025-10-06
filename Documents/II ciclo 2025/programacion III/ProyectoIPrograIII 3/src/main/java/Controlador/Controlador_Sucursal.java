/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import AccesoDatos.Coleccion_Sucursal;
import Modelo.Sucursal;
import Modelo.Cliente;

/**
 *
 * @author marcosisaacarayaabarca
 */
/*public class Controlador_Sucursal {
    
    private Coleccion_Sucursal coleccionSucursal;

    public Controlador_Sucursal (Coleccion_Sucursal coleccionSucursal) {
        this.coleccionSucursal = coleccionSucursal;
    }

    public boolean registrar(Sucursal c) {
        return coleccionSucursal.Insertar_Sucursal(c);
    }

    public boolean eliminar(int Codigo) {
        return coleccionSucursal.Eliminar_Sucursal(Codigo);
    }

    public Sucursal buscar(int Codigo) {
        return coleccionSucursal.Buscar_Sucursal(Codigo);
    }

    public Sucursal buscarPorProvincia(String provincia) {
        return coleccionSucursal.buscarPorProvincia(provincia);
    }
    
    public boolean modificar(Sucursal c) {
        return coleccionSucursal.Modificar_Sucursal(c);
    }
    
    public java.util.List<Cliente> listarClientesPorSucursal(int codigoSucursal) {
        return coleccionSucursal.listarClientesPorSucursal(codigoSucursal);
    }

    public java.util.List<Sucursal> listar() {
        return coleccionSucursal.Listar_Sucursal();
    }
}
*/

import Datos.SucursalDAO;
import Modelo.Sucursal;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de Sucursal usando base de datos Oracle
 * @author Ismarck
 */
public class Controlador_Sucursal {
    
    private SucursalDAO sucursalDAO;

    // Constructor recibe la conexión activa a la BD
    public Controlador_Sucursal(Connection conn) {
        this.sucursalDAO = new SucursalDAO(conn);
    }

    // Registrar (INSERT)
    public boolean registrar(Sucursal sucursal) {
        try {
            sucursalDAO.insertar(sucursal);
            //sucursalDAO.getConnection().commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Modificar
    public boolean modificar(Sucursal sucursal) {
        try {
            sucursalDAO.modificar(sucursal);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar
    public boolean eliminar(int codigo) {
        try {
            sucursalDAO.eliminar(codigo);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Buscar por código
    public Sucursal buscar(int codigo) {
        try {
            return sucursalDAO.buscar(codigo);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Listar todas las sucursales
    /*public List<Sucursal> listar() {
        try {
            return sucursalDAO.listar();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/
    
    public List<Sucursal> listar() {
    try {
        return sucursalDAO.listar(); // Debe consultar la BD
    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}

    
    public java.util.List<Cliente> listarClientesPorSucursal(int codigoSucursal) {
    try {
        return sucursalDAO.listarClientesPorSucursal(codigoSucursal);
    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}

    public Sucursal buscarPorCodigo(int codigo) {
    for (Sucursal s : listar()) { // listar() devuelve todas las sucursales
        if (s.getCodigo() == codigo) return s;
    }
    return null;
}

    
}
