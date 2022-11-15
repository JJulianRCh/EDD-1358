/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

public class testTablaHash {

    public static void main(String[] args) {
        TablaHash<Integer, String> tabla = new TablaHash<>(13);
        System.out.println(tabla.add(236, "Jose"));
        System.out.println(tabla.add(526, "A"));
        tabla.add(313, "B");
        tabla.add(29, "C");
        tabla.add(187, "D");
        System.out.println(tabla.add(435, "E"));
        System.out.println(tabla.valueOf(435));
        System.out.println(tabla);
        tabla.remove(526);
        System.out.println(tabla);
    }
}
