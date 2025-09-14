/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author porto
 */
public class ClaseGrupal {
    
    private String Codigo;
    private String TipoClase;
    private String Salon;
    private int CupoMaximo;
    private String Horario;

    public ClaseGrupal() {

    }

    public ClaseGrupal(String Codigo, String TipoClase, String Salon, int CupoMaximo, String Horario) {
        this.Codigo = Codigo;
        this.TipoClase = TipoClase;
        this.Salon = Salon;
        this.CupoMaximo = CupoMaximo;
        this.Horario = Horario;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getTipoClase() {
        return TipoClase;
    }

    public void setTipoClase(String TipoClase) {
        this.TipoClase = TipoClase;
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

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    @Override
    public String toString() {
        return "Rutina {"
                + "Codigo='" + Codigo + '\''
                + ", TipoClase='" + TipoClase + '\''
                + ", Salon='" + Salon + '\''
                + ", CupoMaximo=" + CupoMaximo
                + ", Horario='" + Horario + '\''
                + '}';
    }
    
     public static void main(String[] args) 
    {
        ClaseGrupal clasegrupal1 = new ClaseGrupal("R001", "Yoga", "Sala 3", 25, "Lunes 7am"
        );
        
        System.out.println(clasegrupal1.toString());
    }
}

