/*package AccesoDatos;

import Modelo.ClaseGrupal;
import java.util.ArrayList;
import java.util.List;

public class Coleccion_ClaseGrupal {
    private List<ClaseGrupal> clases;

    public Coleccion_ClaseGrupal() {
        clases = new ArrayList<>();
    }

    // Insertar clase (evita duplicados por código)
    public boolean insertar(ClaseGrupal clase) {
        if (buscarPorCodigo(clase.getCodigo()) == null) {
            return clases.add(clase);
        }
        return false; // ya existe una clase con ese código
    }

    // Eliminar por índice
    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < clases.size()) {
            clases.remove(indice);
            return true;
        }
        return false;
    }

    // Eliminar por código
    public boolean eliminarPorCodigo(String codigo) {
        ClaseGrupal c = buscarPorCodigo(codigo);
        if (c != null) {
            return clases.remove(c);
        }
        return false;
    }

    // Buscar por índice
    public ClaseGrupal buscar(int indice) {
        if (indice >= 0 && indice < clases.size()) {
            return clases.get(indice);
        }
        return null;
    }

    // Buscar por código
    public ClaseGrupal buscarPorCodigo(String codigo) {
        for (ClaseGrupal c : clases) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    // Modificar por índice
    public boolean modificar(int indice, ClaseGrupal clase) {
        if (indice >= 0 && indice < clases.size()) {
            clases.set(indice, clase);
            return true;
        }
        return false;
    }

    // Modificar por código
    public boolean modificarPorCodigo(String codigo, ClaseGrupal clase) {
        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                clases.set(i, clase);
                return true;
            }
        }
        return false;
    }

    // Listar todas las clases
    public List<ClaseGrupal> listar() {
        return clases;
    }
}
*/
package AccesoDatos;

import Modelo.ClaseGrupal;
import java.util.ArrayList;
import java.util.List;

public class Coleccion_ClaseGrupal {
    private List<ClaseGrupal> clases;

    public Coleccion_ClaseGrupal() {
        clases = new ArrayList<>();
    }

    // Insertar clase (evita duplicados por código)
    public boolean insertar(ClaseGrupal clase) {
        if (buscarPorCodigo(clase.getCodigo()) == null) {
            return clases.add(clase);
        }
        return false; // ya existe una clase con ese código
    }

    // Eliminar por índice
    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < clases.size()) {
            clases.remove(indice);
            return true;
        }
        return false;
    }

    // Eliminar por código
    public boolean eliminarPorCodigo(String codigo) {
        ClaseGrupal c = buscarPorCodigo(codigo);
        if (c != null) {
            return clases.remove(c);
        }
        return false;
    }

    // Buscar por índice
    public ClaseGrupal buscar(int indice) {
        if (indice >= 0 && indice < clases.size()) {
            return clases.get(indice);
        }
        return null;
    }

    // Buscar por código
    public ClaseGrupal buscarPorCodigo(String codigo) {
        for (ClaseGrupal c : clases) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    // Modificar por índice
    public boolean modificar(int indice, ClaseGrupal clase) {
        if (indice >= 0 && indice < clases.size()) {
            clases.set(indice, clase);
            return true;
        }
        return false;
    }

    // Modificar por código
    public boolean modificarPorCodigo(String codigo, ClaseGrupal clase) {
        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                clases.set(i, clase);
                return true;
            }
        }
        return false;
    }

    // Listar todas las clases
    public List<ClaseGrupal> listar() {
        return clases;
    }
}
