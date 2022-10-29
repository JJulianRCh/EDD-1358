/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

import java.io.*;

public class Laberinto {

    private final Arreglo2DADT<Character> tabla; //Tabla donde se almacena el laberinto
    private final Pilas<Casilla> pasos; //Esta pila guardaras las casillas recorridas en el laberinto
    private Casilla entrada; //La entrada del laberinto
    private Casilla salida; //La salida del laberinto

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
        entrada = new Casilla(Integer.parseInt(dato[0]), Integer.parseInt(dato[1]));
        linea = arc.readLine();
        dato = linea.split(",");
        salida = new Casilla(Integer.parseInt(dato[0]), Integer.parseInt(dato[1]));
    }

    /**
     * Revisar si hay una casilla libre para avanzar. En caso de que el tablero
     * se salga de sus limites se regresara un false.
     *
     * @param x posicion X de la casilla
     * @param y posicion Y de la casilla
     * @return si hay camino libre en el laberinto
     */
    private boolean hayCasillaLibre(int x, int y) {
        try {
            return tabla.getElemento(x, y) == ' ';
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
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
    private boolean haySolucion(int i, int j) {
        if (i == salida.x && j == salida.y) {
            return true;
        }
        if (hayCasillaLibre(i, j - 1)) {
            pasos.push(new Casilla(i, j - 1));
            tabla.setElemento(i, j - 1, '*');
        } else if (hayCasillaLibre(i - 1, j)) {
            pasos.push(new Casilla(i - 1, j));
            tabla.setElemento(i - 1, j, '*');
        } else if (hayCasillaLibre(i, j + 1)) {
            pasos.push(new Casilla(i, j + 1));
            tabla.setElemento(i, j + 1, '*');
        } else if (hayCasillaLibre(i + 1, j)) {
            pasos.push(new Casilla(i + 1, j));
            tabla.setElemento(i + 1, j, '*');
        } else if (i == entrada.x && j == entrada.y) {
            return false;
        } else {
            pasos.pop();
            tabla.setElemento(i, j, 'X');
        }
        return haySolucion(pasos.peak().x, pasos.peak().y);
    }

    /**
     * Guarda la entrada en la pila y lo marca en la tabla para posteriormente
     * llamar al metodo recursivo, si cumple entonces ya se resolvio si no
     * imprime un menjsaje indicando que no se pudo resolver.
     */
    public void resolverLaberinto() {
        pasos.push(entrada);
        tabla.setElemento(entrada.x, entrada.y, '*');
        if (!haySolucion(pasos.peak().x, pasos.peak().y)) {
            System.out.println("No hay solucion");
        }
    }

    /**
     * Imprime la tabla que contiene el laberinto.
     */
    public void mostrarLaberinto() {
        for (int i = 0; i < tabla.getFilas(); i++) {
            for (int j = 0; j < tabla.getColumnas(); j++) {
                System.out.print(tabla.getElemento(i, j));
            }
            System.out.println("");
        }
    }
}

//Esta clase interna sirve para representar las posiciones en las casillas en el laberinto
class Casilla {

    int x;
    int y;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
