/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author marcosisaacarayaabarca
 */
import AccesoDatos.Coleccion_Ejercicios;
import AccesoDatos.Coleccion_Rutina;
import Modelo.Ejercicio;
import Modelo.Cliente;
import Modelo.Rutina;

public class Controlador_Rutina {

    private Coleccion_Ejercicios coleccionEjercicios;
    private Coleccion_Rutina coleccionrutina;

    public Controlador_Rutina(Coleccion_Ejercicios coleccion) {
        this.coleccionEjercicios = coleccion;
        this.coleccionrutina = new Coleccion_Rutina(coleccion);
    }

    public void agregarEjercicio(String nombre, String area) throws Exception {
        coleccionEjercicios.agregarEjercicio(new Ejercicio(nombre, area));
    }

    public Rutina generarRutina(Cliente cliente) throws Exception {
        return coleccionrutina.generarRutina(cliente);
    }

}
