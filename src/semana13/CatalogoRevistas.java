/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana13;

/**
 *
 * @author User
 */
import java.util.ArrayList; // Importo ArrayList 
import java.util.Scanner; // Importo Scanner para poder leer la entrada del usuario

public class CatalogoRevistas { // creo la clase para manejar todo el sistema
    private ArrayList<String> catalogo; // Declaro mi lista donde guardaré los títulos de las revistas
    private Scanner scanner; // Declaro mi scanner para interactuar con el usuario
    
    public CatalogoRevistas() { // En mi constructor inicializo todo lo que necesito
        catalogo = new ArrayList<>(); // Creo mi ArrayList vacío
        scanner = new Scanner(System.in); 
        inicializarCatalogo(); 
    }
    
    private void inicializarCatalogo() { // Aquí agrego las 10 revistas que me pidieron
        catalogo.add("National Geographic"); 
        catalogo.add("Time Magazine"); 
        catalogo.add("Forbes"); 
        catalogo.add("Vogue"); 
        catalogo.add("Scientific American"); 
        catalogo.add("The Economist"); 
        catalogo.add("Sports Illustrated"); 
        catalogo.add("Popular Science"); 
        catalogo.add("Cosmopolitan"); 
        catalogo.add("Reader's Digest"); 
    }
    
   public boolean busquedaRecursiva(String titulo) { // Elegí usar búsqueda recursiva 
        return busquedaRecursivaAuxiliar(titulo, 0); // Llamo a mi método auxiliar empezando en índice 0
    }
    
    private boolean busquedaRecursivaAuxiliar(String titulo, int indice) { // Mi método auxiliar recursivo
        if (indice >= catalogo.size()) { // si llegué al final de la lista
            return false; // sino encontra el título, devuelvo false
        }
        
        if (catalogo.get(indice).equalsIgnoreCase(titulo)) { //  si encontré el título
            return true; // Devuelvo true porque lo encontré
        }
        
        return busquedaRecursivaAuxiliar(titulo, indice + 1); // busco en el siguiente índice
    }
    
    public void mostrarMenu() { // creo el  método principal para mostrar el menú 
        int opcion; // Variable para guardar la opción que elija el usuario
        
        do { // Uso do-while para que el menú se ejecute al menos una vez
            System.out.println("=== SISTEMA DE BÚSQUEDA DE REVISTAS ==="); 
            System.out.println("1. Buscar revista"); 
            System.out.println("2. Salir"); 
            System.out.print("Seleccione una opción: "); 
            
            opcion = scanner.nextInt(); // Leo la opción del usuario
            scanner.nextLine(); 
            
            switch (opcion) { // Evalúo qué opción eligió el usuario
                case 1: // Si eligió buscar revista
                    System.out.print("Ingrese el título de la revista a buscar: "); // Pido el título
                    String titulo = scanner.nextLine(); // Leo el título completo
                    
                    if (busquedaRecursiva(titulo)) { // Llamo a mi método recursivo
                        System.out.println("Resultado: Encontrado\n"); // Muestro que sí existe
                    } else {
                        System.out.println("Resultado: No encontrado\n"); // Muestro que no existe
                    }
                    break; // Salgo de este case
                    
                case 2: // Si eligió salir
                    System.out.println("¡Gracias por usar el sistema!"); // Mensaje de despedida
                    break; // Salgo de este case
                    
                default: // Si eligió una opción inválida
                    System.out.println("Opción inválida. Intente nuevamente.\n"); // Mensaje de error
            }
            
        } while (opcion != 2); // Repito mientras no elija salir
    }
    
    public static void main(String[] args) { // Mi método main para ejecutar el programa
        CatalogoRevistas catalogo = new CatalogoRevistas(); // Creo una instancia de mi clase
        catalogo.mostrarMenu(); // Ejecuto el menú principal
    }
}