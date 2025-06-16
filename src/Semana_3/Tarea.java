/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana_3;

import SEMANA_3.Estudiante;

/**
 *
 * @author User
 */
public class Tarea {
     public static void main(String[] args){
         String [] telefonos ={"0985775578578", "07545555","451266666"};
         Estudiante estudiantes = new Estudiante(1,"Jairo","Vasquez","Puengasi",telefonos);
         estudiantes.mostrarInformacion();
    }
}
