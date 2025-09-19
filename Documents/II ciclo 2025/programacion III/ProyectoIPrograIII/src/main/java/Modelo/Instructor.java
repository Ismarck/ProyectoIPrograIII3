package Modelo;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Instructor extends Persona {

    private String Especialidad;
    private Sucursal sucursal;

    public Instructor() {
    }

    public Instructor(String Especialidad,String Nombre, String Fecha_Nacimiento, String Correo, int Numero_Celular, int Cedula, char Sexo, Sucursal sucursal) {
        super(Nombre,Fecha_Nacimiento, Correo, Numero_Celular, Cedula, Sexo);
        this.Especialidad = Especialidad;
        this.sucursal = sucursal;
    }
    
    // Getter y Setter de sucursal
    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
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
        'M'
        );
        
        System.out.println(instructor1.Datos());
    }*/
}
