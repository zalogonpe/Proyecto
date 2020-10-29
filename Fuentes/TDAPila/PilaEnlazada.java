package TDAPila;

public class PilaEnlazada<E> implements Stack<E>{
    protected Nodo<E> head;
    protected int size;

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
        Nodo<E> aux = new Nodo<E>(element, head);
        head = aux;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(size == 0)
            throw new EmptyStackException("Pila vacia");

        E elemRetornar = head.getElemento();
        head = head.getSiguiente();
        size--;

        return elemRetornar;
    }
}