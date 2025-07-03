/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

*/
public class Invertir_lista {
    
    // Clase interna para representar un nodo
    
    class Nodo {
        int dato;           // Aquí almaceno el valor del nodo
        Nodo siguiente;     // Esta variable apunta al próximo nodo en mi lista
        
        // Constructor: cuando creo un nodo, le asigno un valor
        Nodo(int dato) {
            this.dato = dato;           // Guardo el valor que me pasan
            this.siguiente = null;      // Inicializo sin conexión a otro nodo
        }
    }
    
    // Cabeza de la lista - es mi punto de entrada a toda la estructura
    Nodo cabeza;
    
    // Constructor: inicializo mi lista vacía
    public Invertir_lista() {
        cabeza = null;  // Al principio no tengo ningún nodo
    }
    
    // Método para agregar un elemento al final de mi lista
    public void agregar(int dato) {
        // Creo un nuevo nodo con el dato que me pasan
        Nodo nuevoNodo = new Nodo(dato);
        
        // Si mi lista está vacía, este será el primer nodo
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            // Si ya tengo elementos, busco el último nodo para conectar el nuevo
            Nodo presente = cabeza;
            while (presente.siguiente != null) {
                presente = presente.siguiente;  // Avanzo hasta el final
            }
            presente.siguiente = nuevoNodo;  // Conecto el nuevo nodo al final
        }
    }
    
    // Método para mostrar todos los elementos de mi lista
    public void mostrar() {
        Nodo presente = cabeza;  // Empiezo desde la cabeza
        System.out.print("Lista: ");
        
        // Recorro toda mi lista e imprimo cada valor
        while (presente != null) {
            System.out.print(presente.dato + " -> ");
            presente = presente.siguiente;  // Avanzo al siguiente nodo
        }
        System.out.println("null");  // Indico el final de la lista
    }
    
    // MÉTODO PRINCIPAL: Invertir la lista
    public void invertir() {
        
        Nodo anterior = null;        
        Nodo presente = cabeza;     
        Nodo proximo = null;        
        
        // Recorro toda mi lista hasta llegar al final
        while (presente != null) {
            
            proximo = presente.siguiente;
        
            presente.siguiente = anterior;
            
          
            anterior = presente;      // El nodo presente se convierte en el anterior
            presente = proximo;       // Avanzo al siguiente nodo para procesarlo
        }
        
       
        cabeza = anterior;
    }
    
    // Método main 
    public static void main(String[] args) {
        // Creo una nueva instancia de mi lista enlazada
        Invertir_lista lista = new Invertir_lista();
        
        // Agrego varios elementos para probar la funcionalidad
        System.out.println("=== AGREGANDO ELEMENTOS A MI LISTA ===");
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);
        
        // Muestro cómo se ve mi lista antes de invertirla
        System.out.println("\nAsi se ve mi lista original:");
        lista.mostrar();
        
        // Aplico el método de inversión
        System.out.println("\n=== INVIRTIENDO MI LISTA ===");
        lista.invertir();
        
        // Muestro el resultado después de la inversión
        System.out.println("\nAsi quedo mi lista después de invertirla:");
        lista.mostrar();
        
        // Hago una segunda prueba con números diferentes
        System.out.println("\n=== SEGUNDO EJEMPLO CON OTROS NUMEROS ===");
        Invertir_lista lista2 = new Invertir_lista();
        lista2.agregar(10);
        lista2.agregar(20);
        lista2.agregar(30);
        
        System.out.println("Mi segunda lista original:");
        lista2.mostrar();
        
        lista2.invertir();
        System.out.println("Mi segunda lista invertida:");
        lista2.mostrar();
    }
}
