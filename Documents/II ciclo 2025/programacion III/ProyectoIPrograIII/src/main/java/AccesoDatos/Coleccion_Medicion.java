/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Modelo.Medicion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
/*
public class Coleccion_Medicion {
    private String id;
    private String nombre;
    private List<Medicion> historialMediciones = new ArrayList<>();
    private static final int MAX_MEDICIONES = 10;

    // CREATE
    public boolean agregarMedicion(Medicion m) {
        if(historialMediciones.size() < MAX_MEDICIONES) {
            m.setId(historialMediciones.size() + 1); // autoincrement simple
            historialMediciones.add(m);
            return true;
        }
        return false; // ya alcanzó el límite
    }

    // READ
    public Medicion buscarMedicion(int id) {
        return historialMediciones.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Medicion> listarMediciones() {
        return historialMediciones;
    }

    // UPDATE
    public boolean actualizarMedicion(int id, Medicion nueva) {
        for(int i=0; i < historialMediciones.size(); i++) {
            if(historialMediciones.get(i).getId() == id) {
                nueva.setId(id);
                historialMediciones.set(i, nueva);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean eliminarMedicion(int id) {
        return historialMediciones.removeIf(m -> m.getId() == id);
    }
}
*/