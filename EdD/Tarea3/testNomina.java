/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package EdD.Tarea3;

import java.io.File;

public class testNomina {
    
    public static void main(String[] args) throws Exception {
        NominaADT nomina = new NominaADT(new File("C:\\Users\\jjgam\\OneDrive\\Documentos\\junio.dat"));
        nomina.listarSueldos();
        System.out.println("El empleado mas antigüo es: " + nomina.mayorAntiguedad());
        System.out.println("El empleado menos antigüo es: " + nomina.menorAntiguedad());
    }
}
