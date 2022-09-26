/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

public class testLista {
    
    public static void main(String[] args) {
        // Lista a mostrar 1, 4, 5, 10, 8, 14, 20. Tamaño = 7
        ListaDoblementeLigadaADT<Integer> head = new ListaDoblementeLigadaADT<>();
        head.agregarAlFinal(5);
        head.agregarAlFinal(20);
        head.agregarAlInicio(12);
        head.agregarDespuesDe(5, 8);
        head.agregarAlFinal(36);
        head.agregarDespuesDe(5, 10);
        head.agregarAlInicio(1);
        head.agregarDespuesDe(8, 21);
        head.agregarDespuesDe(21, 14);
        head.agregarAlInicio(3);
        head.eliminarFinal();
        head.eliminarPrimero();
        head.eliminar(6);
        head.actualizar(12, 4);
        head.transversal(true);
        head.transversal(false);
        System.out.println("Tamaño: " + head.getTamaño());
    }
}
