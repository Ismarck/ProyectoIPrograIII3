package Modelo;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Ejercicio {

    private String Nombre;
    private String Area_de_Ejercicio;
    private String Descripcion;

    public Ejercicio() {
    }

    public Ejercicio(String Nombre, String Area_de_Ejercicio, String Descripcion) {
        this.Nombre = Nombre;
        this.Area_de_Ejercicio = Area_de_Ejercicio;
        this.Descripcion = Descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getArea_de_Ejercicio() {
        return Area_de_Ejercicio;
    }

    public void setArea_de_Ejercicio(String Area_de_Ejercicio) {
        this.Area_de_Ejercicio = Area_de_Ejercicio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Ejercicio{" + "Nombre=" + Nombre + ", Area_de_Ejercicio=" + Area_de_Ejercicio + ", Descripcion=" + Descripcion + '}';
    }
}
