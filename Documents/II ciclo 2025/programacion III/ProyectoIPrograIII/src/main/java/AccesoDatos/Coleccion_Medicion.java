package AccesoDatos;

import Modelo.Medicion;
import java.util.ArrayList;
import java.util.List;

public class Coleccion_Medicion {
    private List<Medicion> lista;

    public Coleccion_Medicion(List<Medicion> lista) {
        this.lista = lista;
    }

    private static final int MAX_MEDICIONES = 10;

    // Insertar Medición
    public boolean insertar(Medicion m) {
        if (lista.size() >= MAX_MEDICIONES) {
            return false; // límite alcanzado
        }
        lista.add(m);
        return true;
    }

    // Modificar Medición por índice
    public boolean modificar(int indice, Medicion nueva) {
        if (indice >= 0 && indice < lista.size()) {
            lista.set(indice, nueva);
            return true;
        }
        return false;
    }

    // Eliminar Medición por índice
    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            return true;
        }
        return false;
    }

    // Buscar Medición por índice
    public Medicion buscar(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        return null;
    }

    // Listar todas las mediciones
    public List<Medicion> listar() {
        return new ArrayList<>(lista); // devolvemos copia para seguridad
    }
}
