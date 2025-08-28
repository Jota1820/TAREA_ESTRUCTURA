/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana11;
 import java.util.*;
/**
 *
 * @author User
 */
public class TraductorSimple {
   


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Se declara e inicializa un diccionario (HashMap)
        Map<String, String> diccionario = new HashMap<>();

 // Se cargan  palabras base al diccionario
       diccionario.put("día", "day"); 
        diccionario.put("tiempo", "time");
        diccionario.put("persona", "person");
        diccionario.put("año", "year");
        diccionario.put("camino", "way");
        diccionario.put("forma", "way");
        diccionario.put("cosa", "thing");
        diccionario.put("hombre", "man");
        diccionario.put("mundo", "world");
        diccionario.put("vida", "life");
        diccionario.put("mano", "hand");
        diccionario.put("parte", "part");
        diccionario.put("niño", "child");
        diccionario.put("niña", "child");
        diccionario.put("ojo", "eye");
        diccionario.put("mujer", "woman");
        diccionario.put("lugar", "place");
        diccionario.put("trabajo", "work");
        diccionario.put("semana", "week");
        diccionario.put("caso", "case");
        diccionario.put("punto", "point");
        diccionario.put("tema", "point");
        diccionario.put("gobierno", "government");
        diccionario.put("empresa", "company");
        diccionario.put("compañía", "company");

        int opcion;// Variable para almacenar la opción del menú seleccionada por el usuario
        do {
            // Se muestra el menú interactivo
            System.out.println("\n===== MEN =====");
            System.out.println("1. Traducir frase");
            System.out.println("2. Agregar palabra");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            // Se lee la opción ingresada por el usuario
            opcion = scanner.nextInt();
            
            scanner.nextLine(); // limpiar buffer
 // Si el usuario elige traducir una frase
            if (opcion == 1) {
                System.out.print("Ingrese frase en español: ");
                String frase = scanner.nextLine().toLowerCase();
                // Divide la frase en palabras usando el espacio como separador
                String[] palabras = frase.split(" ");
                // Recorre cada palabra para traducirla si está en el diccionario
                for (String p : palabras) {
                    // Elimina signos de puntuación 
                    String limpia = p.replaceAll("[^a-záéíóúñ]", "");
                    System.out.print(diccionario.getOrDefault(limpia, p) + " ");
                }
                System.out.println();
                // Si el usuario elige agregar una nueva palabra al diccionario
            } else if (opcion == 2) {
                System.out.print("Palabra en español: ");
                String esp = scanner.nextLine().toLowerCase();
                System.out.print("Traducción al inglés: ");
                String ing = scanner.nextLine().toLowerCase();
                // Agrega la nueva palabra al diccionario
                diccionario.put(esp, ing);
                System.out.println("Agregada correctamente.");
            }
        } while (opcion != 0); // El bucle se repite mientras la opción no sea salir 0
    }
}

