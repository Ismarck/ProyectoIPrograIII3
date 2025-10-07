/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import Modelo.Cliente;
import Modelo.Instructor;
import Modelo.Sucursal;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class ClienteDAO {
    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    // INSERTAR CLIENTE
    public void insertarCliente(Cliente c) throws SQLException {
        CallableStatement csPersona = conn.prepareCall("{call insertarPersona(?,?,?,?,?,?)}");
        csPersona.setLong(1, c.getCedula());
        csPersona.setString(2, c.getNombre());
        csPersona.setDate(3, convertirFecha(c.getFecha_Nacimiento()));
        csPersona.setString(4, c.getCorreo());
        csPersona.setString(5, String.valueOf(c.getNumero_Celular()));
        csPersona.setString(6, String.valueOf(c.getSexo()));
        csPersona.execute();
        csPersona.close();
        
        CallableStatement cs = conn.prepareCall("{call insertarCliente(?,?,?,?)}");
        cs.setLong(1, c.getCedula());

        // Convertir String a java.sql.Date
        java.sql.Date sqlDate = convertirFecha(c.getFecha_Inscripcion());
        cs.setDate(2, sqlDate);

        // Pasar solo identificadores
        cs.setLong(3, c.getInstructorAsignado().getCedula());
        cs.setInt(4, c.getSucursal().getCodigo());

        cs.execute();
        cs.close();
    }

    // MODIFICAR CLIENTE
    public void modificarCliente(Cliente c) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call modificarCliente(?,?,?,?)}");
        cs.setLong(1, c.getCedula());
        cs.setDate(2, convertirFecha(c.getFecha_Inscripcion()));
        cs.setLong(3, c.getInstructorAsignado().getCedula());
        cs.setInt(4, c.getSucursal().getCodigo());
        cs.execute();
        cs.close();
    }
    
    // BUSCAR CLIENTES POR SUCURSAL
    /*public List<Cliente> buscarClientesPorSucursal(int codigoSucursal) throws SQLException {
    List<Cliente> lista = new ArrayList<>();

    // Llamada a función que devuelve cursor
    CallableStatement cs = conn.prepareCall("{ ? = call listarClientesPorSucursal(?) }");

    // Primer parámetro = el cursor de salida
    cs.registerOutParameter(1, OracleTypes.CURSOR);
    cs.setInt(2, codigoSucursal);

    cs.execute();

    ResultSet rs = (ResultSet) cs.getObject(1);

    while (rs.next()) {
        Instructor instructor = new Instructor();
        instructor.setCedula(rs.getInt("INSTRUCTOR_ASIGNADO"));

        Sucursal sucursal = new Sucursal();
        sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));
         //sucursal.setProvincia(rs.getString("PROVINCIA"));
         //sucursal.setCanton(rs.getString("CANTON"));

        Cliente c = new Cliente(
            rs.getString("FECHA_INSCRIPCION"),
            rs.getString("NOMBRE"),
            rs.getString("FECHA_NACIMIENTO"),
            rs.getString("CORREO"),
            rs.getInt("NUMERO_CELULAR"),
            rs.getInt("CEDULA"),
            rs.getString("SEXO").charAt(0),
            instructor,
            sucursal
        );

        lista.add(c);
    }

    rs.close();
    cs.close();

    return lista;
}*/
    public List<Cliente> buscarClientesPorSucursal(int codigoSucursal) throws SQLException {
    List<Cliente> lista = new ArrayList<>();

    // Llamada a la función Oracle que devuelve un cursor
    CallableStatement cs = conn.prepareCall("{ ? = call listarClientesPorSucursal(?) }");

    // Registrar el primer parámetro como cursor de salida
    cs.registerOutParameter(1, OracleTypes.CURSOR);
    cs.setInt(2, codigoSucursal);

    cs.execute();

    // Recuperar el cursor
    ResultSet rs = (ResultSet) cs.getObject(1);

    while (rs.next()) {
        // Obtener y formatear la fecha de nacimiento
        java.sql.Date fechaNac = rs.getDate("FECHA_NACIMIENTO");
        String fechaNacStr = (fechaNac != null) ? fechaNac.toString() : "Sin fecha";

        // Crear el objeto Instructor asignado (puede ser null)
        Instructor instructor = new Instructor();
        instructor.setCedula(rs.getInt("INSTRUCTOR_ASIGNADO"));
        instructor.setNombre(rs.getString("NOMBRE_INSTRUCTOR"));

        // Crear el objeto Sucursal
        Sucursal sucursal = new Sucursal();
        sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));

        // Crear el cliente completo
        Cliente c = new Cliente(
            rs.getString("FECHA_INSCRIPCION"),     // Fecha de inscripción
            rs.getString("NOMBRE"),                // Nombre del cliente
            fechaNacStr,                           // Fecha de nacimiento formateada
            rs.getString("CORREO"),                // Correo
            rs.getInt("NUMERO_CELULAR"),           // Celular
            rs.getInt("CEDULA"),                   // Cédula
            rs.getString("SEXO").charAt(0),        // Sexo (primer carácter)
            instructor,                            // Instructor asignado
            sucursal                               // Sucursal del cliente
        );

        lista.add(c);
    }

    // Cerrar recursos
    rs.close();
    cs.close();

    return lista;
}


    // ELIMINAR CLIENTE
    public void eliminarCliente(long cedula) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call eliminarCliente(?)}");
        cs.setLong(1, cedula);
        cs.execute();
        cs.close();
    }

    // LISTAR CLIENTES
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        CallableStatement cs = conn.prepareCall("{call listarClientes(?)}");
        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.execute();

        ResultSet rs = (ResultSet) cs.getObject(1);
        while(rs.next()) {
            // Crear objetos Instructor y Sucursal usando solo sus IDs (o ajusta según necesites)
            Instructor instructor = new Instructor();
            //instructor.setCedula(rs.getLong("INSTRUCTOR_ASIGNADO"));
            instructor.setCedula((int) rs.getLong("INSTRUCTOR_ASIGNADO"));

            Sucursal sucursal = new Sucursal();
            sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));

            // Convertir fecha SQL a String
            String fechaStr = rs.getDate("FECHA_INSCRIPCION").toString();

            Cliente c = new Cliente(
                    fechaStr,
                    rs.getString("NOMBRE"),
                    rs.getString("FECHA_NACIMIENTO"),
                    rs.getString("CORREO"),
                    rs.getInt("NUMERO_CELULAR"),
                    rs.getInt("CEDULA"),
                    rs.getString("SEXO").charAt(0),
                    instructor,
                    sucursal
            );

            lista.add(c);
        }
        rs.close();
        cs.close();
        return lista;
    }

    
    public List<Cliente> buscarClientesPorNombreLista(String nombre) throws SQLException {
    List<Cliente> lista = new ArrayList<>();
    CallableStatement cs = conn.prepareCall("{call buscarClientesPorNombre(?, ?)}");
    cs.setString(1, nombre);
    cs.registerOutParameter(2, OracleTypes.CURSOR);
    cs.execute();

    ResultSet rs = (ResultSet) cs.getObject(2);
    while(rs.next()) {
        Instructor instructor = new Instructor();
        instructor.setCedula(rs.getInt("INSTRUCTOR_ASIGNADO"));
        instructor.setNombre(rs.getString("NOMBRE_INSTRUCTOR"));

        Sucursal sucursal = new Sucursal();
        sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));

        Cliente c = new Cliente(
            rs.getString("FECHA_INSCRIPCION"),
            rs.getString("NOMBRE"),
            rs.getString("FECHA_NACIMIENTO"),
            rs.getString("CORREO"),
            rs.getInt("NUMERO_CELULAR"),
            rs.getInt("CEDULA"),
            rs.getString("SEXO").charAt(0),
            instructor,
            sucursal
        );
        lista.add(c);
    }
    rs.close();
    cs.close();
    return lista;
}


    /* mejorpublic List<Cliente> buscarClientesPorNombre(String nombre) throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        CallableStatement cs = conn.prepareCall("{call buscarClientesPorNombre(?, ?)}");
        cs.setString(1, nombre);
        cs.registerOutParameter(2, OracleTypes.CURSOR);
        cs.execute();

        ResultSet rs = (ResultSet) cs.getObject(2);
        while (rs.next()) {
            Instructor instructor = new Instructor();
            instructor.setCedula(rs.getInt("INSTRUCTOR_ASIGNADO"));

            Sucursal sucursal = new Sucursal();
            sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));

            Cliente c = new Cliente(
                    rs.getString("FECHA_INSCRIPCION"),
                    rs.getString("NOMBRE"),
                    rs.getString("FECHA_NAC"),
                    rs.getString("CORREO"),
                    rs.getInt("TELEFONO"),
                    rs.getInt("CEDULA"),
                    rs.getString("SEXO").charAt(0),
                    instructor,
                    sucursal
            );
            lista.add(c);
        }
        rs.close();
        cs.close();
        return lista;
    }/*
    public List<Cliente> buscarClientesPorNombre(String nombre) throws SQLException {
    List<Cliente> lista = new ArrayList<>();

    // Llamada al procedimiento Oracle que devuelve un cursor
    CallableStatement cs = conn.prepareCall("{call buscarClientesPorNombre(?, ?)}");
    cs.setString(1, nombre);
    cs.registerOutParameter(2, OracleTypes.CURSOR);
    cs.execute();

    // Obtener el ResultSet desde el cursor de salida
    ResultSet rs = (ResultSet) cs.getObject(2);

    // --- Aquí va tu while ---
    while (rs.next()) {
        Instructor instructor = new Instructor();
        instructor.setCedula(rs.getInt("INSTRUCTOR_ASIGNADO"));
        instructor.setNombre(rs.getString("NOMBRE_INSTRUCTOR"));

        Sucursal sucursal = new Sucursal();
        sucursal.setCodigo(rs.getInt("SUCURSAL_COD"));

        Cliente c = new Cliente(
            rs.getString("FECHA_INSCRIPCION"),
            rs.getString("NOMBRE"),
            rs.getString("FECHA_NACIMIENTO"),
            rs.getString("CORREO"),
            rs.getInt("NUMERO_CELULAR"),
            rs.getInt("CEDULA"),
            rs.getString("SEXO").charAt(0),
            instructor,
            sucursal
        );
        lista.add(c);
    }
    // --- fin del while ---

    rs.close();
    cs.close();

    return lista;
}*/


    /*public Cliente buscarClientePorNombreUnico(String nombre) throws SQLException {
        List<Cliente> encontrados = buscarClientesPorNombre(nombre);
        return !encontrados.isEmpty() ? encontrados.get(0) : null;
    }*/
    
    public Cliente buscarClientePorNombreUnico(String nombre) throws SQLException {
    List<Cliente> lista = buscarClientesPorNombreLista(nombre); // ahora sí existe
    return !lista.isEmpty() ? lista.get(0) : null;
}

    /*public Cliente buscarClientePorNombreUnico(String nombre) throws SQLException {
    List<Cliente> lista = buscarClientesPorNombre(nombre); // usa tu método actual
    return !lista.isEmpty() ? lista.get(0) : null;
}*/


    // Método auxiliar para convertir String a java.sql.Date
    private java.sql.Date convertirFecha(String fechaStr) {
        if (fechaStr == null || fechaStr.isEmpty()) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fecha = sdf.parse(fechaStr);
            return new java.sql.Date(fecha.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
