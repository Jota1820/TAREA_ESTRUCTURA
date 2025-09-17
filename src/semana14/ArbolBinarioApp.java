/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana14;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class ArbolBinarioApp {

    // Defino la clase ArbolBinario 
    static class ArbolBinario {
        Nodo raiz; // Este será el punto de partida del árbol

        public ArbolBinario() {
            raiz = null; // Inicializo el árbol vacío
        }

        // Método público para insertar un nuevo dato
        public void insertar(int dato) {
            raiz = insertarRec(raiz, dato); // Llamo al método recursivo
        }

        // Inserto el dato respetando la lógica del árbol binario de búsqueda
        private Nodo insertarRec(Nodo raiz, int dato) {
            if (raiz == null) {
                return new Nodo(dato); // Si no hay nodo, creo uno nuevo
            }
            if (dato < raiz.dato)
                raiz.izquierdo = insertarRec(raiz.izquierdo, dato); // Si es menor, va a la izquierda
            else if (dato > raiz.dato)
                raiz.derecho = insertarRec(raiz.derecho, dato); // Si es mayor, va a la derecha
            return raiz; // Retorno el nodo actualizado
        }

        // Recorrido inorden: izquierda - raíz - derecha
        public void inorden() {
            System.out.print("Recorrido Inorden: ");
            inordenRec(raiz);
            System.out.println();
        }

        private void inordenRec(Nodo raiz) {
            if (raiz != null) {
                inordenRec(raiz.izquierdo);
                System.out.print(raiz.dato + " ");
                inordenRec(raiz.derecho);
            }
        }

        // Recorrido preorden: raíz - izquierda - derecha
        public void preorden() {
            System.out.print("Recorrido Preorden: ");
            preordenRec(raiz);
            System.out.println();
        }

        private void preordenRec(Nodo raiz) {
            if (raiz != null) {
                System.out.print(raiz.dato + " ");
                preordenRec(raiz.izquierdo);
                preordenRec(raiz.derecho);
            }
        }

        // Recorrido postorden: izquierda - derecha - raíz.
        public void postorden() {
            System.out.print("Recorrido Postorden: ");
            postordenRec(raiz);
            System.out.println();
        }

        private void postordenRec(Nodo raiz) {
            if (raiz != null) {
                postordenRec(raiz.izquierdo);
                postordenRec(raiz.derecho);
                System.out.print(raiz.dato + " ");
            }
        }

        // Método para buscar un dato en el árbol.
        public boolean buscar(int dato) {
            return buscarRec(raiz, dato);
        }

        private boolean buscarRec(Nodo raiz, int dato) {
            if (raiz == null)
                return false; // Si no hay nodo, el dato no está
            if (raiz.dato == dato)
                return true; // Si coincide, lo encontré
            if (dato < raiz.dato)
                return buscarRec(raiz.izquierdo, dato); // Busco a la izquierda.
            else
                return buscarRec(raiz.derecho, dato); // Busco a la derecha.
        }

        // Método para eliminar un nodo del árbol.
        public void eliminar(int dato) {
            raiz = eliminarRec(raiz, dato);
        }

        private Nodo eliminarRec(Nodo raiz, int dato) {
            if (raiz == null)
                return raiz; // Si no hay nodo, no hay nada que eliminar

            if (dato < raiz.dato)
                raiz.izquierdo = eliminarRec(raiz.izquierdo, dato); // Busco a la izquierda
            else if (dato > raiz.dato)
                raiz.derecho = eliminarRec(raiz.derecho, dato); // Busco a la derecha
            else {
          
                if (raiz.izquierdo == null)
                    return raiz.derecho;
               
                else if (raiz.derecho == null)
                    return raiz.izquierdo;


                raiz.dato = minValor(raiz.derecho);
                raiz.derecho = eliminarRec(raiz.derecho, raiz.dato); // Elimino el sucesor
            }
            return raiz;
        }

        // Encuentro el valor mínimo en el subárbol derecho.
        private int minValor(Nodo raiz) {
            int minv = raiz.dato;
            while (raiz.izquierdo != null) {
                minv = raiz.izquierdo.dato;
                raiz = raiz.izquierdo;
            }
            return minv;
        }
    }

    // Clase Nodo que representa cada elemento del árbol.
    static class Nodo {
        int dato;
        Nodo izquierdo, derecho;

        public Nodo(int dato) {
            this.dato = dato;
            izquierdo = derecho = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario(); // Instancio el árbol.
        int opcion, dato;

        // Menú interactivo para operar sobre el árbol.
        do {
            System.out.println("\n--- Menu Árbol Binario ---");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Recorrido Inorden");
            System.out.println("3. Recorrido Preorden");
            System.out.println("4. Recorrido Postorden");
            System.out.println("5. Buscar elemento");
            System.out.println("6. Eliminar nodo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a insertar: ");
                    dato = sc.nextInt();
                    arbol.insertar(dato);
                    System.out.println("Nodo insertado.");
                    break;
                case 2:
                    arbol.inorden();
                    break;
                case 3:
                    arbol.preorden();
                    break;
                case 4:
                    arbol.postorden();
                    break;
                case 5:
                    System.out.print("Ingrese el dato a buscar: ");
                    dato = sc.nextInt();
                    if (arbol.buscar(dato))
                        System.out.println("Elemento encontrado.");
                    else
                        System.out.println("Elemento no encontrado.");
                    break;
                case 6:
                    System.out.print("Ingrese el dato a eliminar: ");
                    dato = sc.nextInt();
                    arbol.eliminar(dato);
                    System.out.println("Nodo eliminado si existía.");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7); // El ciclo se repite hasta que el usuario decida salir.

        sc.close(); 
    }
}