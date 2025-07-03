/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Elementos {

    // Defino una clase interna 
    class Nodo {
        int dato;      // Aquí guardo el valor entero del nodo
        Nodo siguiente; // Aquí guardo la referencia al siguiente nodo

        Nodo(int dato) {
            
            this.dato = dato;
            this.siguiente = null;
        }
    }

    Nodo cabeza = null; // Inicializo la cabeza de la lista como nula

    // Agrego un nodo al final de la lista
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato); // Creo un nuevo nodo con el dato
        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevo;
        } else {
            // Si no está vacía, recorro hasta el último nodo
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            // Enlazo el nuevo nodo al final de la lista
            actual.siguiente = nuevo;
        }
    }

    // Método para contar la longitud de la lista
    public int longitud() {
        int contador = 0;         // Inicializo un contador para contar los nodos
        Nodo actual = cabeza;     // Comienzo desde la cabeza de la lista
        while (actual != null) { 
            contador++;           // Aumento el contador
            actual = actual.siguiente; // Paso al siguiente nodo
        }
        return contador; // Devuelvo la cantidad total de nodos
    }

    // Método principal
    public static void main(String[] args) {
        Elementos lista = new Elementos(); // Creo una nueva lista
        lista.agregar(5);  // Agrego un nodo con el dato 5
        lista.agregar(10); // Agrego otro nodo con el dato 10
        lista.agregar(20); // Otro más con el dato 20

        // Muestro la longitud de la lista
        System.out.println("La longitud de la lista es: " + lista.longitud());
    }
}