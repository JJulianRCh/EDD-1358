/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.Juego;

import javax.swing.JOptionPane;

public class JuegoDeLaVida {

    public static void main(String[] args) {
        int cont = 0, decision;
        boolean game = true;
        String[] options = {"Iniciar", "Ingresar celula viva", "Remover celula", "Salir"};
        Tablero t = new Tablero();
        while (game) {
            decision = JOptionPane.showOptionDialog(null, "Menu principal", "Juego de la vida", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (decision) {
                case 0:
                    while (cont < 10) {
                        System.out.println("Generación " + (cont + 1));
                        t.imprimirTabla();
                        t.recorrerTabla();
                        System.out.println("");
                        cont++;
                    }
                    game = false;
                    break;
                case 1:
                    int f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila\n(1 a 10)"));
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna\n(1 a 10)"));
                    t.ingresarCelulaViva(f - 1, c - 1);
                    break;
                case 2:
                    f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila\n(1 a 10)"));
                    c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna\n(1 a 10)"));
                    t.removerCelula(f - 1, c - 1);
                    break;
                case 3:
                    game = false;
                    break;
                default:
                    game = false;
            }
        }
    }
}
