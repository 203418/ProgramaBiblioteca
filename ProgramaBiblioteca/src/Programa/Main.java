package Programa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Libro> listaLibros = new ArrayList<>();
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        mostrarMenu();
    }
    public static void mostrarMenu(){
        int opcion=5;
        do {
            System.out.println("Digite la opcion deseada");
            System.out.println("1.Agregar Libro\n2.Mostrar Libros\n3.EliminarLibros\n4.Buscar Libros\n5.Salir");
            opcion = entrada.nextInt();
            if (opcion!=5){
                switch (opcion){
                    case 1: agregarLibro(2); break;
                    case 2: mostrarLibros();break;
                    case 3: eliminarLibros(); break;
                    case 4: buscarLibro(); break;
                    default:
                        System.out.println("Entrada invalida");
                }
            }
        }while(opcion!=5);
    }
    public static void agregarLibro(int opcion){
        int respuestaA=2;
        do {
            Libro libro= new Libro();
            libro.agregarLibro();
            listaLibros.add(libro);
            System.out.println("Libro aniadido");
            do{
                System.out.println("Desea registrar otro libro 1=si 2=no");
                respuestaA = entrada.nextInt();
            }while (respuestaA!=1 && respuestaA!=2);
        }while (respuestaA==1);
        Collections.sort(listaLibros);
    }
    public static void mostrarLibros(){
        if (!listaLibros.isEmpty()){
            for (int i=0;i<listaLibros.size();i++){
                System.out.println((i+1)+". "+listaLibros.get(i));
            }
        }
        else System.out.println("No hay libros registrados");
    }
    public static void eliminarLibros(){
        int respuestaE=2, resultado=-1;
        do {
            if (!listaLibros.isEmpty()){
                entrada.nextLine();
                System.out.println("Digite el titulo del libro a eliminar");
                String titulo= entrada.nextLine();
                System.out.println("Digite el nombre exacto del Autor");
                String autor=entrada.nextLine();
                System.out.println("Digite el ISBN del libro");
                String isbn= entrada.next();
                System.out.println("Digite la edicion del libro");
                int edicion = entrada.nextInt();
                Libro libro = new Libro(titulo,autor,isbn,edicion);
                Search s = new Search();
                resultado = s.binaria(listaLibros,libro,false);
                if (resultado>=0) {
                    listaLibros.remove(resultado);
                    System.out.println("Libro eliminado");
                    if (!listaLibros.isEmpty()){
                        do {
                            System.out.println("Desea remover otro libro 1-Si, cualquier numero=no");
                            respuestaE = entrada.nextInt();
                            if (respuestaE!=1 && respuestaE!=2) System.out.println("Opcion invalida");
                        }while (respuestaE!=1 && respuestaE!=2);
                    }
                    else System.out.println("Todos los libros han sido eliminados del registro");
                }
                else{
                    do {
                        System.out.println("Libro inexistente, desea volver a intentarlo 1-Si 2-no");
                        respuestaE = entrada.nextInt();
                        if (respuestaE!=1 && respuestaE!=2) System.out.println("Opcion invalida");
                    }while(respuestaE!=1 && respuestaE!=2);
                }
            }
            else System.out.println("No hay libros para eliminar, agregue en el menu");
        }while (respuestaE==1 && !listaLibros.isEmpty());
    }
    public static void buscarLibro(){
        String titulo,autor,isbn;
        int edicion,respuestaB=2,pos=-1;
        if (!listaLibros.isEmpty()){
            do{
                entrada.nextLine();
                System.out.println("Digite el nombre exacto del libro");
                titulo= entrada.nextLine();
                System.out.println("Digite el nombre exacto del autor");
                autor=entrada.nextLine();
                System.out.println("Digite el ISBN del libro");
                isbn = entrada.next();
                System.out.println("Digite el numero de edicion del libro");
                edicion=entrada.nextInt();
                entrada.nextLine();
                Libro libro = new Libro(titulo,autor,isbn,edicion);
                Search<Libro> s = new Search<>();
                pos=s.binaria(listaLibros,libro,false);
                if (pos>=0) System.out.println("El libro existe y está en la posicion "+pos+" del array");
                else System.out.println("el libro no existe en el registro");
                System.out.println("Desea buscar otro libro 1-Si Cualquier otro numero-No");
                respuestaB=entrada.nextInt();
            }while(respuestaB==1);
        }
        else System.out.println("No hay libros para buscar");
    }
    public static int compareISBN(String a, Libro b){
        return a.compareTo(b.getISBN());
    }
    public static int comprobarISBN(String ISBN){
        int pos=-1;
        for (int i=0;i<listaLibros.size();i++){
            if (compareISBN(ISBN,listaLibros.get(i))==0)
                pos=i;
        }
        return pos;
    }
}
