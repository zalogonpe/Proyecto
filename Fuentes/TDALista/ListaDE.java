package TDALista;
import java.util.Iterator;

/**
 * Clase que implementa una lista doblemente enlazada con celdas de encabezamiento al principio y al final.
 * @author Gonzalo Perez & Juan Rapino
 *
 * @param <E> Tipo de dato de los elementos de la lista.
 */
public class ListaDE<E> implements PositionList<E> {
    protected NodoD<E> header,trailer;
    protected int size;

    /**
     * Crea una lista doblemente enlazada inicialmente vacía.
     */
    public ListaDE() {
        header = new NodoD<E>(null, null, null);
        trailer = new NodoD<E>(null, null, null);
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Position<E> first() throws EmptyListException {
        if(size==0)
            throw new EmptyListException("Lista vacia.");

        return header.getNext();
    }

    @Override
    public Position<E> last() throws EmptyListException {
        if(size==0)
            throw new EmptyListException("Lista vacia.");

        return trailer.getPrev();
    }

    @Override
    public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        NodoD<E> nodo = checkPosition(p);
        if(nodo.getNext() == trailer)
            throw new BoundaryViolationException("Error al solicitar el siguiente de la ultima posicion de la lista.");

        return nodo.getNext();
    }

    @Override
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        NodoD<E> nodo= checkPosition(p);
        if(nodo.getPrev() == header)
            throw new BoundaryViolationException("Error al solicitar el anterior de la primera posicion de la lista.");

        return nodo.getPrev();
    }

    @Override
    public void addFirst(E element) {
        NodoD<E> nodo = new NodoD<E>(header, element, header.getNext());
        header.getNext().setPrev(nodo);
        header.setNext(nodo);
        size++;
    }

    @Override
    public void addLast(E element) {
        NodoD<E> nodo = new NodoD<E>(trailer.getPrev(), element, trailer);        
        trailer.getPrev().setNext(nodo);
        trailer.setPrev(nodo);
        size++;
    }

    @Override
    public void addAfter(Position<E> p, E element) throws InvalidPositionException {
        NodoD<E> nodo = checkPosition(p);
        NodoD<E> newNodo = new NodoD<E>(nodo, element, nodo.getNext());
        nodo.getNext().setPrev(newNodo);
        nodo.setNext(newNodo);
        size++;
    }

    @Override
    public void addBefore(Position<E> p, E element) throws InvalidPositionException {
        NodoD<E> nodo = checkPosition(p);
        NodoD<E> newNodo = new NodoD<E>(nodo.getPrev(), element, nodo);
        nodo.getPrev().setNext(newNodo);
        nodo.setPrev(newNodo);
        size++;
    }

    @Override
    public E remove(Position<E> p) throws InvalidPositionException {
        NodoD<E> nodo = checkPosition(p);
        E ret = nodo.element();
        nodo.getPrev().setNext(nodo.getNext());
        nodo.getNext().setPrev(nodo.getPrev());
        nodo.setElement(null);
        nodo.setNext(null);
        nodo.setPrev(null);
        size--;
        return ret;
    }

    @Override
    public E set(Position<E> p, E element) throws InvalidPositionException {
        NodoD<E> nodo = checkPosition(p);
        E ret = nodo.element();
        nodo.setElement(element);
        return ret;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<E>(this);
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> list= new ListaDE<Position<E>>();
        NodoD<E> pos=header.getNext();
    	while (pos!=trailer) {
    		  list.addLast(pos);
    		  pos=pos.getNext();
       }
        return list;
    }

    private NodoD<E> checkPosition(Position<E> p) throws InvalidPositionException {
        try {
        	if (size==0)
    			throw new InvalidPositionException("La lista está vacía.");
    		if (p==null || p.element()==null)
    			throw new InvalidPositionException("La posición es inválida");
    		return (NodoD<E>) p;
        } catch(ClassCastException e) {
            throw new InvalidPositionException("Posicion invalida.");
        }
    }
}