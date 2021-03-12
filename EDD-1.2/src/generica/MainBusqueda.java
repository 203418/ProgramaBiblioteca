package generica;
import java.util.ArrayList;
import java.util.Collections;

public class MainBusqueda {
    public static void main(String[] args) {
        Libro l1, l2, l3, l4, l5;
        l1 = new Libro("3 Fuegos",256);
        l2 = new Libro("Divina Comedia",278);
        l3 = new Libro("El Principito",567);
        l4 = new Libro("Luna De Pluton",459);
        l5 = new Libro("Los Juegos Del Hambre",589);
        Libro buscar = new Libro("El Principito",567);
       // System.out.println(b1.compareTo(b2));
        ArrayList<Libro> lista= new ArrayList<>();
        lista.add(l1);
        lista.add(l2);
        lista.add(l3);
        lista.add(l4);
        lista.add(l5);
        Collections.sort(lista);
        System.out.println(lista);
        Search<Libro> s = new Search<>();
        System.out.println(s.binaria(lista,buscar,false));

    }
}


