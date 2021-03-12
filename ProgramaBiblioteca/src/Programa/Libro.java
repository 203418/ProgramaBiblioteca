package Programa;
import java.util.Scanner;
public class Libro implements Comparable<Libro>{
    Scanner entrada =new Scanner(System.in);
    private String titulo;
    private String autor;
    private String ISBN;
    private Integer edicion;
    public Libro(){}
    public Libro(String titulo, String autor, String ISBN, int edicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN=ISBN;
        this.edicion=edicion;
    }
    public void agregarLibro(){
        int pos=-1;
        System.out.println("Digite el nombre del libro");
        titulo = entrada.nextLine();
        System.out.println("Digite el nombre del autor");
        autor = entrada.nextLine();
        do {
            System.out.println("Digite el ISBN del libro");
            ISBN = entrada.next();
            pos = Main.comprobarISBN(ISBN);
            if (pos>=0) System.out.println("ISBN ya registrado");
        }while(pos>=0);
        System.out.println("Digite la edicion del libro");
        edicion = entrada.nextInt();
    }
    @Override
    public int compareTo(Libro b){
        int resultado=this.titulo.compareTo(b.getTitulo());
        if (resultado==0){
            resultado=this.autor.compareTo(b.getAutor());
           if (resultado==0){
               resultado=this.ISBN.compareTo(b.getISBN());
               if (resultado==0){
                   return this.edicion.compareTo(b.getEdicion());
               }
               return resultado;
           }
            return resultado;
        }
        return resultado;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor(){

        return autor;
    }
    public String getISBN(){
        return ISBN;
    }
    public Integer getEdicion(){
        return edicion;
    }
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {
        this.autor=autor;
    }
    public void setISBN(String ISBN){
        this.ISBN=ISBN;
    }
    public void setEdicion(int edicion){this.edicion=edicion;}
    public String toString(){
        return ("Titulo: "+titulo+", autor: "+autor+", ISBN: "+ISBN+", edicion: "+edicion);
    }
}
