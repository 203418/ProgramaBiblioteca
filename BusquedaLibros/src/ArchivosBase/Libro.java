package ArchivosBase;
import java.util.Scanner;
public class Libro implements Comparable<Libro>{
    Scanner entrada =new Scanner(System.in);
    private String titulo;
    private String autor;
    private String ISBN;
    private Integer edicion;
    public int compISBN(String ISBN){
        int pos=-1;
        for (int i=0;i<Main.librosRegistrados.size();i++){
            if (Main.compare(ISBN,Main.librosRegistrados.get(i))==0)
                pos=i;
        }
        return pos;
    }
    public void agregar(int opcion){
        int pos=-1;
        System.out.println("Digite el nombre del libro");
        titulo = entrada.nextLine();
        System.out.println("Digite el nombre del autor");
        autor = entrada.nextLine();
        do {
            System.out.println("Digite el ISBN del libro");
            ISBN = entrada.next();
            if (opcion==1){
                pos = compISBN(ISBN);
                if (pos>=0) System.out.println("ISBN ya registrado");
            }
            else pos=1;
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
