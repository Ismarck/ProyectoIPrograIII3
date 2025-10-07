/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author marcosisaacarayaabarca
 */
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

    public Controlador_Cliente(Connection conn) {
        this.clienteDAO = new ClienteDAO(conn);
    }

    public boolean registrar(Cliente c) {
        try {
            clienteDAO.insertarCliente(c);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificar(Cliente c) {
        try {
            clienteDAO.modificarCliente(c);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(long cedula) {
        try {
            clienteDAO.eliminarCliente(cedula);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cliente> listar() {
        try {
            return clienteDAO.listarClientes();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public int cantidadClasesMatriculadas(Cliente c) {
        if (c == null || c.getClasesMatriculadas() == null) {
            return 0;
        }
        return c.getClasesMatriculadas().size();
    }

    public DefaultTableModel obtenerTablaClientesPorNombre(String nombre) {
        List<Cliente> clientes = buscarPorNombre(nombre);

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Cedula", "Nombre", "Sexo", "Correo", "Celular", "Inscripcion", "Instructor", "Sucursal"}, 0
        );

        for (Cliente c : clientes) {
            modelo.addRow(new Object[]{
                c.getCedula(),
                c.getNombre(),
                c.getSexo(),
                //c.getFecha_Nacimiento(),
                c.getCorreo(),
                c.getNumero_Celular(),
                c.getFecha_Inscripcion(),
                (c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
                (c.getSucursal() != null) ? c.getSucursal().getCodigo() : "No asociada",});
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
        String[] columnas = {"Sucursal", "Cedula", "Nombre", "Sexo", "Instructor", "Correo", "Celular", "Inscripcion"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        try {
            List<Cliente> clientes = clienteDAO.buscarClientesPorSucursal(codigoSucursal);

            for (Cliente c : clientes) {
                modelo.addRow(new Object[]{
                    (c.getSucursal() != null) ? c.getSucursal().getCodigo() : "No asociada",
                    c.getCedula(),
                    c.getNombre(),
                    c.getSexo(),
                    //c.getFecha_Nacimiento(),
                    (c.getInstructorAsignado() != null) ? c.getInstructorAsignado().getNombre() : "No asignado",
                    c.getCorreo(),
                    c.getNumero_Celular(),
                    c.getFecha_Inscripcion()
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return modelo;
    }

    public Cliente buscar(long cedula) {
        List<Cliente> lista = listar();
        for (Cliente c : lista) {
            if (c.getCedula() == cedula) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        try {
            return clienteDAO.buscarClientesPorNombreLista(nombre);
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
