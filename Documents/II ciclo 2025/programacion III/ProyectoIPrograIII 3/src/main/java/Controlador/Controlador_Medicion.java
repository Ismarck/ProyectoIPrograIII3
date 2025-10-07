
package Controlador;

import AccesoDatos.Coleccion_Medicion;
import Modelo.Medicion;
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
    
    public double obtenerIMC(int indice) {
        return coleccion.calcularIMC(indice);
    }

    // Listar todas las mediciones
    public List<Medicion> listar() {
        return coleccion.listar();
    }
    
   public DefaultTableModel obtenerTablaMedicionesPorCliente(String nombreCliente) {
    List<Medicion> mediciones = this.coleccion.buscarMedicionesPorCliente(nombreCliente);

    String[] columnas = {"Fecha", "Peso", "Estatura", "% Grasa", "% Musculo", "Grasa Visceral", "Edad Metabolica", "Cintura", "Cadera", "Pecho", "Muslo"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    for (Medicion m : mediciones) {
        Object[] fila = {
            m.getFecha(),
            m.getPeso(),
            m.getEstatura(),
            m.getPorcentajeGrasa(),
            m.getPorcentajeMusculo(),
            m.getGrasaVisceral(),
            m.getEdadMetabolica(),
            m.getCintura(),
            m.getCadera(),
            m.getPecho(),
            m.getMuslo()
        };
        modelo.addRow(fila);
    }
    return modelo;
}

    
}
