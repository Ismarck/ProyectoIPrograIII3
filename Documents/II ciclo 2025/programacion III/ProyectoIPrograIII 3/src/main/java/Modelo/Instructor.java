package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Instructor extends Persona {

    private String Especialidad;
    private List<Cliente> listaClientes;
    //Marcos llamado nuevo
    //private String sucursal;
    private Sucursal sucursal;

    public Instructor() {
    }

    public Instructor(String Especialidad,String Nombre, String Fecha_Nacimiento, String Correo, int Numero_Celular, int Cedula, char Sexo, /*String*/ Sucursal sucursal) {
        super(Nombre,Fecha_Nacimiento, Correo, Numero_Celular, Cedula, Sexo);
        this.Especialidad = Especialidad;
        listaClientes = new ArrayList<>();
        this.sucursal = sucursal;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
    
    // Métodos para manejar clientes
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente c) {
        if (!listaClientes.contains(c)) {
            listaClientes.add(c);
        }
    }
    
    public /*String*/ Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(/*String*/ Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public Instructor(int Cedula) {
        super(Cedula);
    }
    
    @Override
    public String toString() {
        return getNombre();
    }
    
    

    @Override
    public String Datos() {
       return "Instructor {" +
           "Cedula=" + getCedula() +
           ", Nombre=" + getNombre() +  
           ", Sexo=" + getSexo() +
           ", Fecha_Nacimiento='" + getFecha_Nacimiento() + '\'' +
           ", Correo='" + getCorreo() + '\'' +
           ", Numero_Celular=" + getNumero_Celular() +
           ", Especialidad='" + getEspecialidad() + '\'' +
               
           '}';
    }
    
    /*public static void main(String[] args) 
    {
        Instructor instructor1 = new Instructor(
        "CrossFit",
         "Benji",
        "2000-12-07",
        "benjacol@gmail.com",
        88776655,
        123456789,
        'M',
        "Heredia"      
        );
        
        System.out.println(instructor1.Datos());
    }*/
    public static void main(String[] args) {
        // Crear la sucursal
        Sucursal sucursal1 = new Sucursal();
        sucursal1.setProvincia("Heredia");
        sucursal1.setCanton("Heredia");
        sucursal1.setCodigo(1); // Ejemplo de código

        // Crear el instructor vinculándolo a la sucursal
        Instructor instructor1 = new Instructor(
                "CrossFit",
                "Benji",
                "2000-12-07",
                "benjacol@gmail.com",
                88776655,
                123456789,
                'M',
                sucursal1 // Ahora es un objeto Sucursal
        );

        System.out.println(instructor1.Datos());
    }

}
