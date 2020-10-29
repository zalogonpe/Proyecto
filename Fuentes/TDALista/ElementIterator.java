package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E> {
    protected PositionList<E> lista;
    protected Position<E> cursor;

    public ElementIterator(PositionList<E> L) {
        try {

            lista = L;
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
            throw new NoSuchElementException("No hay siguiente");

        E aRetornar = cursor.element();

        try {

            if(cursor == lista.last())
                cursor = null;
            else
                cursor = lista.next(cursor);


        }catch(EmptyListException | InvalidPositionException | BoundaryViolationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

        return aRetornar;
    }
}
