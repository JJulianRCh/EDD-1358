/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de datos 1358
 */
package mx.unam.EdD;

public class NodoDoble<T> {

    private T data; // El dato almacenado en el nodo
    private NodoDoble<T> siguiente; // El nodo siguiente
    private NodoDoble<T> anterior; // El nodo anterior

    /**
     * Constructor vacio. Todos los atributos estaran nulos
     */
    public NodoDoble() {
    }

    /**
     * Constructor. Se crea un nuevo nodo guardando un dato de tipo genero dado
     * por el usuario mientras que el nodo siguiente y el anterior estan vacios
     *
     * @param data dato que sera guardado en el nodo
     */
    public NodoDoble(T data) {
        this(data, null, null);
    }

    /**
     * Constructor. Se crea un nuevo nodo guardando un dato de tipo generico
     * dado por el usuario al igual con el nodo siguiente que guarda un dato
     * nuevo mientras que el nodo anterior esta vacio
     *
     * @param data dato que sera guardado en el nodo
     * @param siguiente el siguiente nodo que guarda un dato
     */
    public NodoDoble(T data, NodoDoble siguiente) {
        this(data, siguiente, null);
    }

    /**
     * Constructor. Se crea un nuevo nodo guardando un dato de tipo generico
     * dado por el usuario al igual con el nodo siguiente que guarda un dato
     * nuevo y el nodo anterior guardara el dato anterior del nodo actual
     *
     * @param data dato que sera guardado en el nodo
     * @param siguiente el siguiente nodo que guarda un dato
     * @param anterior el anterior nodo del actual
     */
    public NodoDoble(T data, NodoDoble siguiente, NodoDoble anterior) {
        this.data = data;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    /**
     * Metodo getter. Obtener el dato del nodo
     *
     * @return dato guardado en el nodo
     */
    public T getData() {
        return data;
    }

    /**
     * Metodo setter. Modificar el dato guardado en el nodo sin alterar el
     * siguiente o el anterior nodo
     *
     * @param data nuevo dato a guardar
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Metodo getter. Obtener el siguiente nodo del actual
     *
     * @return el siguiente nodo del actual
     */
    public NodoDoble getSiguiente() {
        return siguiente;
    }

    /**
     * Metodo setter. Modificar el nodo siguiente del actual Precaucion: Puede
     * crear haber un problema en el que el nodo siguiente del nodo siguiente se
     * pierda.
     *
     * @param siguiente el nuevo nodo que ira despues del actual
     */
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Metodo getter. Obtener el nodo anterior del actual
     *
     * @return el anterior nodo del actual
     */
    public NodoDoble getAnterior() {
        return anterior;
    }

    /**
     * Metodo setter. Modificar el nodo siguiente del actual Precaucion: Puede
     * crear haber un problema en el que el nodo siguiente del nodo siguiente se
     *
     * @param anterior el nuevo nodo que ira antes del actual
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    /**
     * Estado. muestre el estado actual del objeto nodo
     *
     * @return el dato almacenado en el nodo
     */
    @Override
    public String toString() {
        return "|" + data + "| -->";
    }
}
