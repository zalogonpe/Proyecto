package TDALista;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que representa a un iterador de elementos para una lista.
 * @author Gonzalo Perez & Juan Rapino.
 *
 * @param <E> Tipode dato de los elementos asociados a las posiciones a iterar
 */
public class ElementIterator<E> implements Iterator<E> {
    protected PositionList<E> lista;
    protected Position<E> cursor;

    /**
     * Crea un nuevo elemento iterador con los elementos de la lista
     * @param L Lista que contiene los elementos a iterar.
     */
    public ElementIterator(PositionList<E> L) {
    	lista=L;
        try {
            if (lista.isEmpty() || lista == null)
                cursor = null;
            else
                cursor = lista.first();

        } catch (EmptyListException e) {
            cursor = null;
        }
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public E next() {
        if(cursor == null)
            throw new NoSuchElementException("No hay siguiente elemento a visitar.");

        E aRetornar = cursor.element();
        try {

        	cursor=(cursor==lista.last()) ? null : lista.next(cursor);

        }catch(EmptyListException | InvalidPositionException | BoundaryViolationException e) {
            e.printStackTrace();
        }
        return aRetornar;
    }
}
