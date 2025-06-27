/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana5;

import java.util.*;

/**
 *
 * @author User
 */
public class Almacenar_asignaturas {
    
    // Declaro mi lista privada para almacenar las asignaturas
    private List<String> listaAsignaturas;
    
    // Creo el constructor para inicializar mi lista
    public Almacenar_asignaturas () {
        // Inicializo mi lista de asignaturas
        this.listaAsignaturas = new ArrayList<>();
        // Llamo al método para llenar las asignaturas
        llenarAsignaturas();
    }
    
    // Creo el método para llenar mi lista con las asignaturas del curso
    private void llenarAsignaturas() {
        // Agrego cada asignatura a mi lista
        listaAsignaturas.add("Matemáticas");
        listaAsignaturas.add("Física");
        listaAsignaturas.add("Química");
        listaAsignaturas.add("Historia");
        listaAsignaturas.add("Lengua");
    }
    
    // Creo el método para mostrar todas las asignaturas por pantalla
    public void mostrarAsignaturas() {
        // Recorro mi lista de asignaturas una por una
        for (String asignatura : listaAsignaturas) {
            // Muestro cada asignatura en pantalla
            System.out.println(asignatura);
        }
    }
    
    // Creo el método main donde ejecuto mi programa
    public static void main(String[] args) {
        // Creo un objeto de mi clase Asignaturas
        Asignaturas misAsignaturas = new Asignaturas();
        
        // Llamo al método para mostrar todas las asignaturas
        misAsignaturas.mostrarAsignaturas();
    }
}
