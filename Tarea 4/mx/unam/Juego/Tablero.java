/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.Juego;

import mx.unam.EdD.Arreglo2DADT;
import javax.swing.JOptionPane;

public class Tablero {

    private final Arreglo2DADT<Character> tabla;

    public Tablero() {
        tabla = new Arreglo2DADT<>(10, 10);
        // Se genera la tabla en donde todas las celulas estan muertas
        for (int i = 0; i < tabla.getFilas(); i++) {
            for (int j = 0; j < tabla.getColumnas(); j++) {
                tabla.setElemento(i, j, '-');
            }
        }
    }

    /**
     * Revisa si en la celda se encuentra una celula viva y regresa un booleano
     * con respecto al estado de la celula, si esta viva es decir, si la celda
     * es igual a '+' entonces regresa un true mientras que si la celda tiene
     * un '-' entonces regresa un false
     * 
     * Un try catch se encargara si los parametros no se salen del rango de
     * la tabla y en caso de que haya una excepcion, se regresa un false
     *
     * @param fila el numero de la fila donde se encuentra la celda deseada
     * @param columna el numero de la columna donde se encuentra la celda
     * deseada
     * @return el estado de la celula(true si esta viva o false si no)
     */
    private boolean celulaViva(int fila, int columna) {
        try {
            return tabla.getElemento(fila, columna) == '+';
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    /**
     * Se ingresa una celula viva en un espacio especifico de la tabla pero
     * primero se revisa si la celula esta muerta para realizar el cambio, en
     * caso de que la celula ya se encuentre viva no se realizara ningun cambio
     * y se mostrara un mensaje indicando que la celula ya esta viva
     *
     * Un try catch se encargara si los valores de los parametros son validos y
     * no superan el tamaño de la tabla
     *
     * @param fila numero de fila donde se ingresara la celula viva
     * @param columna numeero de columna donde se ingresara la celula viva
     */
    public void ingresarCelulaViva(int fila, int columna) {
        try {
            if (!celulaViva(fila, columna)) {
                tabla.setElemento(fila, columna, '+');
            } else {
                JOptionPane.showMessageDialog(null, "La celula escogida ya esta viva", "Juego de la vida", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "No puede salir del rango", "Juego de la vida", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Se remueve una celula viva que fue ingresada anteriormente en una celda
     * especifica pero primero se revisa si la celula seleccionada se encuentra
     * viva para realizar el cambio, en caso de que no simplemente muestra un
     * mensaje de error
     *
     * Un try catch se encargara si los valores de los parametros son validos y
     * no superan el tamaño de la tabla
     *
     * @param fila numero de la fila donde se encuentra la celula viva a remover
     * @param columna numero de la columna donde se encuentra la celula viva a
     * remover
     */
    public void removerCelula(int fila, int columna) {
        try {
            if (celulaViva(fila, columna)) {
                tabla.setElemento(fila, columna, '-');
            } else {
                JOptionPane.showMessageDialog(null, "La celula escogida ya esta muerta", "Juego de la vida", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "No puede salir del rango", "Juego de la vida", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cuenta las celulas vivas que se encuentran alrededor de la celda en turno
     * a traves de una condición de si la celula esta viva
     *
     * @param fila numero de la fila donde esta la celda actual
     * @param columna numero de la columna donde esta la celda actual
     * @return el numero de celulas vivas encontradas
     */
    private int contarVivas(int fila, int columna) {
        int cont = 0;
        if (celulaViva(fila - 1, columna - 1)) {
            cont++;
        }
        if (celulaViva(fila - 1, columna)) {
            cont++;
        }
        if (celulaViva(fila - 1, columna + 1)) {
            cont++;
        }
        if (celulaViva(fila, columna - 1)) {
            cont++;
        }
        if (celulaViva(fila, columna + 1)) {
            cont++;
        }
        if (celulaViva(fila + 1, columna - 1)) {
            cont++;
        }
        if (celulaViva(fila + 1, columna)) {
            cont++;
        }
        if (celulaViva(fila + 1, columna + 1)) {
            cont++;
        }
        return cont;
    }

    /**
     * Se aplicara las reglas del juego para decidir si la celula vive o no si
     * cumple las siguientes condiciones:
     * <ul>
     * <li> Si una célula está viva y tiene dos o tres vecinos vivos, la célula
     * permanece viva en la siguiente generación. Los vecinos son las ocho
     * celdas que rodean inmediatamente una celda: vertical, horizontal y
     * diagonalmente.
     * <li> Si una célula viva que no tiene vecinos vivos o un solo vecino vivo
     * muere por aislamiento en la próxima generación.
     * <li> Una célula viva que tiene cuatro o más vecinos vivos muere por
     * sobrepoblación en la próxima generación.
     * <li> Una celda muerta con exactamente tres vecinos vivos da como
     * resultado un nacimiento y cobra vida en la siguiente generación. Todas
     * las demás células muertas permanecen muertas en la próxima generación.
     * </ul>
     *
     * @param fila numero de la fila donde esta la celda actual
     * @param columna numero de la columna donde esta la celda actual
     * @return el nuevo estado de la celula (vivo ó muerto)
     */
    private char aplicarReglas(int fila, int columna) {
        int cont = contarVivas(fila, columna); // Numero de celulas vivas encontradas
        if (celulaViva(fila, columna) && cont == 2 || cont == 3) {
            return '+'; // Celula viva
        } else if (!celulaViva(fila, columna) && cont == 3) {
            return '+'; // Celula viva
        }
        return '-'; // Celula muerta
    }

    /**
     * Recorre la tabla para aplicar las reglas en un auxiliar para que despues
     * haga los cambios para crear una nueva generacion en la tabla
     */
    public void recorrerTabla() {
        char[][] generacion = new char[tabla.getFilas()][tabla.getColumnas()];
        for (int i = 0; i < tabla.getFilas(); i++) {
            for (int j = 0; j < tabla.getColumnas(); j++) {
                generacion[i][j] = aplicarReglas(i, j);
            }
        }
        for (int i = 0; i < tabla.getFilas(); i++) {
            for (int j = 0; j < tabla.getColumnas(); j++) {
                tabla.setElemento(i, j, generacion[i][j]);
            }
        }
    }

    /**
     * Muestra la tabla entera celda por celda
     */
    public void imprimirTabla() {
        for (int i = 0; i < tabla.getFilas(); i++) {
            for (int j = 0; j < tabla.getColumnas(); j++) {
                System.out.printf(" |%c| ", tabla.getElemento(i, j));
            }
            System.out.println("");
        }
    }
}
