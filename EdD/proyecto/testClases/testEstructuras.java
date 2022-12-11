/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package EdD.proyecto.testClases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class testEstructuras {

    public static void main(String[] args) {
        // Clase ArrayList
        // Consta con 3 contructores
        ArrayList<Integer> al = new ArrayList<>(); // ArrayList vacio
        // ... new ArrayList<>(al); Dandole una coleccion ya existente
        // ... new ArrayList<>(4); Dandole una capacidad establecida
        al.add(20); // El metodo sencillamente agrega elementos al ArrayList
        al.add(1, 12); // Esta sobrecarga ingresa un valor en un espacio indicado por el indice dado
        System.out.println(al.isEmpty()); // Regresa un booleano de si el arreglo esta vacio o no
        al.add(2, 12);
        System.out.println(al.get(1)); // El metodo get simplemente regresa un valor que se encuentra en el indice
        al.remove(2); //Remueve el valor en el indice indicado o a traves del objeto guardado
        al.set(1, 7); // Modifica un elemento del arreglo en la ubicacion indicada
        System.out.println(al.size()); // Size devuelve el tamaño del arreglo
        System.out.println(al);

        // Clase LinkedList
        // Consta de solo 2 constructores
        LinkedList<String> ll = new LinkedList<>(); // LinkedList vacia
        // ... new LinkedList<>(ll); // Iniciar ya con una lista
        System.out.println(ll.isEmpty()); // Esta vacio?
        ll.addFirst("Programar"); // Agrega un elemento a la cabezera de lista
        ll.addLast("LinkedList"); // Agrega un elemento al final de la lista
        ll.addFirst("Java");
        ll.addLast("Estructuras");
        ll.addLast("ABCD");
        ll.removeLast(); // Remueve el ultimo nodo del LinkedList
        ll.removeFirst(); // Remueve el primer nodo del LinkedList
        System.out.println(ll.getFirst()); // Devuelve el primer elemento
        System.out.println(ll.getLast()); // Devuelve el ultimo valor
        System.out.println(ll);
        System.out.println(ll.size()); // Tamaño
        
        // Clase Stack
        //Solo contiene un constructor vacio
        Stack<Integer> pila = new Stack<>(); // pila vacia
        pila.push(1); //Agrega un elemento a la pila (encima de otro elemento)
        System.out.println(pila.empty()); // Esta vacio?
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        System.out.println(pila.peek()); // Devuelve el ultimo elemento sin sacarlo de la pila
        pila.pop(); // Remueve el ultimo elemento ingresado
        System.out.println(pila);
        System.out.println(pila.size()); // Tamaño
    }
}
