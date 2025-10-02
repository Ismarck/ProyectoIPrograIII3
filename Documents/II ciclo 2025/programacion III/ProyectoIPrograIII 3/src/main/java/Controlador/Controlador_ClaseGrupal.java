package Controlador;

import AccesoDatos.Coleccion_ClaseGrupal;
import Modelo.ClaseGrupal;
import Modelo.Cliente;

import java.util.List;

public class Controlador_ClaseGrupal {
    private Coleccion_ClaseGrupal coleccion;
    private Controlador_Instructor controladorInstructor;
    private Controlador_Cliente controladorCliente;

    public Controlador_ClaseGrupal(Coleccion_ClaseGrupal coleccion) {
        this.coleccion = coleccion;
    }
    
    
    public Controlador_ClaseGrupal(Coleccion_ClaseGrupal coleccion, 
                                   Controlador_Instructor controladorInstructor, 
                                   Controlador_Cliente controladorCliente) {
        this.coleccion = coleccion;
        this.controladorInstructor = controladorInstructor;
        this.controladorCliente = controladorCliente;
    }

    public void crearClaseGrupal(ClaseGrupal clase) {
        coleccion.agregar(clase);
    }

    public boolean matricularCliente(ClaseGrupal clase, Cliente cliente) {
        return clase.matricularCliente(cliente);
    }
    
     public int contarClasesPorSucursal(String sucursal) {
        return coleccion.contarClasesPorSucursal(sucursal);
    }

    public List<ClaseGrupal> listarClases() {
        return coleccion.obtenerTodas();
    }
}
