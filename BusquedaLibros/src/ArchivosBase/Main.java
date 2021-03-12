package ArchivosBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Libro> librosRegistrados = new ArrayList<>();
    public static void main(String[] args) {
        int respuesta;
        do {
            System.out.println("Digite la opcion deseada en cuanto a los libros");
            System.out.println("1.Agregar\n2.Mostrar\n3.Eliminar\n4.Buscar\n5.Salir");
            respuesta = entrada.nextInt();
            switch (respuesta){
                case 1: agregar(); break;
                case 2: mostrar();break;
                case 3: eliminar(); break;
                case 4: buscar(); break;
                case 5: break;
                default:
                    System.out.println("Entrada invalida");
            }
        }while(respuesta!=5);
    }
    public static int compare(String a, Libro b){
        return a.compareTo(b.getISBN());
    }
    public static void buscar(){
        String titulo,autor,isbn,respuestaB="No";
        int edicion,posicion=-1;
        if (librosRegistrados.isEmpty()==false){
            Search<Libro> busqueda = new Search<>();
            do{
                Libro libro = new Libro();
                libro.agregar();
                posicion=busqueda.binaria(librosRegistrados,libro,false);
                if (posicion>=0) {
                    System.out.println("El libro existe y está en la posicion "+posicion);
                }
                else {
                    System.out.println("el libro no se encuentra");
                }
                System.out.println("Desea buscar otro libro 'Si' o 'No'");
                respuestaB=entrada.next();
            }while(respuestaB=="Si");
        }
        else {
            System.out.println("No hay registrados");
        }

    }
    public static void eliminar(){
        int respuesta=2, pos=-1;
        do {
            if (librosRegistrados.isEmpty()==false){
                Libro libro = new Libro();
                do {
                    libro.agregar(2);
                    Search busqueda = new Search();
                    pos = busqueda.binaria(librosRegistrados, libro, false);
                    if (pos<0) System.out.println("Libro inxistente, intente de nuevo");
                }while(pos<0);
                librosRegistrados.remove(pos);
                System.out.println("Libro eliminado");
                if (!librosRegistrados.isEmpty()){
                    do {
                        System.out.println("Desea remover otro libro 1-Si 2-No");
                        respuesta = entrada.nextInt();
                        if (respuesta!=1 && respuesta!=2) System.out.println("Opcion invalida");
                    }while (respuesta!=1 && respuesta!=2);
                }
            }
            else System.out.println("No hay libros");
        }while (respuesta==1 && librosRegistrados.isEmpty()==false);
    }
    public static void mostrar(){
        if (librosRegistrados.isEmpty()==false){
            for (int i=0;i<librosRegistrados.size();i++){
                System.out.println((i+1)+". "+librosRegistrados.get(i));
            }
        }
    }
    public static void agregar(1){
        int agregar;
        do {
            Libro l1= new Libro();
            l1.agregar();
            librosRegistrados.add(l1);
            System.out.println("Desea registrar otro libro 1=si 2=no");
            agregar = entrada.nextInt();
        }while (agregar==1);
        Collections.sort(librosRegistrados);
    }
}
