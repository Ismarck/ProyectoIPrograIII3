
package Modelo;
import java.util.List;
import Modelo.Rutina;

/**
 *
 * @author porto
 */

public class Rutina {
    
    private List<Ejercicio> listaEjercicios;

    public Rutina() {
    }

    public Rutina(List<Ejercicio> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }

    public List<Ejercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    public void setListaEjercicios(List<Ejercicio> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }

    @Override
    public String toString() {
        return "Rutina {" +
                "listaEjercicios=" + listaEjercicios +
                '}';
    }
}