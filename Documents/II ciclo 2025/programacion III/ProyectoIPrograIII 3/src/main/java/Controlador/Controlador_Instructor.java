/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Instructor;
import AccesoDatos.Coleccion_Cliente;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
import AccesoDatos.Coleccion_Instructor;
import Modelo.Cliente;
import javax.swing.table.DefaultTableModel;


public class Controlador_Instructor {
    private Coleccion_Instructor coleccion;
    private List<Instructor> listaInstructores;
    private List<Cliente> listaClientes;
    private Coleccion_Cliente coleccionCliente;


    public Controlador_Instructor(Coleccion_Instructor coleccion, Coleccion_Cliente coleccionCliente) {
        this.coleccion = coleccion;
        listaInstructores = new ArrayList<>();
        listaClientes = new ArrayList<>();
                this.coleccionCliente = coleccionCliente;

    }

    public boolean registrarInstructor(Instructor ins) {
        return coleccion.Insertar_Instructor(ins);
    }

    public boolean eliminarInstructor(int cedula) {
        return coleccion.Eliminar_Instructor(cedula);
    }

    public Instructor buscarInstructor(int cedula) {
        return coleccion.Buscar_Instructor(cedula);
    }

    public boolean modificarInstructor(Instructor ins) {
        return coleccion.Modificar_Instructor(ins);
    }

    public java.util.List<Instructor> listar() {
        return coleccion.Listar_Instructor();
    }
    
    //Metodo nuevo
    public List<Instructor> buscarPorSucursal(String sucursal) {
        return coleccion.buscarPorSucursal(sucursal);
    }//Marcos
   
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    
   
 
//    // Método clave: obtener clientes por instructor
//    public List<Cliente> listarClientesPorInstructor(String nombreInstructor) {
//        List<Cliente> resultado = new ArrayList<>();
//        for (Instructor ins : listar()) {
//          //  if (ins.getNombre().equalsIgnoreCase(nombreInstructor)) {
//          if (ins.getNombre().toLowerCase().contains(nombreInstructor.toLowerCase())) {
//                resultado.addAll(ins.getListaClientes());
//                break;
//            }
//        }
//        return resultado;
//    }
//public List<Cliente> listarClientesPorInstructor(String nombreInstructor) {
//    List<Cliente> resultado = new ArrayList<>();
//    for (Cliente cli : coleccionCliente.Listar()) {
//        if (cli.getInstructorAsignado() != null &&
//           // cli.getInstructorAsignado().getNombre().equalsIgnoreCase(nombreInstructor)) {
//              cli.getInstructorAsignado().getNombre().toLowerCase().contains(nombreInstructor.toLowerCase())) {
//
//            resultado.add(cli);
//        }
//    }
//    return resultado;
//}
    public List<Cliente> listarClientesPorInstructor(String nombreInstructor) {
    List<Cliente> resultado = new ArrayList<>();
    String nombreBusqueda = nombreInstructor.toLowerCase().trim();

    for (Cliente cli : coleccionCliente.Listar()) {
        if (cli.getInstructorAsignado() != null) {
            String nombreInstructorCliente = cli.getInstructorAsignado().getNombre().toLowerCase().trim();
            if (nombreInstructorCliente.contains(nombreBusqueda)) {
                resultado.add(cli);
            }
        }
    }

    System.out.println("Clientes encontrados: " + resultado.size());
    return resultado;
}
    
    public DefaultTableModel obtenerTablaClientesPorInstructor(String nombreInstructor) {
    // Buscar clientes por instructor
    List<Cliente> clientes = listarClientesPorInstructor(nombreInstructor); // Este método lo implementas en tu controlador

    // Definir columnas igual que en tu JTable
    String[] columnas = {"Cedula", "Nombre", "Sexo", "Nacimiento", "Instructor", "Sucursal", "Correo", "Celular", "Inscripcion"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    // Llenar la tabla
    for (Cliente c : clientes) {
        Object[] fila = {
            c.getCedula(),
            c.getNombre(),
            c.getSexo(),
            c.getFecha_Nacimiento(),
            (c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
            (c.getSucursal() != null) ? c.getSucursal().getCodigo() + " - " + c.getSucursal().getProvincia() : "No asociada",
            c.getCorreo(),
            c.getNumero_Celular(),
            c.getFecha_Inscripcion()
        };
        modelo.addRow(fila);
    }

    return modelo;
}

    
}
