/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author porto
 */
public class ClaseGrupal {
    
    private String Codigo;
    private String Horario;
    private String Salon;
    private int CupoMaximo;
    private Instructor instructor;
    private List<Cliente> clientes;
    

    public ClaseGrupal() {

    }

    public ClaseGrupal(String codigo, String horario, String salon, int cupoMaximo, Instructor instructor) {
        this.Codigo = codigo;
        this.Horario = horario;
        this.Salon = salon;
        this.CupoMaximo = cupoMaximo;
        this.instructor = instructor;
        this.clientes = new ArrayList<>();
    }
    
    public boolean matricularCliente(Cliente cliente) {
        if (clientes.size() < CupoMaximo) {
            if (!clientes.contains(cliente)) { // evitar duplicados
                clientes.add(cliente);
                return true;
            }
        }
        return false;
    }
    
    public List<Cliente> getMatriculados() {
        return clientes;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public String getSalon() {
        return Salon;
    }

    public void setSalon(String Salon) {
        this.Salon = Salon;
    }

    public int getCupoMaximo() {
        return CupoMaximo;
    }

    public void setCupoMaximo(int CupoMaximo) {
        this.CupoMaximo = CupoMaximo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    


    @Override
    public String toString() {
        return "ClaseGrupal{" 
                + "Codigo=" + Codigo 
                + ", Horario=" + Horario 
                + ", Salon=" + Salon 
                + ", CupoMaximo=" + CupoMaximo 
                + ", instructor=" + instructor 
                + ", clientes=" + clientes + '}';
    }
    /*
    public boolean matricularCliente(Cliente c) {
        if (clientes.size() < capacidad && !clientes.contains(c)) {
            clientes.add(c);
            return true;
        }
        return false;
    }*/

    
    
   /* @Override
    public String toString() {
        return "Rutina {"
                + "Codigo='" + Codigo + '\''
                + ", TipoClase='" + TipoClase + '\''
                + ", Salon='" + Salon + '\''
                + ", CupoMaximo=" + CupoMaximo
                + ", Horario='" + Horario + '\''
                + '}';
    }*/
    /*
     public static void main(String[] args) 
    {
        ClaseGrupal clasegrupal1 = new ClaseGrupal("R001", "Yoga", "Sala 3", 25, "Lunes 7am"
        );
        
        System.out.println(clasegrupal1.toString());
    }*/
}

