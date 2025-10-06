/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Modelo.Cliente;
import Modelo.Ejercicio;
import Modelo.Rutina;
import java.util.List;
import java.util.Random;



/**
 *
 * @author marcosisaacarayaabarca
 */
public class Coleccion_Rutina {
    
     private Coleccion_Ejercicios coleccionEjercicios;
     
    public Coleccion_Rutina(Coleccion_Ejercicios coleccionEjercicios) {
        this.coleccionEjercicios = coleccionEjercicios;
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
