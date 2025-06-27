/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner; // Importamos Scanner para leer datos del usuario

// Clase principal del programa
public class Contador_vocales {
    
    // Método principal donde inicia el programa
    public static void main(String[] args) {
        // Creamos el objeto Scanner para leer lo que escribe el usuario
        Scanner input = new Scanner(System.in);
        
        // Pedimos al usuario que escriba una palabra
        System.out.print("Escribe una palabra: ");
        String palabra = input.nextLine(); // Guardamos la palabra 
        
        // Creamos un objeto de la clase Contador
        Contador contador = new Contador();
        
        // Le pasamos la palabra al contador para que cuente las vocales
        contador.contar(palabra);
        
        // Cerramos el Scanner
        input.close();
    }
}

// Clase que cuenta las vocales
class Contador {
    
    // Método que cuenta y muestra las vocales
    public void contar(String palabra) {
        // Variables para contar cada vocal
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        
        // Convertimos la palabra a minúsculas para contar mejor
        palabra = palabra.toLowerCase();
        
        // Recorremos cada letra de la palabra
        for (int j = 0; j < palabra.length(); j++) {
            char letra = palabra.charAt(j); // Tomamos una letra
            
            // Verificamos si es una vocal y la contamos
            if (letra == 'a') a++; // Si es 'a', sumamos 1 al contador de a
            if (letra == 'e') e++; // Si es 'e', sumamos 1 al contador de e
            if (letra == 'i') i++; // Si es 'i', sumamos 1 al contador de i
            if (letra == 'o') o++; // Si es 'o', sumamos 1 al contador de o
            if (letra == 'u') u++; // Si es 'u', sumamos 1 al contador de u
        }
        
        // Mostramos los resultados
        System.out.println("Resultados:");
        System.out.println("a: " + a + " veces"); // Mostramos cuántas 'a' encontramos
        System.out.println("e: " + e + " veces"); // Mostramos cuántas 'e' encontramos
        System.out.println("i: " + i + " veces"); // Mostramos cuántas 'i' encontramos
        System.out.println("o: " + o + " veces"); // Mostramos cuántas 'o' encontramos
        System.out.println("u: " + u + " veces"); // Mostramos cuántas 'u' encontramos
    }
}
