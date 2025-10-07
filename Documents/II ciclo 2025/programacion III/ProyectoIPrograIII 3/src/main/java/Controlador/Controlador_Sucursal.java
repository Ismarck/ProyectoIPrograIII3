/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Datos.SucursalDAO;
import Modelo.Sucursal;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controlador_Sucursal {

    private SucursalDAO sucursalDAO;

    public Controlador_Sucursal(Connection conn) {
        this.sucursalDAO = new SucursalDAO(conn);
    }

    public boolean registrar(Sucursal sucursal) {
        try {
            sucursalDAO.insertar(sucursal);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificar(Sucursal sucursal) {
        try {
            sucursalDAO.modificar(sucursal);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int codigo) {
        try {
            sucursalDAO.eliminar(codigo);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Sucursal buscar(int codigo) {
        try {
            return sucursalDAO.buscar(codigo);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Sucursal> listar() {
        try {
            return sucursalDAO.listar();
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
        for (Sucursal s : listar()) {
            if (s.getCodigo() == codigo) {
                return s;
            }
        }
        return null;
    }

}
