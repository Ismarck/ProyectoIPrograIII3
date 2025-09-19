package Modelo;
import Modelo.Sucursal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Cliente extends Persona {


    private String Fecha_Inscripcion;
    private Instructor InstructorAsignado;
    private Sucursal sucursal;
    private List<ClaseGrupal> clasesMatriculadas; 


    public Cliente() {
    }

    public Cliente(String Fecha_Inscripcion, String Nombre, String Fecha_Nacimiento, String Correo, int Numero_Celular, int Cedula, char Sexo, Instructor InstructorAsignado ,Sucursal sucursal) {
        super(Nombre,Fecha_Nacimiento, Correo, Numero_Celular, Cedula, Sexo);
        this.Fecha_Inscripcion = Fecha_Inscripcion;
        this.InstructorAsignado = InstructorAsignado;
        this.sucursal = sucursal;
        this.clasesMatriculadas = new ArrayList<>(); 
    }
     
    public String getFecha_Inscripcion() {
        return Fecha_Inscripcion;
    }

    
    public void setFecha_Inscripcion(String Fecha_Inscripcion) {
        this.Fecha_Inscripcion = Fecha_Inscripcion;
    }
    
    
    public Instructor getInstructorAsignado() {
        return InstructorAsignado;
    }

    public void setInstructorAsignado(Instructor InstructorAsignado) {
        this.InstructorAsignado = InstructorAsignado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
     public List<ClaseGrupal> getClasesMatriculadas() {
        return clasesMatriculadas;
    }

    public boolean agregarClase(ClaseGrupal clase) {
        if (!clasesMatriculadas.contains(clase) && clasesMatriculadas.size() < 3) {
            clasesMatriculadas.add(clase);
            return true;
        }
        return false;
    }
    
    @Override
    public String Datos() {
    return "Cliente {" +
           "Cedula=" + getCedula() +
           ", Nombre=" + getNombre() +  
           ", Sexo=" + getSexo() +
           ", Fecha_Nacimiento='" + getFecha_Nacimiento() + '\'' +
           ", Correo='" + getCorreo() + '\'' +
           ", Numero_Celular=" + getNumero_Celular() +
           ", Fecha_Inscripcion='" + Fecha_Inscripcion + '\'' +
            ", Instructor Asignado='" + InstructorAsignado.Datos()+ '\'' +
            ", Sucursal Asociada = '"+ sucursal.toString() + '\'' +
           '}';
    }
    /*
    public static void main(String[] args) {
        
        Instructor instructor1 = new Instructor(
        "CrossFit",
         "Benji",
        "2000-12-07",
        "benjacol@gmail.com",
        88776655,
        123456789,
        'M'
        );
        
        /*Sucursal sucursal1 = new Sucursal(
                "Alajuela",
                "City Mall",
                20101,
                instructor1
        );
        
        
        
        Cliente cliente1 = new Cliente(
                
            "2023-05-12",    
            "Marquitos",
            "2000-10-15",    
            "prueba@gmail.com", 
            88887777,        
            123456789,       
            'M',
            instructor1,
            sucursal1
        );

        System.out.println(cliente1.Datos());
    }*/
    
}

