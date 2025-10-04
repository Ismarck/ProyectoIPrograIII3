/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marcosisaacarayaabarca
 */
package AccesoDatos;

import Modelo.Cliente;
import Modelo.Instructor;
import java.util.ArrayList;
import java.util.List;

public class Coleccion_Instructor {
    
    private List<Instructor> lista;

    public Coleccion_Instructor(List<Instructor> lista) {
        this.lista = lista;
    }

    public boolean Insertar_Instructor(Instructor ins){
        if(Buscar_Instructor(ins.getCedula()) != null){
            return false;
        }
        lista.add(ins);
        return true;
    }

    // Modificar Instructor
    public boolean Modificar_Instructor(Instructor nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            Instructor actual = lista.get(i);
            if (actual.getCedula() == nuevo.getCedula()) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    // Eliminar Instructor
    public boolean Eliminar_Instructor(int Cedula){
        for (Instructor ins : lista) {
            if (ins.getCedula() == Cedula) {
                lista.remove(ins);
                return true;
            }
        }
        return false;
    }

    // Buscar Instructor
    public Instructor Buscar_Instructor(int Cedula) {
        for (Instructor ins : lista) {
            if (ins.getCedula() == Cedula) {
                return ins;
            }
        }
        return null;
    }
    
    
public List<Cliente> listarClientesPorInstructor(String nombreInstructor) {
    List<Cliente> resultado = new ArrayList<>();
    
    for (Instructor ins : Listar_Instructor()) { 
        if (ins.getNombre().equalsIgnoreCase(nombreInstructor)) {
            resultado.addAll(ins.getListaClientes()); 
            break;
        }
    }
    
    return resultado; 
}


/*public List<Instructor> buscarPorSucursal(String sucursal) {
    List<Instructor> resultado = new ArrayList<>();
    for (Instructor ins : lista) {  
        if (ins.getSucursal().equalsIgnoreCase(sucursal)) {
            resultado.add(ins);
        }
    }
    return resultado;
}*/
public List<Instructor> buscarPorSucursal(String nombreSucursal) {
    List<Instructor> resultado = new ArrayList<>();
    for (Instructor ins : lista) {  
        if (ins.getSucursal() != null &&
            ins.getSucursal().getProvincia().equalsIgnoreCase(nombreSucursal)) {
            resultado.add(ins);
        }
    }
    return resultado;
}



public List<Instructor> buscarPorEspecialidad(String especialidad) {
    List<Instructor> resultado = new ArrayList<>();
    String especialidadBusqueda = especialidad.toLowerCase().trim();
    
    for (Instructor ins : lista) {
        if (ins.getEspecialidad() != null &&
            ins.getEspecialidad().toLowerCase().contains(especialidadBusqueda)) {
            resultado.add(ins);
        }
    }
    
    return resultado;
}

    // Listar Instructores
    public List<Instructor> Listar_Instructor(){
        return new ArrayList<>(lista);
    }
}
