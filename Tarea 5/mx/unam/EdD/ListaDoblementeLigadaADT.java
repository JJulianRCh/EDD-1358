/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

public class ListaDoblementeLigadaADT<T> {

    private int tamaño;
    private NodoDoble<T> head;

    /**
     * Constructor. establece la lista vacia y con un tamaño de 0
     */
    public ListaDoblementeLigadaADT() {
    }

    /**
     * Revisar si la lista se encuentra vacia
     *
     * @return si la lista esta vacia
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Metodo getter. Devuelve el tamaño actual de la lista
     *
     * @return tamaño actual
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Agrega un valor al final de la lista a traves de un nodo doble, el ultimo
     * valor toma como nodo anterior el penultimo elemento de la lista
     * <p>
     * En caso de que la lista este vacia, el valor dado sera el primer elemento
     *
     * @param valor elemento de tipo generico que se guardara al final de la
     * lista
     */
    public void agregarAlFinal(T valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (estaVacia()) {
            head = nuevo;
        } else {
            NodoDoble aux = head;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
        }
        tamaño++;
    }

    /**
     * Se agrega el valor dado al principio de la lista a traves de un nodo
     * doble, es decir que pasa a ser el primer elemento de la lista y moviendo
     * de lugar los demas elementos despues de este
     * <p>
     * En caso de que la lista este vacia, el valor dado sera el primer elemento
     *
     * @param valor elemento de tipo generico que se guardara al inicio de la
     * lista
     */
    public void agregarAlInicio(T valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (estaVacia()) {
            head = nuevo;
        } else {
            nuevo.setSiguiente(head);
            head.setAnterior(nuevo);
            head = nuevo;
        }
        tamaño++;
    }

    /**
     * Se agrega el valor despues de un elemento dado para buscar usando un
     * ciclo, ya encontrado se posicionara el valor entre el nodo dereferencia y
     * el nodo siguiente de la referencia y este ultimo tendra de nodo anterior
     * el nuevo nodo con el valor dado
     * <p>
     * En caso de que la lista este vacia, el valor dado sera el primer elemento
     *
     * @param referencia elemento a buscar para agregar el valor despues de este
     * @param valor elemento de tipo generico que se guardara despues del
     * elemento de referencia de la lista
     */
    public void agregarDespuesDe(T referencia, T valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (estaVacia()) {
            head = nuevo;
        } else {
            NodoDoble aux = head;
            while (aux != null) {
                if (aux.getData() == referencia) {
                    aux.getSiguiente().setAnterior(nuevo);
                    nuevo.setSiguiente(aux.getSiguiente());
                    nuevo.setAnterior(aux);
                    aux.setSiguiente(nuevo);
                    tamaño++;
                    break;
                }
                aux = aux.getSiguiente();
            }
        }
    }

    /**
     * Elimina el elemento de la lista en la posicion dada y el siguiente
     * elemento tome su lugar en la lista.
     * <p>
     * Si la lista esta vacia, no sucedera nada
     *
     * @param posicion en donde se encuentra el elemento a borrar
     */
    public void eliminar(int posicion) {
        if (!estaVacia()) {
            try {
                NodoDoble aux = head;
                if (posicion == 1) {
                    eliminarPrimero();
                } else {
                    for (int i = 1; i < posicion - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.getSiguiente().getSiguiente().setAnterior(aux);
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
                tamaño--;
            } catch (NullPointerException ex) {
                System.out.println("Salio del limite de la lista\n" + ex);
            }
        }
    }

    /**
     * Elimina el primer elemento de la lista y el siguiente elemento tome su
     * lugar
     * <P>
     * Si la lista esta vacia, no sucedera nada
     */
    public void eliminarPrimero() {
        if (!estaVacia()) {
            head.getSiguiente().setAnterior(null);
            head = head.getSiguiente();
            tamaño--;
        }
    }

    /**
     * Elimina el ultimo elemento de la lista
     * <p>
     * Si la lista esta vacia, no sucedera nada
     */
    public void eliminarFinal() {
        if (!estaVacia()) {
            NodoDoble aux = head;
            for (int i = 1; i < tamaño - 1; i++) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
            tamaño--;
        }
    }

    /**
     * Se da un valor para ser buscado en la lista y regresa la posicion donde
     * se encuentra, en caso de que no se encuentre se devuelve un 0
     *
     * @param valor elemento a buscar
     * @return posicion donde se encuentra el elemento en la lista
     */
    public int buscar(T valor) {
        int posicion = 0;
        NodoDoble aux = head;
        for (int i = 1; i <= tamaño; i++) {
            if (aux.getData() == valor) {
                posicion = i;
                break;
            }
            aux = aux.getSiguiente();
        }
        return posicion;
    }

    /**
     * Se actualizara un elemento de la lista por un nuevo valor dado por el
     * usuario
     * <p>
     * En caso de que la lista este vacio, el valor sera el primer elemento de
     * la lista
     *
     * @param a_buscar elemento a buscar para ser actualizado
     * @param valor nuevo valor que tomara el lugar del antiguo elemento
     */
    public void actualizar(T a_buscar, T valor) {
        if (estaVacia()) {
            head = new NodoDoble<>(valor);
        } else {
            NodoDoble aux = head;
            while (aux != null) {
                if (aux.getData() == a_buscar) {
                    aux.setData(valor);
                    break;
                }
                aux = aux.getSiguiente();
            }
        }
    }

    /**
     * Imprime todos los elementos de la lista de izquierda a derecha y despues
     * los imprime en el sentido opuesto
     */
    public void transversal() {
        NodoDoble aux = head;
        NodoDoble aux2 = aux;
        while (aux != null) {
            System.out.print(aux);
            aux2 = aux;
            aux = aux.getSiguiente();
        }
        System.out.println("");
        while (aux2 != null) {
            System.out.print(aux2);
            aux2 = aux2.getAnterior();
        }
        System.out.println("");
    }
}
