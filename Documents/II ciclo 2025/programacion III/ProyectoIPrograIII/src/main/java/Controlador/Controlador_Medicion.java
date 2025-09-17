/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import AccesoDatos.Coleccion_Medicion;
import Modelo.Medicion;
import java.util.List;

public class Controlador_Medicion {
    private Coleccion_Medicion coleccion;

    public Controlador_Medicion(Coleccion_Medicion coleccion) {
        this.coleccion = coleccion;
    }

    // Registrar una nueva medición
    public boolean registrarMedicion(Medicion m) {
        return coleccion.insertar(m);
    }

    // Eliminar medición por índice
    public boolean eliminarMedicion(int indice) {
        return coleccion.eliminar(indice);
    }

    // Buscar medición por índice
    public Medicion buscarMedicion(int indice) {
        return coleccion.buscar(indice);
    }

    // Modificar medición por índice
    public boolean modificarMedicion(int indice, Medicion m) {
        return coleccion.modificar(indice, m);
    }

    // Listar todas las mediciones
    public List<Medicion> listar() {
        return coleccion.listar();
    }
}
