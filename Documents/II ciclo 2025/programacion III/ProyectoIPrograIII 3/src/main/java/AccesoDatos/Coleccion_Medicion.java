package AccesoDatos;

import Modelo.Medicion;
import java.util.ArrayList;
import java.util.List;

public class Coleccion_Medicion {
    private List<Medicion> lista;
    
    private static final int MAX_MEDICIONES = 10;

    public Coleccion_Medicion(List<Medicion> lista) {
        this.lista = lista;
    }

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
    
    // Calcular IMC de una medición por índice
    public double calcularIMC(int indice) {
        Medicion m = buscar(indice);
        if (m != null && m.getEstatura() > 0) {
            return m.getPeso() / (m.getEstatura() * m.getEstatura());
        }
        return -1; // devuelve -1 si la medición no existe o estatura inválida
    }
    
    // Listar todas las mediciones
    public List<Medicion> listar() {
        return new ArrayList<>(lista); // devolvemos copia para seguridad
    }
    
    // Buscar medicion de cliente 
    public List<Medicion> buscarMedicionesPorCliente(String nombreCliente) {
        List<Medicion> resultado = new ArrayList<>();
        for (Medicion m : lista) {
            if (m.getCliente() != null && m.getCliente().getNombre().equalsIgnoreCase(nombreCliente)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

}
