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
import javax.swing.table.DefaultTableModel;

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
    
    public Cliente buscarporNombre(String Nombre) {
        return coleccionCliente.buscarpornombre(Nombre);
    }

    public boolean modificar(Cliente c) {
        return coleccionCliente.Modificar(c);
    }
    

    public java.util.List<Cliente> listar() {
        return coleccionCliente.Listar();
    }
   
    public DefaultTableModel obtenerTablaClientesPorNombre(String nombre) {
    List<Cliente> clientes = coleccionCliente.Listar();

    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"Cedula", "Nombre", "Sexo", "Nacimiento", "Correo", "Celular", "Inscripcion", "Instructor", "Sucursal"}, 0
    );

    for (Cliente c : clientes) {
        // Aquí filtra: si el nombre contiene el texto buscado (ignora mayúsculas/minúsculas)
        if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
            modelo.addRow(new Object[]{
                c.getCedula(),
                c.getNombre(),
                c.getSexo(),
                c.getFecha_Nacimiento(),
                c.getCorreo(),
                c.getNumero_Celular(),
                c.getFecha_Inscripcion(),
                //(c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
                //(c.getSucursal() != null) ? c.getSucursal().getProvincia() : "No asociada"
                (c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
                (c.getSucursal() != null) ? c.getSucursal().getProvincia() + " - " + c.getSucursal().getCanton() : "No asociada",
            });
        }
    }

    return modelo;
}

    
    /**/
}


