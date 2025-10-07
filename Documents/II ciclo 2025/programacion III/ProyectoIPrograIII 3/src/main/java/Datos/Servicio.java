/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author marcosisaacarayaabarca
 */

//import LogicaDeNegocio.Libro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servicio {
    
    protected Connection conexion= null;
    
    public Servicio() {
        
    }

    protected void conectar() {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "PROYECTO";
        String password = "proyecto123";
        conexion = DriverManager.getConnection(url, username, password);
        conexion.setAutoCommit(true);
        System.out.println("¡Conexión exitosa a Oracle XE!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    protected void desconectar() throws SQLException{
        if(!conexion.isClosed())
        {
            conexion.close();
        }
    }

    
    public Connection getConexion() {
    if (conexion == null) {
        conectar();
    }
    return conexion;
}

    
}