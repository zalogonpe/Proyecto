package TDADeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import TDALista.BoundaryViolationException;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.ListaDE;
import TDALista.Position;
import TDALista.PositionList;

public class Deque<E> implements java.util.Deque<E> {
	//Atributos de instancia
	private PositionList<E> lista;
	
	//Constructor
	public Deque() {
		lista=new ListaDE<E>();
	}
	
	//Comandos
	@Override
	public void addFirst(E elem) {
		if (elem!=null)
			lista.addFirst(elem);
	}
	
	@Override
	public void addLast(E elem) {
		if (elem!=null)
			lista.addLast(elem);
	}
	
	@Override
	public void push(E elem) {
		if (elem!=null)
			lista.addFirst(elem);
	}
	
	@Override
	public void clear() {
		try {

			Position<E> pos, posAux;
			pos=(!lista.isEmpty()) ? lista.first() : null;


			while (pos!=null) {
				posAux=pos;
				pos=(pos!=lista.last()) ? lista.next(pos) : null;
				lista.remove(posAux);
			}

		}
		catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			e.printStackTrace();
		}
	}
	
	//Consultas
	@Override
	public boolean add(E elem) {
		boolean inserto=false;

		if (elem!=null) {
			lista.addLast(elem);
			inserto=true;
		}

		return inserto;
	}

	//------------------------------------------------------------------------------------//
	/*	@Override
	public boolean add(E elem) throws IllegalStateException{
		boolean insertado = false;

		if(elem != null)
			throw new IllegalStateException("El elemento pasado por parametro es un null");

		lista.addLast(elem);
		insertado = true;

		return insertado;
	}
	*/
	//-------------------------------------------------------------------------------------//
	
	@Override
	public boolean contains(Object elem) {
		boolean contiene=false;
		try {
			Position<E> pos;
			pos=(!lista.isEmpty()) ? lista.first() : null;
			while (pos!=null && !contiene) {
				if (pos.element().equals(elem))
					contiene=true;
				else pos=(pos!=lista.last()) ? lista.next(pos) : null;
			}
		}
		catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			e.printStackTrace();
		}
		return contiene;
	}

	@Override
	public E element() throws NoSuchElementException {
		E elemento;

		try {

			if (!lista.isEmpty())
				elemento=lista.first().element();
			else throw new NoSuchElementException("La estructura está vacía.");
		}

		catch (EmptyListException e) {
			throw new NoSuchElementException("La estructura está vacía.");
		}

		return elemento;
	}
	
	@Override
	public E getFirst() throws NoSuchElementException {
		E elemento;

		try {

			if (!lista.isEmpty())
				elemento=lista.first().element();
			else throw new NoSuchElementException("La estructura está vacía.");

		}
		catch (EmptyListException e) {
			throw new NoSuchElementException("La estructura está vacía.");
		}

		return elemento;
	}
	
	@Override
	public E getLast() throws NoSuchElementException {
		E elemento;

		try {

			if (!lista.isEmpty())
				elemento=lista.last().element();
			else throw new NoSuchElementException("La estructura está vacía.");

		}
		catch (EmptyListException e) {
			throw new NoSuchElementException("La estructura está vacía.");
		}

		return elemento;
	}
	
	@Override
	public boolean offer(E elem) {
		boolean inserto=false;

		if (elem!=null) {
			lista.addLast(elem);
			inserto=true;
		}

		return inserto;
	}
	
	@Override
	public boolean offerFirst(E elem) {
		boolean inserto=false;

		if (elem!=null) {
			lista.addFirst(elem);
			inserto=true;
		}

		return inserto;
	}
	
	@Override
	public boolean offerLast(E elem) {
		boolean inserto=false;

		if (elem!=null) {
			lista.addLast(elem);
			inserto=true;
		}

		return inserto;
	}
	
	@Override
	public E peek() {
		E elemEliminado=null;

		try {

			if (!lista.isEmpty())
				elemEliminado=lista.remove(lista.first());

		}
		catch (InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}

		return elemEliminado;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public E peekFirst() {
		E elemento=null;
		try {
			if (!lista.isEmpty())
				elemento=lista.first().element();
		}
		catch (EmptyListException e) {
			e.printStackTrace();
		}
		return elemento;
	}
	
	@Override
	public E peekLast() {
		E elemento=null;
		try {
			if (!lista.isEmpty())
				elemento=lista.last().element();
		}
		catch (EmptyListException e) {
			e.printStackTrace();
		}
		return elemento;
	}
	
	@Override
	public E poll() {
		E eliminado=null;
		try {
			if (!lista.isEmpty())
				eliminado=lista.remove(lista.first());
		}
		catch (InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
		return eliminado;
	}
	
	@Override
	public E pollFirst() {
		E eliminado=null;
		try {
			if (!lista.isEmpty())
				eliminado=lista.remove(lista.first());
		}
		catch (InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
		return eliminado;
	}
	
	@Override
	public E pollLast() {
		E eliminado=null;
		try {
			if (!lista.isEmpty())
				eliminado=lista.remove(lista.last());
		}
		catch (InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
		return eliminado;
	}
	
	public E pop() throws NoSuchElementException {
		E elem=null;

		try {

			if (!lista.isEmpty())
				elem=lista.remove(lista.first());
			else throw new NoSuchElementException("La estructura está vacía.");

		}
		catch (EmptyListException e) {
			throw new NoSuchElementException("La estructura está vacía.");
		}
		catch (InvalidPositionException e) {
			e.printStackTrace();
		}
		
		return elem;
	}
	
	@Override
	public E remove() throws NoSuchElementException {
		E eliminado=null;

		try {

			if (!lista.isEmpty())
				eliminado=lista.remove(lista.first());
			else throw new NoSuchElementException("La estructura está vacía.");

		}
		catch (EmptyListException | InvalidPositionException e) {
			e.printStackTrace();
			throw new NoSuchElementException("La estructura está vacía.");
		}

		return eliminado;
	}
	
	@Override
	public boolean remove(Object elem) {
		boolean elimino=false;

		try {

			Position<E> pos;
			pos=(!lista.isEmpty()) ? lista.first() : null;

			while (pos!=null && !elimino) {

				if (pos.element().equals(elem)) {
					lista.remove(pos);
					elimino=true;
				}
				else pos=(pos!=lista.last()) ? lista.next(pos) : null;
			}
		}

		catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			e.printStackTrace();
		}
		return elimino;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		E eliminado=null;
		try {
			if (!lista.isEmpty())
				eliminado=lista.remove(lista.first());
			else throw new NoSuchElementException("La estructura está vacía.");
		}
		catch (EmptyListException e) {
			throw new NoSuchElementException("La estructura está vacía.");
		}
		catch (InvalidPositionException e) {
			e.printStackTrace();
		}
		return eliminado;
	}
	
	@Override
	public boolean removeFirstOccurrence(Object elem) {
		boolean elimino=false;

		try {

			Position<E> pos=null;

			if (elem!=null) {
				pos=(!lista.isEmpty()) ? lista.first() : null;

				while (pos!=null && !elimino) {
					if (pos.element().equals(elem)) {
						lista.remove(pos);
						elimino=true;
					}
					else pos=(pos!=lista.last()) ? lista.next(pos) : null;
				}
			}
		}

		catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			e.printStackTrace();
		}

		return elimino;
	}
	
	@Override
	public E removeLast() throws NoSuchElementException {
		E eliminado=null;
		try {
			if (!lista.isEmpty())
				eliminado=lista.remove(lista.last());
			else throw new NoSuchElementException("La estructura está vacía.");
		}
		catch (EmptyListException e) {
			throw new NoSuchElementException("La estructura está vacía.");
		}
		catch (InvalidPositionException e) {
			e.printStackTrace();
		}
		return eliminado;
	}
	
	@Override
	public boolean removeLastOccurrence(Object elem) {
		boolean elimino=false;
		try {
			Position<E> pos=null;
			if (elem!=null) {
				pos=(!lista.isEmpty()) ? lista.last() : null;
				while (pos!=null && !elimino) {
					if (pos.element().equals(elem)) {
						lista.remove(pos);
						elimino=true;
					}
					else pos=(pos!=lista.first()) ? lista.prev(pos) : null;
				}
			}
		}
		catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			e.printStackTrace();
		}
		return elimino;
	}
	
	@Override
	public Object[] toArray() {
		Object[] arreglo=new Object[lista.size()];
		int i=0;
		for (E elem:lista) {
			arreglo[i]=elem;
			i++;
		}
		return arreglo;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public int size() {
		return lista.size();
	}
	
	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	@Override
	public Iterator<E> iterator() {
		return lista.iterator();
	}
	
	@Override
	public Iterator<E> descendingIterator() {
		PositionList<E> listaDescendente=new ListaDE<E>();
		for (E elem:lista)
			listaDescendente.addFirst(elem);
		return listaDescendente.iterator();
	}
}