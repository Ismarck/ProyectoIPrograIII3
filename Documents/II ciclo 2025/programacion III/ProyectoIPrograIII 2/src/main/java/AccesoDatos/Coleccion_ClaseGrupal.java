package AccesoDatos;

import Modelo.ClaseGrupal;
import java.util.ArrayList;
import java.util.List;

public class Coleccion_ClaseGrupal {
    private List<ClaseGrupal> clases = new ArrayList<>();

    public void agregar(ClaseGrupal clase) {
        clases.add(clase);
    }

    public List<ClaseGrupal> obtenerTodas() {
        return clases;
    }

    public ClaseGrupal buscarPorTipo(String tipo) {
        for (ClaseGrupal c : clases) {
            if (c.getTipoClase().equalsIgnoreCase(tipo)) {
                return c;
            }
        }
        return null;
    }
    
    // Nuevo método: contar clases por sucursal
     public int contarClasesPorSucursal(String sucursal) {
        int contador = 0;
        for (ClaseGrupal c : clases) {
            if (c.getSucursal().equalsIgnoreCase(sucursal)) {
                contador++;
            }
        }
        return contador;
    }
    
}
