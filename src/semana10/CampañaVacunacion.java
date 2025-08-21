/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana10;

/**
 *
 * @author User
 */
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.UUID;

// Clase principal que simula una campaña de vacunación contra la COVID-19
public class CampañaVacunacion {

    public static void main(String[] args) {
        // Genero 500 ciudadanos sin vacuna (tipoVacuna = 0)
        Set<Ciudadano> ciudadanosTotal = generarCiudadanos(500, 0);

        // Genero 75 ciudadanos vacunados con Pfizer (tipoVacuna = 1)
        Set<Ciudadano> vacunadosPfizer = generarCiudadanos(75, 1);

        // Genero 75 ciudadanos vacunados con AstraZeneca (tipoVacuna = 2)
        Set<Ciudadano> vacunadosAstraZeneca = generarCiudadanos(75, 2);

        // Actualizo el estado de vacunación en el conjunto total, comparando por cédula
        actualizarEstadoVacunacion(ciudadanosTotal, vacunadosPfizer, "Pfizer");
        actualizarEstadoVacunacion(ciudadanosTotal, vacunadosAstraZeneca, "AstraZeneca");

        // Encabezado informativo
        System.out.println("Campana de Vacunacion COVID-19");
        System.out.println("------------------------------------");

        // Filtra ciudadanos que no han recibido ninguna dosis
        Set<Ciudadano> noVacunados = ciudadanosTotal.stream()
                .filter(Ciudadano::noSeHaVacunado)
                .collect(Collectors.toSet());
        System.out.println("### 1. Ciudadanos que no se han vacunado (" + noVacunados.size() + " ciudadanos)");
        noVacunados.forEach(System.out::println);
        System.out.println("---");

        // Filtra ciudadanos que han recibido ambas dosis de alguna vacuna
        Set<Ciudadano> conAmbasDosis = ciudadanosTotal.stream()
                .filter(Ciudadano::haRecibidoAmbasDosis)
                .collect(Collectors.toSet());
        System.out.println("### 2. Ciudadanos que han recibido ambas dosis (" + conAmbasDosis.size() + " ciudadanos)");
        conAmbasDosis.forEach(System.out::println);
        System.out.println("---");

        // Filtra ciudadanos que han recibido ambas dosis de Pfizer exclusivamente
        Set<Ciudadano> soloPfizer = ciudadanosTotal.stream()
                .filter(Ciudadano::haRecibidoSoloPfizer)
                .collect(Collectors.toSet());
        System.out.println("### 3. Ciudadanos que solo han recibido la vacuna de Pfizer (" + soloPfizer.size() + " ciudadanos)");
        soloPfizer.forEach(System.out::println);
        System.out.println("---");

        // Filtra ciudadanos que han recibido ambas dosis de AstraZeneca exclusivamente
        Set<Ciudadano> soloAstraZeneca = ciudadanosTotal.stream()
                .filter(Ciudadano::haRecibidoSoloAstraZeneca)
                .collect(Collectors.toSet());
        System.out.println("### 4. Ciudadanos que solo han recibido la vacuna de AstraZeneca (" + soloAstraZeneca.size() + " ciudadanos)");
        soloAstraZeneca.forEach(System.out::println);
        System.out.println("---");
    }

    // Método que genera ciudadanos ficticios con cédula, nombre y estado de vacunación según tipo
    private static Set<Ciudadano> generarCiudadanos(int cantidad, int tipoVacuna) {
        Set<Ciudadano> ciudadanos = new HashSet<>();
        for (int i = 0; i < cantidad; i++) {
            // Cédula formateada como número de 10 dígitos (ej. 0000000001)
            String cedula = String.format("%010d", i);
            String nombre = "Ciudadano " + i;
            Ciudadano c = new Ciudadano(cedula, nombre);

            // Asigno estado de vacunación según el tipo
            if (tipoVacuna == 1) {
                c.setPrimeraDosisPfizer(true);
                c.setSegundaDosisPfizer(true);
            } else if (tipoVacuna == 2) {
                c.setPrimeraDosisAstraZeneca(true);
                c.setSegundaDosisAstraZeneca(true);
            }

            ciudadanos.add(c);
        }
        return ciudadanos;
    }

    // Método que actualiza el estado de vacunación en el conjunto total comparando por cédula
    private static void actualizarEstadoVacunacion(Set<Ciudadano> total, Set<Ciudadano> vacunados, String tipoVacuna) {
        for (Ciudadano ciudadanoTotal : total) {
            for (Ciudadano ciudadanoVacunado : vacunados) {
                // Si las cédulas coinciden, se actualiza el estado de vacunación
                if (ciudadanoTotal.getCedula().equals(ciudadanoVacunado.getCedula())) {
                    if ("Pfizer".equals(tipoVacuna)) {
                        ciudadanoTotal.setPrimeraDosisPfizer(true);
                        ciudadanoTotal.setSegundaDosisPfizer(true);
                    } else if ("AstraZeneca".equals(tipoVacuna)) {
                        ciudadanoTotal.setPrimeraDosisAstraZeneca(true);
                        ciudadanoTotal.setSegundaDosisAstraZeneca(true);
                    }
                }
            }
        }
    }
}
