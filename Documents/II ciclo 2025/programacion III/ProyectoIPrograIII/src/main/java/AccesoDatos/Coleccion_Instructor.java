/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
package AccesoDatos;
import Controlador.*;
import Modelo.Instructor;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
/*
public class Coleccion_Instructor {
    
    private List<Instructor> lista;

    public Coleccion_Instructor(List<Instructor> lista) {
        this.lista = lista;
        coleccionins = new Coleccion_Instructor(new ArrayList<>());
    
    }
    
    
  
    

    public boolean Insertar_Instructor(Instructor nuevo) {
        return coleccion.Insertar_Instructor(nuevo);
    }
  
    /Insertar Instructor
    public boolean Insertar_Instructor(Instructor ins){
        if(Buscar_Instructor(ins.getCedula()) != null){
        return false;
        }
        lista.add(ins);
        return true;
    }
    //Modificar Instructor
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
    //Eliminar Instructor
    public boolean Eliminar_Instructor(int Cedula){
        for(Instructor ins:lista){
            if(ins.getCedula() == Cedula){
                lista.remove(ins);
                return true;
            }
        }
        return false;
    }
    //Buscar Instructor
    public Instructor Buscar_Instructor(int Cedula) {
        for (Instructor ins : lista) {
            if (ins.getCedula() == Cedula) {
                return ins;
            }
        }
        return null;
    }
    //Listar Instructor
    public List<Instructor> Listar_Instructor(){
        return new ArrayList<>(lista);
    }
    
    
    
}*/
package AccesoDatos;

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

    // Listar Instructores
    public List<Instructor> Listar_Instructor(){
        return new ArrayList<>(lista);
    }
}
