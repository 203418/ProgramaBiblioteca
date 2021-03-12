package Binaria;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainBusqueda {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        solicitarDatos();
    }
    public static void solicitarDatos(){
        System.out.println("Sea bienvenido al programa para mostrar la implementacion de un algoritmo de busque binaia apliada a las clases genericas");
        int respuesta2;
        do{
            System.out.println("Para entrar a un ejemplo solo inserte el numero de lo que desea buscar");
            System.out.println("1-Ejemplo con la clases Borrador\n2.Ejemplo con la clase Lapiz\n3.ejemplo con la clase Libro");
            int respuesta=entrada.nextInt();
            switch (respuesta){
                case 1: buscarBorradores();
                    break;
                case 2: buscarLapices();
                    break;
                case 3: buscarLibros();
                    break;
                default:
                    System.out.println("opcion invalida");
            }
            System.out.println("Desea ver otro ejemplo 1=si 2=no");
            respuesta2=entrada.nextInt();
        }while(respuesta2==1);
    }
    public static void buscarBorradores(){
        Borrador l1, l2, l3, l4, l5,l6,l7,l8,l9,l10;
        l1 = new Borrador("Tinta","Grande");
        l2 = new Borrador("Lapiz","Grande");
        l3 = new Borrador("Tinta","Chico");
        l4 = new Borrador("Lapiz","Grande");
        l5 = new Borrador("Tinta","Chico");
        l6 = new Borrador("Lapiz","Chico");
        l7 = new Borrador("Tinta","Grande");
        l8 = new Borrador("Corrector","Grande");
        l9 = new Borrador("Tinta","Chico");
        l10 = new Borrador("Lapiz","Chico");
        ArrayList<Borrador> lista= new ArrayList<>();
        lista.add(l1);
        lista.add(l2);
        lista.add(l3);
        lista.add(l4);
        lista.add(l5);
        lista.add(l6);
        lista.add(l7);
        lista.add(l8);
        lista.add(l9);
        lista.add(l10);
        Collections.sort(lista);
        int respuestaB;
        String tipo=" ",tamanio=" ";
        do {
            System.out.println("Digite la opcion deseada: ");
            System.out.println("1. Ejemplo con un objeto existente\n2.ejemplo con un objeto inexistente\n3.Buscar ingresando los datos a buscar");
            respuestaB = entrada.nextInt();
        }while(respuestaB<1 || respuestaB>3);
        switch (respuestaB){
            case 1:
                tipo="Tinta"; tamanio="Grande";
                System.out.println("Se buscara un borrador de tipo Tinta y de tamanio Grande");
                System.out.println("Corregir linea 65 en caso de querer cambiar el onjeto existente a buscar");
            break;
            case 2:
                tipo="Corrector"; tamanio="Chico";
                System.out.println("Se buscara un borrrador de tipo Corrector de tamanio Chico");
                System.out.println("Corregir la linea 70 en caso de querer buscar un elemento inexistente");
            break;
            case 3:
                System.out.println("Digite el tipo de borrador que desea: Tinta,Lapiz o Corrector");
                tipo = entrada.next();
                System.out.println("Digite el tamaño que busca: Grande o Chico");
                tamanio = entrada.next();
            break;
        }
        Borrador buscar = new Borrador(tipo,tamanio);
        System.out.println(lista);
        Search<Borrador> s = new Search<>();
        int encontrado=-1;
        encontrado=(s.binaria(lista,buscar,false));
        if (encontrado>=0) System.out.println("El Lapiz existe y se encuentra en la posicion "+encontrado+" del arraylist");
        else System.out.println("No existe, codigo"+encontrado);
    }

    public static void buscarLapices(){
        Lapiz l1, l2, l3, l4, l5,l6,l7,l8,l9,l10;
        l1 = new Lapiz("Amarillo",1);
        l2 = new Lapiz("Blanco",3);
        l3 = new Lapiz("Cafe",1);
        l4 = new Lapiz("Amarillo",2);
        l5 = new Lapiz("Blanco",1);
        l6 = new Lapiz("Amarillo",3);
        l7 = new Lapiz("Blanco",1);
        l8 = new Lapiz("Amarillo",2);
        l9 = new Lapiz("Blanco",1);
        l10 = new Lapiz("Cafe",3);
        ArrayList<Lapiz> lista= new ArrayList<>();
        lista.add(l1);
        lista.add(l2);
        lista.add(l3);
        lista.add(l4);
        lista.add(l5);
        lista.add(l6);
        lista.add(l7);
        lista.add(l8);
        lista.add(l9);
        lista.add(l10);
        Collections.sort(lista);
        int respuestaB, numero=0;
        String color=" ";
        do {
            System.out.println("Digite la opcion deseada: ");
            System.out.println("1. Ejemplo con un objeto existente\n2.ejemplo con un objeto inexistente\n3.Buscar ingresando los datos a buscar");
            respuestaB = entrada.nextInt();
        }while(respuestaB<1 || respuestaB>3);
        switch(respuestaB){
            case 1:
                color="Amarillo"; numero=1;
                System.out.println("Se buscara un lapiz Amarillo de numero 1");
                System.out.println("En caso de querer cambiar el objeto a encontrar, cambiar los valores n la linea 122");
            break;
            case 2:
                color = "Blanco"; numero=2;
                System.out.println("Se buscara un lapiz color Blanco con numero=2");
                System.out.println("En caso de querer cambiar el objeto inexistente, cambiar los valores en la linea 128");
            break;
            case 3:
                System.out.println("Digite el lapiz a buscar\n1-Amarillo\n2-Blanco\n3.Cafe");
                int opcion= entrada.nextInt();
                System.out.println("Digiteel numero de lapiz que busca: ");
                numero= entrada.nextInt();
                switch (opcion){
                    case 1: color="Amarillo"; break;
                    case 2: color="Blanco"; break;
                    case 3: color="Cafe";break;
                }
            break;
        }
        Lapiz buscar = new Lapiz(color,numero);
        System.out.println(lista);
        Search<Lapiz> s = new Search<>();
        int encontrado=-1;
        encontrado=(s.binaria(lista,buscar,false));
        if (encontrado>=0) System.out.println("El Lapiz existe y se encuentra en la posicion "+encontrado+" del arraylist");
        else System.out.println("No existe, codigo"+encontrado);
    }
    public static void buscarLibros(){
        Libro l1, l2, l3, l4, l5,l6,l7,l8,l9,l10;
        l1 = new Libro("Fuegos",256);
        l2 = new Libro("Comedia",278);
        l3 = new Libro("Principito",567);
        l4 = new Libro("Luna",459);
        l5 = new Libro("HungerGames",589);
        l6 = new Libro("Lugares",200);
        l7 = new Libro("Chupa",167);
        l8 = new Libro("Elite",432);
        l9 = new Libro("Atlas",789);
        l10 = new Libro("Criaturitas",123);
        ArrayList<Libro> lista= new ArrayList<>();
        lista.add(l1);
        lista.add(l2);
        lista.add(l3);
        lista.add(l4);
        lista.add(l5);
        lista.add(l6);
        lista.add(l7);
        lista.add(l8);
        lista.add(l9);
        lista.add(l10);
        Collections.sort(lista);
        int respuestaB,numPaginas=0;
        String titulo=" ";
        do {
            System.out.println("Digite la opcion deseada: ");
            System.out.println("1. Ejemplo con un objeto existente\n2.ejemplo con un objeto inexistente\n3.Buscar ingresando los datos a buscar");
            respuestaB = entrada.nextInt();
        }while(respuestaB<1 || respuestaB>3);
        switch (respuestaB){
            case 1:
                titulo="HungerGames"; numPaginas=589;
                System.out.println("Se buscara el Libro:HungerGames, de 589 paginas");
                System.out.println("Para cambiar los valores exitentes a buscar, hacerlo en la linea 185");
            break;
            case 2:
                titulo="Luna"; numPaginas=654;
                System.out.println("Se buscara el Libro: Luna, con 654 paginas");
                System.out.println("Para cambiar los valores inexistentes a buscar, hacerlo en la linea 190");
            break;
            case 3:
                System.out.println("digite el nombre del libro que desea buscar: (si gusta, puede mirar de la linea 154 a la 163 para ver los elementos existentes)");
                titulo = entrada.next();
                System.out.println("Digite el numero de paginas del libro");
                numPaginas= entrada.nextInt();
            break;
        }

        Libro buscar = new Libro(titulo,numPaginas);
        System.out.println(lista);
        Search<Libro> s = new Search<>();
        int encontrado=-1;
        encontrado=(s.binaria(lista,buscar,false));
        if (encontrado>=0) System.out.println("El libro existe y se encuentra en la posicion "+encontrado+" del arraylist");
        else System.out.println("No existe, codigo"+encontrado);
    }
}