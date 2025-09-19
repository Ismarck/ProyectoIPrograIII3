package Modelo;

/**
 *
 * @author marcosisaacarayaabarca
 */
public abstract class Persona {

    private String Nombre;
    private String Fecha_Nacimiento;
    private String Correo;
    private int Numero_Celular;
    private int Cedula;
    private char Sexo;

    protected Persona() {
    }

    protected Persona(String Nombre,String Fecha_Nacimiento, String Correo, int Numero_Celular, int Cedula, char Sexo) {
        this.Nombre = Nombre;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Correo = Correo;
        this.Numero_Celular = Numero_Celular;
        this.Cedula = Cedula;
        this.Sexo = Sexo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getNumero_Celular() {
        return Numero_Celular;
    }

    public void setNumero_Celular(int Numero_Celular) {
        this.Numero_Celular = Numero_Celular;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    protected abstract String Datos();
}
