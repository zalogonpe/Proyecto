package TDALista;

/**
 * Clase que implementa a un nodo de lista doblemente enlazada.
 * @author Gonzalo Perez & Juan Rapino.
 *
 * @param <E> Tipo de dato del elemento asociado al nodo.
 */
public class NodoD<E> implements Position<E> {
    private NodoD<E> next,prev;
    private E item;

    /**
     * Crea un nodo con el elemento y con los nodos anterior y siguiente pasados por parámetro.
     * @param prev Nodo anterior del nodo actual.
     * @param item Elemento asociado al nodo.
     * @param next Nodo siguiente del nodo actual.
     */
    public NodoD(NodoD<E> prev, E item, NodoD<E> next) {
        this.item= item;
        this.prev= prev;
        this.next= next;
    }

    /**
     * Consulta el nodo siguiente del nodo actual.
     * @return Retorna el nodo siguiente del nodo actual.
     */
    public NodoD<E> getNext() {
        return next;
    }

    /**
     * Setea el nodo siguiente del nodo actual.
     * @param next Nodo siguiente del nodo actual.
     */
    public void setNext(NodoD<E> next) {
        this.next = next;
    }

    /**
     * Consulta el nodo anterior del nodo actual.
     * @return Retorna el nodo anterior del nodo actual.
     */
    public NodoD<E> getPrev() {
        return prev;
    }

    /**
     * Setea el nodo anterior del nodo actual.
     * @param prev Nodo anterior del nodo actual.
     */
    public void setPrev(NodoD<E> prev) {
        this.prev = prev;
    }

    /**
     * Setea el elemento al nodo
     * @param item Elemento del nodo.
     */
    public void setElement(E item) {
        this.item = item;
    }

    @Override
    public E element() {
        return item;
    }
}