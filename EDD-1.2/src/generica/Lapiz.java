package generica;

public class Lapiz implements Comparable<Lapiz>{
    private String color;
    private Integer numero;

    public Lapiz(String color, int numero) {
        this.color = color;
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public int compareTo(Lapiz l){
        int resultado=this.numero.compareTo(l.numero);
        if (resultado==0){
            return (this.color.compareTo(l.color));
        }
        return resultado;
    }
    public String toString(){
        return (("Lapiz: "+color+" y numero: "+numero));
    }
}
