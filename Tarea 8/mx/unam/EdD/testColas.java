/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

public class testColas {
    
    public static void main(String[] args) {
        ColasPrioridadAcotada<String> barco = new ColasPrioridadAcotada<>(7);
        barco.enqueue(4, "Maestre");
        barco.enqueue(2, "Niños");
        barco.enqueue(4, "Mecánico");
        barco.enqueue(3, "Mujeres");
        barco.enqueue(2, "3ra Edad");
        barco.enqueue(1, "Niñas");
        barco.enqueue(3, "Hombres");
        barco.enqueue(4, "Vigia");
        barco.enqueue(5, "Capitan");
        barco.enqueue(4, "Timonel");
        System.out.println(barco);
        System.out.println("Tamaño: " + barco.longitud()); // 10 elementos
        System.out.println(barco.dequeue()); //Debe mostrar "Niñas"
    }
}
