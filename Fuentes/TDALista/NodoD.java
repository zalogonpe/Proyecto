package TDALista;

/**
 * Implementacion de la clase NodoD.
 * @author Gonzalo Perez & Rapino Juan.
 */

public class NodoD<E> implements Position<E>{
    private NodoD<E> next,prev;
    private E item;

    public NodoD(NodoD<E> prev, E item, NodoD<E> next) {
        this.item= item;
        this.prev= prev;
        this.next= next;
    }

    public NodoD(E item) {
        this(null, item, null);
    }

    public NodoD<E> getNext() {
        return next;
    }

    public void setNext(NodoD<E> next) {
        this.next = next;
    }

    public NodoD<E> getPrev() {
        return prev;
    }

    public void setPrev(NodoD<E> prev) {
        this.prev = prev;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    @Override
    public E element() {
        return item;
    }
}