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
    private Sucursal sucursal;

    public Instructor() {
    }

    public Instructor(String Especialidad, String Nombre, String Fecha_Nacimiento, String Correo, int Numero_Celular, int Cedula, char Sexo, /*String*/ Sucursal sucursal) {
        super(Nombre, Fecha_Nacimiento, Correo, Numero_Celular, Cedula, Sexo);
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

    public void setSucursal(/*String*/Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Instructor(int Cedula) {
        super(Cedula);
    }

    @Override
    public String toString() {
        return this.getNombre(); // O "Cedula - Nombre"
    }

    @Override
    public String Datos() {
        return "Instructor {"
                + "Cedula=" + getCedula()
                + ", Nombre=" + getNombre()
                + ", Sexo=" + getSexo()
                + ", Fecha_Nacimiento='" + getFecha_Nacimiento() + '\''
                + ", Correo='" + getCorreo() + '\''
                + ", Numero_Celular=" + getNumero_Celular()
                + ", Especialidad='" + getEspecialidad() + '\''
                + '}';
    }

}
