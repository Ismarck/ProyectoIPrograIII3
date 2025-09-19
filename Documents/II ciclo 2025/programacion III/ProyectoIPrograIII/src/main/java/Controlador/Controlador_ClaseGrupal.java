package Controlador;

import AccesoDatos.Coleccion_ClaseGrupal;
import Modelo.ClaseGrupal;
import Modelo.Cliente;
import Modelo.Instructor;
import java.util.List;

public class Controlador_ClaseGrupal {
    private Coleccion_ClaseGrupal coleccion;

    public Controlador_ClaseGrupal(Coleccion_ClaseGrupal coleccion) {
        this.coleccion = coleccion;
    }

    // Registrar una nueva clase (valida especialidad del instructor)
    public boolean registrarClase(ClaseGrupal clase, String especialidadRequerida) {
        Instructor inst = clase.getInstructor();
        if (inst != null && inst.getEspecialidad().equalsIgnoreCase(especialidadRequerida)) {
            return coleccion.insertar(clase);
        }
        return false; // instructor no cumple con especialidad
    }

    public boolean eliminarClase(int indice) {
        return coleccion.eliminar(indice);
    }

    public ClaseGrupal buscarClase(int indice) {
        return coleccion.buscar(indice);
    }

    public boolean modificarClase(int indice, ClaseGrupal clase) {
        return coleccion.modificar(indice, clase);
    }

    public List<ClaseGrupal> listar() {
        return coleccion.listar();
    }

    // Matricular cliente en una clase (valida cupo y máximo 3 clases por cliente)
    public boolean matricularCliente(int indiceClase, Cliente cliente) {
        ClaseGrupal clase = coleccion.buscar(indiceClase);
        if (clase != null) {
            // Validar que el cliente no esté ya en 3 clases
            if (cliente.getClasesMatriculadas().size() >= 3) {
                return false;
            }
            // Intentar matricular
            if (clase.matricularCliente(cliente)) {
                cliente.agregarClase(clase); // se refleja también en el cliente
                return true;
            }
        }
        return false;
    }

    // Obtener lista de clientes de una clase
    public List<Cliente> listarClientesDeClase(int indiceClase) {
        ClaseGrupal clase = coleccion.buscar(indiceClase);
        return (clase != null) ? clase.getMatriculados() : null;
    }
}
