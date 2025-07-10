/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Stack;

// Defino la clase pública VerificadorBalanceo para contener todo el código relacionado con el verificador.
public class pilas {

    // Este método analiza una expresión y me dice si los paréntesis, corchetes y llaves están balanceados.
    public static boolean estaBalanceada(String expresion) {
        // Creo una pila que almacenará los caracteres de apertura 
        Stack<Character> pila = new Stack<>();

        // Recorro cada carácter de la expresión matemática.
        for (char c : expresion.toCharArray()) {
            // Si el carácter es una apertura, lo agrego a la pila.
            switch (c) {
                case '(': case '{': case '[':
                    pila.push(c);
                    break;

                // Si encuentro un cierre, verifico si está correctamente emparejado con el último abierto.
                case ')':
                    if (pila.isEmpty() || pila.pop() != '(') return false;
                    break;
                case '}':
                    if (pila.isEmpty() || pila.pop() != '{') return false;
                    break;
                case ']':
                    if (pila.isEmpty() || pila.pop() != '[') return false;
                    break;
            }
        }

        // Si la pila está vacía al final, entonces toda la expresión estaba balanceada.
        return pila.isEmpty();
    }

    // Método principal del programa: aquí lo ejecuto con una expresión de ejemplo.
    public static void main(String[] args) {
        // Guardo una expresión de prueba que contiene varios tipos de símbolos.
        String entrada = "{7 + (8 * 5) - [(9 - 7) + (4 + 1)]}";

        // Llamo al método estaBalanceada y muestro el resultado en consola.
        if (estaBalanceada(entrada)) {
            System.out.println("Formula balanceada."); // Si todo está bien, muestro este mensaje.
        } else {
            System.out.println("Formula no balanceada."); // Si hay algún error en los símbolos, muestro este otro.
        }
    }
}
