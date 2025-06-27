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

   

public class inverso {
    public static void main(String[] args) {
        // Crear y llenar la lista con números del 1 al 10
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        
        // Mostrar en orden inverso separados por comas
        for (int i = numeros.size() - 1; i >= 0; i--) {
            System.out.print(numeros.get(i));
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

