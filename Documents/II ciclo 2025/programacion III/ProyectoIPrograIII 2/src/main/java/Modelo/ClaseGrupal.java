/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;

public class ClaseGrupal {
    private String tipoClase;
    private Instructor instructor;
    private String horario;
    private int cupoMaximo;
    private String sucursal; 
    private int cuposDisponibles;
    private List<Cliente> matriculados;

    /*public ClaseGrupal(String tipoClase, Instructor instructor, String horario, int cupoMaximo) {
        if (!instructor.getEspecialidad().equalsIgnoreCase(tipoClase)) {
            throw new IllegalArgumentException("El instructor no tiene la especialidad requerida.");
        }
        this.tipoClase = tipoClase;
        this.instructor = instructor;
        this.horario = horario;
        this.cupoMaximo = cupoMaximo;
        this.cuposDisponibles = cupoMaximo;
        this.matriculados = new ArrayList<>();
    }*/
    public ClaseGrupal(String tipoClase, Instructor instructor, String horario, int cupoMaximo, String sucursal) {
        this.tipoClase = tipoClase;
        this.instructor = instructor;
        this.horario = horario;
        this.cupoMaximo = cupoMaximo;
        this.sucursal = sucursal;
        this.matriculados = new ArrayList<>();
}


    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }
    
    // Getter que faltaba
    public String getSucursal() {
        return sucursal;
    }

    // Opcional: setter si necesitas modificar la sucursal
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "ClaseGrupal{" + "tipoClase=" + tipoClase + ", instructor=" + instructor + ", horario=" + horario + ", cupoMaximo=" + cupoMaximo + ", cuposDisponibles=" + cuposDisponibles + ", matriculados=" + matriculados + '}';
    }
    
    


    public boolean matricularCliente(Cliente c) {
        if (cuposDisponibles > 0 && !matriculados.contains(c)) {
            matriculados.add(c);
            cuposDisponibles--;
            return true;
        }
        return false;
    }

    public List<Cliente> getMatriculados() {
        return matriculados;
    }
}
