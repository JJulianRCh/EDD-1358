/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

public class testColas {
    
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        cola.enqueue(22);
        cola.enqueue(23);
        cola.enqueue(4);
        cola.enqueue(45);
        cola.enqueue(10);
        cola.enqueue(34);
        cola.enqueue(12);
        cola.dequeue();
        System.out.println(cola);
    }
}
