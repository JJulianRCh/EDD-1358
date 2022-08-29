package mx.unam.EdD;

public class testArregloADT {

    public static void main(String[] args) {
        ArregloADT lista = new ArregloADT(5);
        Object[] valor = new Object[1];
        lista.setElemento(0, "Hola");
        lista.setElemento(3, new Persona("Julian", 20, 1.76f));
        lista.setElemento(1, 3);
        lista.setElemento(4, true);
        for (int i = 0; i < lista.getLongitud(); i++) {
            System.out.println("[" + i + "] = {" + lista.getElemento(i) + "}");
        }
        System.out.println(lista);
        lista.limpiar(valor);
        System.out.println(lista);
    }
}
