/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

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
 *
 * @author Ismarck
 */
public class Controlador_Instructor {

    private InstructorDAO instructorDAO;
    private Coleccion_Cliente coleccionCliente;
    private Controlador_Sucursal controladorSucursal;

    public Controlador_Instructor(Connection conn, Coleccion_Cliente coleccionCliente, Controlador_Sucursal controladorSucursal) {
        this.instructorDAO = new InstructorDAO(conn);
        this.coleccionCliente = coleccionCliente;
        this.controladorSucursal = controladorSucursal;
    }

    public Controlador_Instructor(Connection conn) {
        this.instructorDAO = new InstructorDAO(conn);
        this.coleccionCliente = new Coleccion_Cliente(new ArrayList<>());
    }

    public List<Instructor> buscarPorSucursal(int codigoSucursal) throws Exception {
        return instructorDAO.listarPorSucursal(codigoSucursal);
    }

    public boolean registrarInstructor(Instructor ins) {
        try {
            instructorDAO.insertarInstructor(ins);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarInstructor(Instructor ins) {
        try {
            instructorDAO.modificarInstructor(ins);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarInstructor(int cedula) {
        try {
            instructorDAO.eliminarInstructor(cedula);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

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

    public List<Instructor> listar() {
        try {
            return instructorDAO.listarInstructores();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Instructor> listarPorEspecialidad(String especialidad) {

        try {

            return instructorDAO.listarPorEspecialidad(especialidad);

        } catch (SQLException e) {

            e.printStackTrace();

            return new ArrayList<>();

        }

    }

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

    public DefaultTableModel obtenerTablaClientesPorInstructor(String nombreInstructor) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = instructorDAO.listarClientesPorInstructorDB(nombreInstructor);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] columnas = {"Cedula", "Nombre", "Sexo", "Instructor", "Sucursal", "Correo", "Celular", "Inscripcion"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Cliente c : clientes) {
            Object[] fila = {
                c.getCedula(),
                c.getNombre(),
                c.getSexo(),
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

    public List<Instructor> getListaInstructores() {
        try {
            return instructorDAO.listarInstructores();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
