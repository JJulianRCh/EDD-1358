/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package EdD.Tarea3;

import java.io.*;
import java.util.Scanner;

public class NominaADT {

    private ArregloADT<Empleado> nomina; // Arreglo que Almacenara informacion de los empleados

    public NominaADT(File archivo) throws Exception {
        try {
            BufferedReader f = new BufferedReader(new FileReader(archivo)); // Leemos el archvio
            Scanner leer = new Scanner(archivo); // Se uso Scanner para contar las lineas ya que...
            // si usamos 'f', habra errores para volver a recorre el arcivo
            int lineNo = 0;
            while (leer.hasNextLine()) {
                leer.nextLine();
                lineNo++; // Contamos cuantas lineas tiene el archivo
            }
            String linea;
            nomina = new ArregloADT<>(lineNo - 1); // El tamaño es de 14 para no contar una linea
            lineNo = 1; // Reinicio del contador
            int indice = 0;
            // Leemos cada linea y se guarda en la variable 'linea' y termina cuando llega a null
            while ((linea = f.readLine()) != null) {
                String[] tmp = linea.split(","); // Se guarda cada valor de la linea actual en un arreglo de String
                // Saltamos el encabezado
                if (lineNo > 1) {
                    Empleado emp = new Empleado(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3],
                            Integer.parseInt(tmp[4]),
                            Integer.parseInt(tmp[5]), Integer.parseInt(tmp[6]));
                    nomina.setElemento(indice, emp);
                    indice++;
                }
                ++lineNo;
            }
            // Cerramos el archivo
            f.close();
            leer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado\n" + ex.getMessage());
        }
    }

    /**
     * Enlista el sueldo final de los empleados del archivo por medio de un
     * ciclo for
     *
     */
    public void listarSueldos() {
        for (int i = 0; i < nomina.getLongitud(); i++) {
            Empleado emp = nomina.getElemento(i);
            System.out.printf("Id: %d sueldo: %.2f%n", emp.getNumDeTrabajador(), emp.calcularSueldo());
        }
    }

    /**
     * Busca en la lista cual es el empleado mas antigüo en la empresa
     *
     * @return empleado mas antigüo
     */
    public Empleado mayorAntiguedad() {
        int mayor = 2023;
        int idx = 0;
        for (int i = 0; i < nomina.getLongitud(); i++) {
            Empleado emp = nomina.getElemento(i);
            if (emp.getAñoDeIngreso() < mayor) {
                idx = i;
                mayor = emp.getAñoDeIngreso();
            }
        }
        return nomina.getElemento(idx);
    }

    /**
     * Busca en la lista cual es el empleado menos antigüo de la empresa
     *
     * @return empleado menos antigüo
     */
    public Empleado menorAntiguedad() {
        int menor = mayorAntiguedad().getAñoDeIngreso();
        int idx = 0;
        for (int i = 0; i < nomina.getLongitud(); i++) {
            Empleado emp = nomina.getElemento(i);
            if (emp.getAñoDeIngreso() > menor) {
                idx = i;
                menor = emp.getAñoDeIngreso();
            }
        }
        return nomina.getElemento(idx);
    }
}
