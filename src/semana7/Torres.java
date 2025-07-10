/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana7;

/**
 *
 * @author User
 */
import java.util.Stack;

public class Torres {

    // Método para mover discos entre torres
    public static void resolverHanoi(
            int n, Stack<Integer> origen, Stack<Integer> destino, Stack<Integer> auxiliar,
                                    String nombreOrigen, String nombreDestino, String nombreAuxiliar) {
        if (n > 0) {
            // Muevo n-1 discos del origen a la torre auxiliar
            resolverHanoi(n - 1, origen, auxiliar, destino, nombreOrigen, nombreAuxiliar, nombreDestino);

            // Muevo el disco restante del origen al destino
            int disco = origen.pop();
            destino.push(disco);
            System.out.println("Mover disco " + disco + " de " + nombreOrigen + " a " + nombreDestino);

            // Muevo los n-1 discos de la auxiliar al destino
            resolverHanoi(n - 1, auxiliar, destino, origen, nombreAuxiliar, nombreDestino, nombreOrigen);
        }
    }

    public static void main(String[] args) {
        int numDiscos = 3; // Aquí puedes cambiar el número de discos

        // Creo tres pilas para representar las torres
        Stack<Integer> torreOrigen = new Stack<>();
        Stack<Integer> torreAuxiliar = new Stack<>();
        Stack<Integer> torreDestino = new Stack<>();

        // Inicializo la torre de origen con los discos (del más grande abajo al más pequeño arriba)
        for (int i = numDiscos; i >= 1; i--) {
            torreOrigen.push(i);
        }

        // Muestro el estado inicial
        System.out.println("Estado inicial:");
        System.out.println("Origen: " + torreOrigen);
        System.out.println("Auxiliar: " + torreAuxiliar);
        System.out.println("Destino: " + torreDestino);
        System.out.println("\nPasos del movimiento:\n");

        // Llamo al método para resolver el problema
        resolverHanoi(numDiscos, torreOrigen, torreDestino, torreAuxiliar, "Origen", "Destino", "Auxiliar");

        // Muestro el estado final
        System.out.println("\nEstado final:");
        System.out.println("Origen: " + torreOrigen);
        System.out.println("Auxiliar: " + torreAuxiliar);
        System.out.println("Destino: " + torreDestino);
    }
}