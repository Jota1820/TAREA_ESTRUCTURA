/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana10;

/**
 *
 * @author User
 */
// ImportO clases necesarias para manejar UUIDs y utilidades de objetos
import java.util.Objects;
import java.util.UUID;

// DefinO la clase Ciudadano que representa a una persona en el sistema de vacunación
public class Ciudadano {

    // Identificador único generado automáticamente (no depende de la cédula)
    private UUID id;

    // Cédula del ciudadano, usada como identificador lógico
    private String cedula;

    // Nombre del ciudadano
    private String nombre;

    // Estado de vacunación con Pfizer
    private boolean primeraDosisPfizer;
    private boolean segundaDosisPfizer;

    // Estado de vacunación con AstraZeneca
    private boolean primeraDosisAstraZeneca;
    private boolean segundaDosisAstraZeneca;

    // Constructor que inicializa los datos del ciudadano y marca todas las dosis como no aplicadas
    public Ciudadano(String cedula, String nombre) {
        this.id = UUID.randomUUID(); // Genero un ID único aleatorio
        this.cedula = cedula;
        this.nombre = nombre;
        this.primeraDosisPfizer = false;
        this.segundaDosisPfizer = false;
        this.primeraDosisAstraZeneca = false;
        this.segundaDosisAstraZeneca = false;
    }

    // Métodos de acceso (getters) para cédula, nombre e ID
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public UUID getId() {
        return id;
    }

    // Métodos de acceso y modificación (getters y setters) para cada dosis
    public boolean isPrimeraDosisPfizer() {
        return primeraDosisPfizer;
    }

    public void setPrimeraDosisPfizer(boolean primeraDosisPfizer) {
        this.primeraDosisPfizer = primeraDosisPfizer;
    }

    public boolean isSegundaDosisPfizer() {
        return segundaDosisPfizer;
    }

    public void setSegundaDosisPfizer(boolean segundaDosisPfizer) {
        this.segundaDosisPfizer = segundaDosisPfizer;
    }

    public boolean isPrimeraDosisAstraZeneca() {
        return primeraDosisAstraZeneca;
    }

    public void setPrimeraDosisAstraZeneca(boolean primeraDosisAstraZeneca) {
        this.primeraDosisAstraZeneca = primeraDosisAstraZeneca;
    }

    public boolean isSegundaDosisAstraZeneca() {
        return segundaDosisAstraZeneca;
    }

    public void setSegundaDosisAstraZeneca(boolean segundaDosisAstraZeneca) {
        this.segundaDosisAstraZeneca = segundaDosisAstraZeneca;
    }

    // Método que indica si el ciudadano ha recibido ambas dosis de alguna vacuna
    public boolean haRecibidoAmbasDosis() {
        return (primeraDosisPfizer && segundaDosisPfizer) || 
               (primeraDosisAstraZeneca && segundaDosisAstraZeneca);
    }

    // Método que indica si ha recibido solo ambas dosis de Pfizer
    public boolean haRecibidoSoloPfizer() {
        return primeraDosisPfizer && segundaDosisPfizer;
    }

    // Método que indica si ha recibido solo ambas dosis de AstraZeneca
    public boolean haRecibidoSoloAstraZeneca() {
        return primeraDosisAstraZeneca && segundaDosisAstraZeneca;
    }

    // Método que indica si no ha recibido ninguna dosis de ninguna vacuna
    public boolean noSeHaVacunado() {
        return !primeraDosisPfizer && !segundaDosisPfizer &&
               !primeraDosisAstraZeneca && !segundaDosisAstraZeneca;
    }

  
    @Override
    public String toString() {
        return "ID: " + id.toString().substring(0, 8) + 
               ", Cédula: " + cedula + 
               ", Nombre: " + nombre;
    }

  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Comparación por referencia
        if (o == null || getClass() != o.getClass()) return false; 
        Ciudadano ciudadano = (Ciudadano) o;
        return Objects.equals(cedula, ciudadano.cedula); // Compara por cédula
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
