package Modelo;

/**
 *
 * @author marcosisaacarayaabarca
 */

public class Ejercicio {
    private String nombre;
    private String area;

    public Ejercicio(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    @Override
    public String toString() {
        return nombre + " (" + area + ")";
    }
}
