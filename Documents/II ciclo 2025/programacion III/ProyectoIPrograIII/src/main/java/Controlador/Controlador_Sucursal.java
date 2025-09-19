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
public class Controlador_Sucursal {
    
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
