package Modelo;

import java.time.LocalDate;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Medicion {

    private Cliente cliente;
    private Instructor instructor;
    private LocalDate fecha;
    private double peso;
    private double estatura;
    private double porcentajeGrasa;
    private double porcentajeMusculo;
    private int edadMetabolica;
    private double grasaVisceral;
    private double cintura;
    private double cadera;
    private double pecho;
    private double muslo;

    public Medicion() {
    }

    public Medicion(Cliente cliente, Instructor instructor, LocalDate fecha, double peso, double estatura, double porcentajeGrasa, double porcentajeMusculo, int edadMetabolica, double grasaVisceral, double cintura, double cadera, double pecho, double muslo) {
        this.cliente = cliente;
        this.instructor = instructor;
        this.fecha = fecha;
        this.peso = peso;
        this.estatura = estatura;
        this.porcentajeGrasa = porcentajeGrasa;
        this.porcentajeMusculo = porcentajeMusculo;
        this.edadMetabolica = edadMetabolica;
        this.grasaVisceral = grasaVisceral;
        this.cintura = cintura;
        this.cadera = cadera;
        this.pecho = pecho;
        this.muslo = muslo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(double porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public double getPorcentajeMusculo() {
        return porcentajeMusculo;
    }

    public void setPorcentajeMusculo(double porcentajeMusculo) {
        this.porcentajeMusculo = porcentajeMusculo;
    }

    public int getEdadMetabolica() {
        return edadMetabolica;
    }

    public void setEdadMetabolica(int edadMetabolica) {
        this.edadMetabolica = edadMetabolica;
    }

    public double getGrasaVisceral() {
        return grasaVisceral;
    }

    public void setGrasaVisceral(double grasaVisceral) {
        this.grasaVisceral = grasaVisceral;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getCadera() {
        return cadera;
    }

    public void setCadera(double cadera) {
        this.cadera = cadera;
    }

    public double getPecho() {
        return pecho;
    }

    public void setPecho(double pecho) {
        this.pecho = pecho;
    }

    public double getMuslo() {
        return muslo;
    }

    public void setMuslo(double muslo) {
        this.muslo = muslo;
    }

    @Override
    public String toString() {
        return "Medicion{" + "cliente=" + cliente + ", instructor=" + instructor + ", fecha=" + fecha + ", peso=" + peso + ", estatura=" + estatura + ", porcentajeGrasa=" + porcentajeGrasa + ", porcentajeMusculo=" + porcentajeMusculo + ", edadMetabolica=" + edadMetabolica + ", grasaVisceral=" + grasaVisceral + ", cintura=" + cintura + ", cadera=" + cadera + ", pecho=" + pecho + ", muslo=" + muslo + '}';
    }

}
