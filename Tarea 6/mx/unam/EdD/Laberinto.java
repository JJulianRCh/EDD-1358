/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

import java.io.*;

public class Laberinto {

    private final Arreglo2DADT<Character> tabla; //Tabla donde se almacena el laberinto
    private final Pilas<Casilla> pasos; //Esta pila guardaras las casillas recorridas en el laberinto
    private final int[] entrada = new int[2]; //La entrada del laberinto
    private final int[] salida = new int[2]; //La salida del laberinto

    public Laberinto(File file) throws Exception {
        FileReader f = new FileReader(file);
        BufferedReader arc = new BufferedReader(f);
        String linea = arc.readLine();
        String[] dato = linea.split(",");
        tabla = new Arreglo2DADT(Integer.parseInt(dato[0]), Integer.parseInt(dato[1]));
        llenarTabla(arc);
        pasos = new Pilas();
    }

    /**
     * Llena la tabla con los valores que se encuentran en el archivo dado.
     * <p>
     * '#' es muro y ' ' es una casilla libre.
     * <p>
     * Ademas asigna la casilla de entrada y salida
     *
     * @param arc archivo csv con caracteres que reprentan el laberinto
     * @throws IOException excepciones de lectura
     */
    private void llenarTabla(BufferedReader arc) throws IOException {
        String linea = arc.readLine();
        String[] dato;
        for (int i = 0; i < tabla.getFilas(); i++) {
            for (int j = 0; j < tabla.getColumnas(); j++) {
                dato = linea.split(",");
                tabla.setElemento(i, j, dato[j].charAt(0));
            }
            linea = arc.readLine();
        }
        dato = linea.split(",");
        entrada[0] = Integer.parseInt(dato[0]);
        entrada[1] = Integer.parseInt(dato[1]);
        linea = arc.readLine();
        dato = linea.split(",");
        salida[0] = Integer.parseInt(dato[0]);
        salida[1] = Integer.parseInt(dato[1]);
    }

    /**
     * Metodo recursivo. Resuelve en si el laberinto regresando si este se pudo
     * resolver.
     * <P>
     * Primero revisa si se puede ir a la izquierda.
     * <P>
     * si no entonces revisa arriba.
     * <P>
     * si no entonces revisa a la derecha.
     * <P>
     * si no entonces revisa abajo.
     * <P>
     * En caso de que no encontro un camino a seguir, se regresa y prueba otro
     * camino. Si llega a la salida entonces si hay solucion, si permanece a la
     * entrada entonces no hay.
     *
     * @param i posicion i de la casilla
     * @param j posicion j de la casilla
     * @return si el laberinto tiene solucion
     * @throws IndexOutOfBoundsException en caso de que se salga del tablero.
     */
    private boolean haySolucion(int i, int j) throws IndexOutOfBoundsException {
        if (i == salida[0] && j == salida[1]) {
            return true;
        }
        if (tabla.getElemento(i, j - 1) == ' ') {
            pasos.push(new Casilla(i, j - 1));
            tabla.setElemento(i, j - 1, '*');
            return haySolucion(pasos.peak().getX(), pasos.peak().getY());
        } else if (tabla.getElemento(i - 1, j) == ' ') {
            pasos.push(new Casilla(i - 1, j));
            tabla.setElemento(i - 1, j, '*');
            return haySolucion(pasos.peak().getX(), pasos.peak().getY());
        } else if (tabla.getElemento(i, j + 1) == ' ') {
            pasos.push(new Casilla(i, j + 1));
            tabla.setElemento(i, j + 1, '*');
            return haySolucion(pasos.peak().getX(), pasos.peak().getY());
        } else if (tabla.getElemento(i + 1, j) == ' ') {
            pasos.push(new Casilla(i + 1, j));
            tabla.setElemento(i + 1, j, '*');
            return haySolucion(pasos.peak().getX(), pasos.peak().getY());
        }
        if (i == entrada[0] && j == entrada[1]) {
            return false;
        }
        pasos.pop();
        tabla.setElemento(i, j, 'X');
        return haySolucion(pasos.peak().getX(), pasos.peak().getY());
    }

    /**
     * Guarda la entrada en la pila y lo marca en la tabla para posteriormente
     * llamar al metodo recursivo, si cumple entonces ya se resolvio si no
     * imprime un menjsaje indicando que no se pudo resolver.
     */
    public void resolverLaberinto() {
        pasos.push(new Casilla(entrada[0], entrada[1]));
        tabla.setElemento(entrada[0], entrada[1], '*');
        if (!haySolucion(entrada[0], entrada[1])) {
            System.out.println("No hay solucion");
        }
    }

    /**
     * Imprime la tabla que contiene el laberinto.
     */
    public void mostrarLaberinto() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabla.getElemento(i, j));
            }
            System.out.println("");
        }
    }
}

//Esta clase interna sirve para representar las posiciones en las casillas en el laberinto
class Casilla {

    private final int x;
    private final int y;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
