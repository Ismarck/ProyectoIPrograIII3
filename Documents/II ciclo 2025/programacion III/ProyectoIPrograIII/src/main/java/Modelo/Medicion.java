package Modelo;

/**
 *
 * @author marcosisaacarayaabarca
 */
public class Medicion {

    private float Peso;
    private float Estatura;
    private float Grasa;
    private float Musculo;
    private float EdadMetabolica;
    private float Cintura;
    private float Cadera;
    private float Pecho;
    private float Muslo;
    private float IMC; 
    public Medicion() {
    }

    public Medicion(float Peso, float Estatura, float Grasa, float Musculo, float EdadMetabolica, float Cintura, float Cadera, float Pecho, float Muslo, float IMC) {
        this.Peso = Peso;
        this.Estatura = Estatura;
        this.Grasa = Grasa;
        this.Musculo = Musculo;
        this.EdadMetabolica = EdadMetabolica;
        this.Cintura = Cintura;
        this.Cadera = Cadera;
        this.Pecho = Pecho;
        this.Muslo = Muslo;
        this.IMC = IMC;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }

    public float getEstatura() {
        return Estatura;
    }

    public void setEstatura(float Estatura) {
        this.Estatura = Estatura;
    }

    public float getGrasa() {
        return Grasa;
    }

    public void setGrasa(float Grasa) {
        this.Grasa = Grasa;
    }

    public float getMusculo() {
        return Musculo;
    }

    public void setMusculo(float Musculo) {
        this.Musculo = Musculo;
    }

    public float getEdadMetabolica() {
        return EdadMetabolica;
    }

    public void setEdadMetabolica(float EdadMetabolica) {
        this.EdadMetabolica = EdadMetabolica;
    }

    public float getCintura() {
        return Cintura;
    }

    public void setCintura(float Cintura) {
        this.Cintura = Cintura;
    }

    public float getCadera() {
        return Cadera;
    }

    public void setCadera(float Cadera) {
        this.Cadera = Cadera;
    }

    public float getPecho() {
        return Pecho;
    }

    public void setPecho(float Pecho) {
        this.Pecho = Pecho;
    }

    public float getMuslo() {
        return Muslo;
    }

    public void setMuslo(float Muslo) {
        this.Muslo = Muslo;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    @Override
    public String toString() {
        return "Medicion{" + "Peso=" + Peso + ", Estatura=" + Estatura + ", Grasa=" + Grasa + ", Musculo=" + Musculo + ", EdadMetabolica=" + EdadMetabolica + ", Cintura=" + Cintura + ", Cadera=" + Cadera + ", Pecho=" + Pecho + ", Muslo=" + Muslo + ", IMC=" + IMC + '}';
    }
 
    
}
