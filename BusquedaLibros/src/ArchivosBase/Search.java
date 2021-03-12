package ArchivosBase;
import java.util.ArrayList;
public class Search <T extends Comparable<T>>{
    public int binaria(ArrayList<T> a, T b, boolean d){
        int pos = -1;
        int tam = (a.size()-1)/2;
        int inicio=0, fin = a.size()-1;
        int centro = tam;

        while (inicio<=fin){
            centro = inicio + (fin - inicio) / 2;
            if (d){
                System.out.println("inicio:" + inicio + " fin:" + fin + " centro:" + centro + " tam:"+tam);
            }
            if (b.compareTo(a.get(centro)) == 0){ // El elemento
                pos = centro;
                // se encuentra
            }
            // compareTo   regresa 0 si los elementos son iguales
            //             regresa valor positivo si el elemento es mayor
            //             regresa valor negativo si el elemento es menor
            if (b.compareTo(a.get(centro)) > 0){  // b es mayor a centro Derecha
                inicio = centro +1;
            }
            else
            {
                fin = centro - 1;
                // izquierda
            }
            tam /= 2;

        }

        return pos;
    }
}
