package Modelo;
import Modelo.Instructor;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Sucursal {

    private String Provincia;
    private String Canton;
    private int Codigo;
    private Instructor instructor;
    
    public Sucursal() {
    }

    public Sucursal(String Provincia, String Canton, int Codigo, Instructor instructor) {
        this.Provincia = Provincia;
        this.Canton = Canton;
        this.Codigo = Codigo;
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getCanton() {
        return Canton;
    }

    public void setCanton(String Canton) {
        this.Canton = Canton;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "Provincia=" + Provincia + ", Canton=" + Canton + ", Codigo=" + Codigo + "Instructor= "+ instructor +'}';
    }
    

    
}
