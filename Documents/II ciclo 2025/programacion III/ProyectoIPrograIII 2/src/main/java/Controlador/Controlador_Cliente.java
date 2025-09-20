/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;
import AccesoDatos.Coleccion_Cliente;
import AccesoDatos.Coleccion_Sucursal;
import Modelo.Cliente;
import Modelo.Instructor;
import Modelo.Sucursal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Controlador_Cliente {
    
    private Coleccion_Cliente coleccionCliente;
    private Coleccion_Sucursal coleccionSucursal;

    public Controlador_Cliente(Coleccion_Cliente coleccionCliente, Coleccion_Sucursal coleccionSucursal) {
        this.coleccionCliente = coleccionCliente;
        this.coleccionSucursal = coleccionSucursal;
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
    
   public DefaultTableModel obtenerTablaClientesPorNombre(String nombre) {
    List<Cliente> clientes = coleccionCliente.buscarPorNombre(nombre);

    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"Cedula", "Nombre", "Sexo", "Nacimiento", "Correo", "Celular", "Inscripcion", "Instructor", "Sucursal"}, 0
    );

    for (Cliente c : clientes) {
        modelo.addRow(new Object[]{
            c.getCedula(),
            c.getNombre(),
            c.getSexo(),
            c.getFecha_Nacimiento(),
            c.getCorreo(),
            c.getNumero_Celular(),
            c.getFecha_Inscripcion(),
            (c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
            (c.getSucursal() != null) ? c.getSucursal().getProvincia() + " - " + c.getSucursal().getCanton() : "No asociada",
        });
    }

    return modelo;
}
 
    public List<Cliente> buscarClientesPorSucursal(int codigoSucursal) {
    if (coleccionSucursal != null) {
        return coleccionSucursal.listarClientesPorSucursal(codigoSucursal);
    }
    return new ArrayList<>();
}
    
    public DefaultTableModel obtenerTablaClientesPorSucursal(int CodigoSucursal) {
        // Buscar clientes por sucursal
        List<Cliente> clientes = buscarClientesPorSucursal(CodigoSucursal); // este método lo implementas según tu lógica

        // Definir columnas igual que en tu JTable
        String[] columnas = {"Sucursal", "Nombre", "Sexo", "Nacimiento", "Instructor", "Cedula", "Correo", "Celular", "Inscripcion"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Llenar la tabla
        for (Cliente c : clientes) {
            Object[] fila = {
                (c.getSucursal() != null) ? c.getSucursal().getCodigo() + " - " + c.getSucursal().getProvincia() : "No asociada",
                c.getNombre(),
                c.getSexo(),
                c.getFecha_Nacimiento(),
                (c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
                c.getCedula(),
                c.getCorreo(),
                c.getNumero_Celular(),
                c.getFecha_Inscripcion(),
            };
            modelo.addRow(fila);
        }
        return modelo;
    }


    
    /**/
}


