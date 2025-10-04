package Modelo;
import Modelo.Instructor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */

public class Sucursal {

    private String Provincia;
    private String Canton;
    private int Codigo;
    private Instructor instructor;
    //private List<Cliente> clientes;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Instructor> listaInstructores = new ArrayList<>();
    
    public Sucursal() {
    }

    public Sucursal(String Provincia, String Canton, int Codigo, Instructor instructor) {
        this.Provincia = Provincia;
        this.Canton = Canton;
        this.Codigo = Codigo;
        this.instructor = instructor;
        //this.clientes = new ArrayList<>();
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
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    // En la clase Sucursal
//private List<Instructor> listaInstructores = new ArrayList<>();

    public void agregarInstructor(Instructor ins) {
        if (!listaInstructores.contains(ins)) {
            listaInstructores.add(ins);
        }
    }

    public List<Instructor> getListaInstructores() {
        return new ArrayList<>(listaInstructores);
    }

    @Override
    public String toString() {
        return Provincia + " - " + Canton + " (" + Codigo + ")";
    }
   
}
