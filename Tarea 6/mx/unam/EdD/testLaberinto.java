/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

import java.io.File;

public class testLaberinto {

    public static void main(String[] args) {
        try {
            Laberinto lab = new Laberinto(new File("Laberinto.csv"));
            System.out.println("Laberinto: ");
            lab.mostrarLaberinto();
            lab.resolverLaberinto();
            System.out.println("\nSolucion: ");
            lab.mostrarLaberinto();
        } catch (Exception ex) {
            System.out.println("Error en leer el laberinto");
        }
    }
}
