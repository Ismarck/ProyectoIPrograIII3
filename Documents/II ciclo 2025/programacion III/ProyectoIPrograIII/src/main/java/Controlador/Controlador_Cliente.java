/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;
import AccesoDatos.Coleccion_Cliente;
import Modelo.Cliente;
import Modelo.Instructor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Controlador_Cliente {
    
    private Coleccion_Cliente coleccionCliente;

    public Controlador_Cliente(Coleccion_Cliente coleccionCliente) {
        this.coleccionCliente = coleccionCliente;
    }

    public boolean registrar(Cliente c) {
        return coleccionCliente.Insertar(c);
    }

    public boolean eliminar(int Cedula) {
        return coleccionCliente.Eliminar(Cedula);
    }

    public Cliente buscar(int Cedula) {
        return coleccionCliente.buscar(Cedula);
    }

    public boolean modificar(Cliente c) {
        return coleccionCliente.Modificar(c);
    }

    public java.util.List<Cliente> listar() {
        return coleccionCliente.Listar();
    }
    
    /**/
}


