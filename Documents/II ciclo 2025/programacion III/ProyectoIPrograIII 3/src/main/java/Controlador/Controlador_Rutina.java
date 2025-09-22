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
import java.util.List;
import java.util.Random;
import Modelo.Ejercicio;
import Modelo.Cliente;
import Modelo.Rutina;

public class Controlador_Rutina {
    private Coleccion_Ejercicios coleccionEjercicios;

    public Controlador_Rutina(Coleccion_Ejercicios coleccion) {
        this.coleccionEjercicios = coleccion;
    }

    public void agregarEjercicio(String nombre, String area) throws Exception {
        coleccionEjercicios.agregarEjercicio(new Ejercicio(nombre, area));
    }

    public Rutina generarRutina(Cliente cliente) throws Exception {
        if(cliente == null) throw new Exception("Cliente no puede ser nulo");

        Rutina rutina = new Rutina(cliente);
        String[] areas = {"pecho y triceps", "biceps", "piernas", "espalda"};
        Random rand = new Random();

        for(String area : areas) {
            List<Ejercicio> ejerciciosArea = coleccionEjercicios.getEjerciciosPorArea(area);
            if(!ejerciciosArea.isEmpty()) {
                rutina.agregarEjercicio(ejerciciosArea.get(rand.nextInt(ejerciciosArea.size())));
            }
        }
        return rutina;
    }
}
