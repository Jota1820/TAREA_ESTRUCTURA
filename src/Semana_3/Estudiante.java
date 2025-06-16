/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_3;
/**
 * Creo esta clase Estudiante para manejar la información básica de un estudiante
 * La uso para almacenar y mostrar los datos principales que necesito
 * @author Jose Vasquez
 */
public class Estudiante {
    
    // Declaro los atributos privados que necesito para guardar la información del estudiante
    private int id;          // Uso este campo para identificar únicamente a cada estudiante
    private String nombres;   // Aquí guardo los nombres del estudiante
    private String apellidos; // En este atributo almaceno los apellidos
    private String direccion; // Uso esta variable para la dirección de residencia
    private String[] telefonos; // Creo un array para guardar múltiples números de teléfono
    
    // Creo el constructor para inicializar todos los datos cuando instancio un estudiante
    public Estudiante(int id, String nombres, String apellidos, String direccion, String[] telefonos) {
        // Asigno cada parámetro que recibo a su respectivo atributo de la clase
        this.id = id;             // Establezco el ID del estudiante
        this.nombres = nombres;   // Guardo los nombres recibidos
        this.apellidos = apellidos; // Almaceno los apellidos
        this.direccion = direccion; // Asigno la dirección
        this.telefonos = telefonos; // Copio el array de teléfonos
    }
    
    // Implemento este método para mostrar toda la información del estudiante en consola
    public void mostrarInformacion() {
        // Imprimo cada dato del estudiante de forma organizada
        System.out.println("ID: " + id);           // Muestro el identificador
        System.out.println("Nombres: " + nombres); // Imprimo los nombres
        System.out.println("Apellidos: " + apellidos); // Muestro los apellidos
        System.out.println("Direccion: " + direccion); // Imprimo la dirección
        System.out.println("Telefonos:");          // Indico que voy a mostrar los teléfonos
        
        // Uso un bucle for para recorrer y mostrar todos los números de teléfono
        for(int i = 0; i < 3; i++) {
            // Imprimo cada teléfono con un formato de lista
            System.out.println("  - " + telefonos[i]);
        }
    }
}