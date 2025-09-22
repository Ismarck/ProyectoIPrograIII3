package Modelo;

import java.util.List;
import Modelo.Rutina;
import java.util.ArrayList;



/**
 *
 * @author porto
 */

public class Rutina {

    private Cliente cliente;
    private List<Ejercicio> ejercicios;

    public Rutina(Cliente cliente) {
        this.cliente = cliente;
        this.ejercicios = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void agregarEjercicio(Ejercicio e) {
        ejercicios.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rutina de ").append(cliente.getNombre()).append(":\n");
        for (Ejercicio e : ejercicios) {
            sb.append("- ").append(e).append("\n");
        }
        return sb.toString();
    }
}
