/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;
import AccesoDatos.Coleccion_Cliente;
import AccesoDatos.Coleccion_Sucursal;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcosisaacarayaabarca
 */
/*public class Controlador_Cliente {
    
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
    
    public List<Cliente> buscarpornombre(String nombre) {
        return coleccionCliente.buscarPorNombre(nombre);
    }
    
    public Cliente buscarpornombreunico(String nombre) {
        return coleccionCliente.buscarClientePorNombreUnico(nombre);
    }

    public boolean modificar(Cliente c) {
        return coleccionCliente.Modificar(c);
    }
   
    public java.util.List<Cliente> listar() {
        return coleccionCliente.Listar();
    }
    
   public int cantidadClasesMatriculadas(Cliente c) {
        return coleccionCliente.cantidadClasesMatriculadas(c);
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

}*/


import Datos.ClienteDAO;
import Modelo.Cliente;
import Modelo.Instructor;
import Modelo.Sucursal;
import java.sql.Connection;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controlador_Cliente {

    private ClienteDAO clienteDAO;

    /*public Controlador_Cliente(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }*/
    
    public Controlador_Cliente(Connection conn) {
        this.clienteDAO = new ClienteDAO(conn);
    }

    // Registrar Cliente
    public boolean registrar(Cliente c) {
        try {
            clienteDAO.insertarCliente(c);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Modificar Cliente
    public boolean modificar(Cliente c) {
        try {
            clienteDAO.modificarCliente(c);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar Cliente
    public boolean eliminar(long cedula) {
        try {
            clienteDAO.eliminarCliente(cedula);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar Clientes
    public List<Cliente> listar() {
        try {
            return clienteDAO.listarClientes();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    // Cantidad de clases matriculadas
    public int cantidadClasesMatriculadas(Cliente c) {
        if (c == null || c.getClasesMatriculadas() == null) return 0;
        return c.getClasesMatriculadas().size();
    }

    // Obtener tabla de clientes (para JTable)
    public DefaultTableModel obtenerTablaClientesPorNombre(String nombre) {
        List<Cliente> clientes = buscarPorNombre(nombre);

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
                    (c.getSucursal() != null) ? c.getSucursal().getCodigo() + " - " + c.getSucursal().getProvincia() : "No asociada",
            });
        }

        return modelo;
    }
    
    public List<Cliente> buscarClientesPorSucursal(int codigoSucursal) {
        try {
            return clienteDAO.buscarClientesPorSucursal(codigoSucursal);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public DefaultTableModel obtenerTablaClientesPorSucursal(int codigoSucursal) {
        List<Cliente> clientes = buscarClientesPorSucursal(codigoSucursal);

        String[] columnas = {"Sucursal", "Nombre", "Sexo", "Nacimiento", "Instructor", "Cedula", "Correo", "Celular", "Inscripcion"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Cliente c : clientes) {
            modelo.addRow(new Object[]{
                    (c.getSucursal() != null) ? c.getSucursal().getCodigo() + " - " + c.getSucursal().getProvincia() : "No asociada",
                    c.getNombre(),
                    c.getSexo(),
                    c.getFecha_Nacimiento(),
                    (c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
                    c.getCedula(),
                    c.getCorreo(),
                    c.getNumero_Celular(),
                    c.getFecha_Inscripcion(),
            });
        }

        return modelo;
    }


    // Buscar cliente por cédula
    public Cliente buscar(long cedula) {
        List<Cliente> lista = listar();
        for (Cliente c : lista) {
            if (c.getCedula() == cedula) return c;
        }
        return null;
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        try {
            return clienteDAO.buscarClientesPorNombre(nombre);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Cliente buscarPorNombreUnico(String nombre) {
        try {
            return clienteDAO.buscarClientePorNombreUnico(nombre);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}




