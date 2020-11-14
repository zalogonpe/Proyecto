package TDAPila;
import Excepciones.EmptyStackException;

/**
 * Clase que implementa una pila con nodos enlazados de acuerdo a la interfaz Stack.
 * @author Gonzalo Perez & Juan Rapino
 *
 * @param <E> Tipo de dato de los elementos a almacenar en la pila.
 */
public class PilaEnlazada<E> implements Stack<E>{
    protected Nodo<E> head;
    protected int size;

    /**
     * Crea una pila con nodos enlazados inicialmente vacía.
     */
    public PilaEnlazada(){
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() throws EmptyStackException {
        if(head == null)
            throw new EmptyStackException("Pila vacia");

        return head.getElemento();
    }

    @Override
    public void push(E element) {
        head = new Nodo<E>(element, head);
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(size == 0)
            throw new EmptyStackException("Pila vacia");

        E elemRetornar = head.getElemento();
        Nodo<E> aux = head;
        head = head.getSiguiente();
        aux.setElemento(null);
        aux.setSiguiente(null);
        size--;
        return elemRetornar;
    }
}