/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Instructor;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */
/*
public class Controlador_Instructor {
    /*
    
    private List<Instructor> lista;

    public Controlador_Instructor(List<Instructor> lista) {
        this.lista = lista;
    }
  
    //Insertar Instructor
    public boolean Insertar_Instructor(Instructor t){
        if(Buscar_Instructor(t.getCedula()) != null){
        return false;
        }
        lista.add(t);
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
    */
    
    
//}*/
import AccesoDatos.Coleccion_Instructor;


public class Controlador_Instructor {
    private Coleccion_Instructor coleccion;

    public Controlador_Instructor(Coleccion_Instructor coleccion) {
        this.coleccion = coleccion;
    }

    public boolean registrarInstructor(Instructor ins) {
        return coleccion.Insertar_Instructor(ins);
    }

    public boolean eliminarInstructor(int cedula) {
        return coleccion.Eliminar_Instructor(cedula);
    }

    public Instructor buscarInstructor(int cedula) {
        return coleccion.Buscar_Instructor(cedula);
    }

    public boolean modificarInstructor(Instructor ins) {
        return coleccion.Modificar_Instructor(ins);
    }

    public java.util.List<Instructor> listar() {
        return coleccion.Listar_Instructor();
    }
}
