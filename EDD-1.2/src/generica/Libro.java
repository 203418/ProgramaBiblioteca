package generica;

public class Libro implements Comparable<Libro>{
    private String titulo;
    private Integer paginas;

    public Libro(String titulo, int paginas) {
        this.titulo = titulo;
        this.paginas = paginas;
    }
    @Override
    public int compareTo(Libro l){
        int resultado = this.titulo.compareTo(l.titulo);
        if (resultado==0){
            return (this.paginas.compareTo(l.paginas));
        }
        return resultado;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    public String toString(){
        return ("Titulo: "+titulo+", numero de paginas: "+paginas);
    }
}
