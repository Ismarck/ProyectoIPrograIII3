/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;
import Controlador.*;
import Modelo.Sucursal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcosisaacarayaabarca
 */

public class Coleccion_Sucursal {
    
    private List<Sucursal> lista;

    public Coleccion_Sucursal(List<Sucursal> lista) {
        this.lista = lista;
    }
  
    //Insertar Instructor
    public boolean Insertar_Sucursal(Sucursal s){
        if(Buscar_Sucursal(s.getCodigo()) != null){
        return false;
        }
        lista.add(s);
        return true;
    }
    //Modificar Instructor
    public boolean Modificar_Sucursal(Sucursal nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            Sucursal actual = lista.get(i);
            if (actual.getCodigo() == nuevo.getCodigo()) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }
    //Eliminar Instructor
    public boolean Eliminar_Sucursal(int Codigo){
        for(Sucursal ins:lista){
            if(ins.getCodigo() == Codigo){
                lista.remove(ins);
                return true;
            }
        }
        return false;
    }
    
    
    public Sucursal Buscar_Sucursal(int Codigo) {
        for (Sucursal ins : lista) {
            if (ins.getCodigo() == Codigo) {
                return ins;
            }
        }
        return null;
    }
    
    // En Coleccion_Sucursal
public Sucursal buscarPorProvincia(String provincia) {
    for (Sucursal s : lista) {
        if (s.getProvincia().equalsIgnoreCase(provincia)) {
            return s;
        }
    }
    return null; // Si no se encuentra
}    
    
    //Listar Instructor
    public List<Sucursal> Listar_Sucursal(){
        return new ArrayList<>(lista);
    }
}/**/
