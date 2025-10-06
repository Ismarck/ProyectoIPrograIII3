/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

/**
 *
 * @author marcosisaacarayaabarca
 */
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import Modelo.Ejercicio;
import Modelo.Rutina;
import java.util.Random;

public class Coleccion_Ejercicios {
    private List<Ejercicio> ejercicios;

    public Coleccion_Ejercicios() {
        ejercicios = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio e) throws Exception {
        if(e.getNombre().isEmpty() || e.getArea().isEmpty())
            throw new Exception("Ejercicio o área no puede estar vacío");
        ejercicios.add(e);
    }

    public List<Ejercicio> getEjerciciosPorArea(String area) {
        List<Ejercicio> lista = new ArrayList<>();
        for(Ejercicio e : ejercicios) {
            if(e.getArea().equalsIgnoreCase(area)) lista.add(e);
        }
        return lista;
    }
   
    public List<Ejercicio> getTodos() {
        return ejercicios;
    }
}
