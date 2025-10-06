/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Instructor;
import AccesoDatos.Coleccion_Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
/*
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
    List<Cliente> clientes = listarClientesPorInstructor(nombreInstructor); 

    // Definir columnas en JTable
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

    // Método para obtener instructores por especialidad
    public List<Instructor> listarPorEspecialidad(String especialidad) {
        return coleccion.buscarPorEspecialidad(especialidad);
    }

// Método para llenar una tabla con instructores por especialidad
    public DefaultTableModel obtenerTablaInstructoresPorEspecialidad(String especialidad) {
        List<Instructor> instructores = listarPorEspecialidad(especialidad);

        String[] columnas = {"Cédula", "Nombre", "Especialidad", "Correo", "Celular", "Sucursal"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Instructor ins : instructores) {
            Object[] fila = {
                ins.getCedula(),
                ins.getNombre(),
                ins.getEspecialidad(),
                ins.getCorreo(),
                ins.getNumero_Celular(),
                (ins.getSucursal() != null) ? ins.getSucursal() : "No asociada"
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

}*/

import Datos.InstructorDAO;
import Modelo.Instructor;
import Modelo.Cliente;
import AccesoDatos.Coleccion_Cliente;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de Instructor usando base de datos Oracle
 * @author Ismarck
 */

public class Controlador_Instructor {

     private InstructorDAO instructorDAO;
    private Coleccion_Cliente coleccionCliente;

    // Constructor con conexión y colección existente
    public Controlador_Instructor(Connection conn, Coleccion_Cliente coleccionCliente) {
        this.instructorDAO = new InstructorDAO(conn);
        this.coleccionCliente = coleccionCliente;
    }
    
    // Constructor solo con conexión - CORREGIDO
    public Controlador_Instructor(Connection conn) {
        this.instructorDAO = new InstructorDAO(conn);
        // Crear colección vacía o buscar otra solución
        this.coleccionCliente = new Coleccion_Cliente(new ArrayList<>());
    }

    // Registrar instructor
    public boolean registrarInstructor(Instructor ins) {
        try {
            instructorDAO.insertarInstructor(ins);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Modificar instructor
    public boolean modificarInstructor(Instructor ins) {
        try {
            instructorDAO.modificarInstructor(ins);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar instructor
    public boolean eliminarInstructor(int cedula) {
        try {
            instructorDAO.eliminarInstructor(cedula);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Buscar instructor por cédula
    public Instructor buscarInstructor(int cedula) {
        try {
            List<Instructor> lista = instructorDAO.listarInstructores();
            for (Instructor i : lista) {
                if (i.getCedula() == cedula) {
                    return i;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listar todos los instructores
    public List<Instructor> listar() {
        try {
            return instructorDAO.listarInstructores();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Listar instructores por especialidad
    public List<Instructor> listarPorEspecialidad(String especialidad) {
        List<Instructor> resultado = new ArrayList<>();
        try {
            for (Instructor i : instructorDAO.listarInstructores()) {
                if (i.getEspecialidad().equalsIgnoreCase(especialidad)) {
                    resultado.add(i);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    public List<Instructor> buscarPorSucursal(int codigoSucursal) {
        try {
            return instructorDAO.listarPorSucursal(codigoSucursal);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    
   

    // Obtener tabla de instructores por especialidad
    public DefaultTableModel obtenerTablaInstructoresPorEspecialidad(String especialidad) {
        List<Instructor> instructores = listarPorEspecialidad(especialidad);

        String[] columnas = {"Cédula", "Nombre", "Especialidad", "Correo", "Celular", "Sucursal"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Instructor ins : instructores) {
            Object[] fila = {
                ins.getCedula(),
                ins.getNombre(),
                ins.getEspecialidad(),
                ins.getCorreo(),
                ins.getNumero_Celular(),
                (ins.getSucursal() != null) ? ins.getSucursal().getCodigo() + " - " + ins.getSucursal().getProvincia() : "No asociada"
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

    // Listar clientes por instructor
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

        return resultado;
    }

    // Obtener tabla de clientes por instructor
    public DefaultTableModel obtenerTablaClientesPorInstructor(String nombreInstructor) {
        List<Cliente> clientes = listarClientesPorInstructor(nombreInstructor);

        String[] columnas = {"Cedula", "Nombre", "Sexo", "Nacimiento", "Instructor", "Sucursal", "Correo", "Celular", "Inscripcion"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

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
    
    // En Controlador_Instructor
    public List<Instructor> getListaInstructores() {
        try {
            // Llamamos al DAO que hace la consulta a la base de datos
            return instructorDAO.listarInstructores();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Retornamos lista vacía si hay error
        }
    }

    
}

