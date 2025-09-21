/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package AccesoDatos;
import Controlador.*;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import AccesoDatos.Coleccion_Sucursal;
import Modelo.ClaseGrupal;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Coleccion_Cliente {
    private List<Cliente> lista;
    private List<ClaseGrupal> clases;
    public List<ClaseGrupal> getClases() { return clases; }


    public Coleccion_Cliente(List<Cliente> lista) {
        this.lista = lista;
    }

    // Insertar Cliente
    public boolean Insertar(Cliente c) {
        if (buscar(c.getCedula()) != null) {
            return false;
        }
        lista.add(c);
        return true;
    }

    // Modificar Cliente por ID
    public boolean Modificar(Cliente nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            Cliente actual = lista.get(i);
            if (actual.getCedula() == nuevo.getCedula()) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    // Eliminar Cliente por cédula
    public boolean Eliminar(int cedula) {
        for (Cliente cli : lista) {
            if (cli.getCedula() == cedula) {
                lista.remove(cli);
                return true;
            }
        }
        return false;
    }

    // Buscar Cliente por cédula
    public Cliente buscar(int cedula) {
        for (Cliente cli : lista) {
            if (cli.getCedula() == cedula) {
                return cli;
            }
        }
        return null;
    }
    
    public List<Cliente> buscarPorNombre(String nombre) {
    List<Cliente> resultados = new ArrayList<>();
    if(nombre == null || nombre.trim().isEmpty()) {
        return resultados; // Devuelve lista vacía si el campo está vacío
    }

    for (Cliente cli : lista) {
        if (cli.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
            resultados.add(cli);
        }
    }
    return resultados;
}
    
    public Cliente buscarClientePorNombreUnico(String nombre) {
    List<Cliente> resultados = buscarPorNombre(nombre);
    if (!resultados.isEmpty()) {
        return resultados.get(0); // solo el primero
    }
    return null;
}
    
   
    // Cuenta cuántas clases tiene matriculado un cliente
    public int cantidadClasesMatriculadas(Cliente c) {
        if (c == null || c.getClasesMatriculadas() == null) {
            return 0;
        }
        return c.getClasesMatriculadas().size();
    }

   

    


    // Listar Clientes
    public List<Cliente> Listar() {
        return new ArrayList<>(lista);
    }
}
