package Modelo;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Instructor extends Persona {

    private String Especialidad;

    public Instructor() {
    }

    public Instructor(String Especialidad,String Nombre, String Fecha_Nacimiento, String Correo, int Numero_Celular, int Cedula, char Sexo) {
        super(Nombre,Fecha_Nacimiento, Correo, Numero_Celular, Cedula, Sexo);
        this.Especialidad = Especialidad;
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
    public static void main(String[] args) 
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
    }
}
