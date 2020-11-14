package TDADeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import Excepciones.BoundaryViolationException;
import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;
import TDALista.ListaDE;
import TDALista.Position;
import TDALista.PositionList;

/**
 * Clase que implementa un Deque utilizando una lista doblemente enlazada.
 * @author Gonzalo Perez & Juan Rapino
 *
 * @param <E> Tipo de dato de los elementos del Deque.
 */
public class Deque<E> implements java.util.Deque<E> {
	//Atributos de instancia
	private PositionList<E> lista;
	
	//Constructor
	/**
	 * Crea un Deque implementado con una lista inicialmente vacío.
	 */
	public Deque() {
		lista=new ListaDE<E>();
	}
	
	//Comandos
	/**
	 * Inserta un elemento al principio del Deque.
	 */
	public void addFirst(E elem) {
		if (elem!=null)
			lista.addFirst(elem);
	}
	
	/**
	 * Inserta un elemento al final del Deque.
	 */
	public void addLast(E elem) {
		if (elem!=null)
			lista.addLast(elem);
	}
	
	/**
	 * Inserta un elemento al principio del Deque.
	 */
	public void push(E elem) {
		if (elem!=null)
			lista.addFirst(elem);
	}
	
	/**
	 * Remueve todos los elementos almacenados en el Deque.
	 */
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
	/**
	 * Inserta un elemento al final del Deque.
	 * @return Verdadero si la inserción se pudo realizar, falso en caso contrario. 
	 */
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
	public boolean add(E elem) throws NullPointerException {
		boolean insertado = false;

		if(elem != null)
			throw new NullPointerExxeption("El elemento pasado por parametro es un null");

		lista.addLast(elem);
		insertado = true;

		return insertado;
	}
	*/
	//-------------------------------------------------------------------------------------//
	
	/**
	 * Consulta si un elemento pertenece a los elementos almacenados en el Deque.
	 * @return Retorna verdadero si el elemento pertenece al Deque, falso en caso contrario.
	 */
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
	
	/**
	 * Consulta y retorna, sin eliminar, el elemento almacenado en el principio del Deque.
	 * @return Retorna el elemento almacenado al principio del Deque.
	 * @throws NoSuchElementException Si el Deque está vacío.
	 */
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
	
	/**
	 * Consulta y retorna, sin eliminar, el primer elemento del Deque.
	 * @return Retorna el elemento almacenado al principio del Deque.
	 * @throws NoSuchElementException Si el Deque está vacío.
	 */
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
	
	/**
	 * Consulta y retorna, sin eliminar, el último elemento del Deque.
	 * @return Retorna el elemento almacenado al final del Deque.
	 * @throws NoSuchElementException Si el Deque está vacío.
	 */
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
	
	/**
	 * Inserto un elemento al final del Deque.
	 * @return Verdadero si la inserción se pudo realizar, falso en caso contrario.
	 */
	public boolean offer(E elem) {
		boolean inserto=false;
		if (elem!=null) {
			lista.addLast(elem);
			inserto=true;
		}
		return inserto;
	}
	
	/**
	 * Inserta un elemento al principio del Deque.
	 * @return Verdadero si la inserción se pudo realizar, falso en caso contrario.
	 */
	public boolean offerFirst(E elem) {
		boolean inserto=false;
		if (elem!=null) {
			lista.addFirst(elem);
			inserto=true;
		}
		return inserto;
	}
	
	/**
	 * Inserta un elemento al final del Deque.
	 * @return Verdadero si la inserción se pudo realizar, falso en caso contrario.
	 */
	public boolean offerLast(E elem) {
		boolean inserto=false;
		if (elem!=null) {
			lista.addLast(elem);
			inserto=true;
		}
		return inserto;
	}
	
	/**
	 * Consulta y retorna, sin eliminar, el primer elemento del Deque.
	 * @return Retorna el primer elemento almacenado o nulo si el Deque está vacío.
	 */
	public E peek() {
		E elem=null;
		try {
		if (!lista.isEmpty())
			elem=lista.first().element();
		}
		catch (EmptyListException e) {
			e.printStackTrace();
		}
		return elem;
	}
	
	/**
	 * Consulta y retorna, sin eliminar, el primer elemento del Deque.
	 * @return Retorna el primer elemento almacenado o nulo si el Deque está vacío.
	 */
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
	
	/**
	 * Consulta y retorna, sin eliminar, el último elemento del Deque.
	 * @return Retorna el último elemento almacenado o nulo si el Deque está vacío.
	 */
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
	
	/**
	 * Remueve el elemento al principio del Deque retornandolo.
	 * @return Retorna el elemento eliminado o nulo si el Deque está vacío.
	 */
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
	
	/**
	 * Remueve el primer elemento del Deque retornandolo.
	 * @return Retorna el elemento eliminado o nulo si el Deque está vacío.
	 */
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
	
	/**
	 * Remueve el último elemento del Deque retornandolo.
	 * @return Retorna el elemento eliminado o nulo si el Deque está vacío.
	 */
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
	
	/**
	 * Remueve el primer elemento del Deque retornandolo.
	 * @return Retorna el elemento eliminado.
	 * @throws Si el Deque está vacío.
	 */
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
	
	/**
	 * Remueve el elemento al principio del Deque.
	 * @return Retorna el elemento eliminado.
	 * @throws Si el Deque está vacío.
	 */
	public E remove() throws NoSuchElementException {
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
	
	/**
	 * Remueve la primera aparición de un elemento.
	 * @param elem Elemento a remover del Deque.
	 * @return Verdadero si el elemento pertenece al Deque y es eliminado, falso en caso contrario. 
	 */
	public boolean remove(Object elem) {
		boolean elimino=false;
		Position<E> pos=null;
		try {
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
	
	/**
	 * Remueve el primer elemento del Deque retornandolo.
	 * @return Retorna el elemento eliminado.
	 * @throws NoSuchElementException Si el Deque está vacío.
	 */
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
	
	/**
	 * Remueve la primera aparición de un elemento del Deque y lo retorna.
	 * @param elem Elemento a remover su primer aparción.
	 * @return Verdadero si elemento aparece y fue eliminado del Deque, falso en caso contrario.
	 */
	public boolean removeFirstOccurrence(Object elem) {
		boolean elimino=false;
		Position<E> pos=null;
		try {
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
	
	/**
	 * Remueve el último elemento del Deque retornandolo.
	 * @return Retorna el elemento eliminado.
	 * @throws Si el Deque está vacío.
	 */
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
	
	/**
	 * Remueve la última aparición de un elemento del Deque y lo retorna.
	 * @param elem Elemento a remover su última aparición.
	 * @return Verdadero si elemento aparece y fue eliminado del Deque, falso en caso contrario.
	 */
	public boolean removeLastOccurrence(Object elem) {
		boolean elimino=false;
		Position<E> pos=null;
		try {
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
	
	/**
	 * Consulta la cantidad de elementos almacenados en el Deque.
	 * @return Retorna la cantidad de elementos almacenados.
	 */
	public int size() {
		return lista.size();
	}
	
	/**
	 * Consulta si el Deque está vacío.
	 * @return Retorna verdadero si el Deque está vacío, falso en caso contrario. 
	 */
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	/**
	 * Devuelve un iterador de todos los elementos almacenados en el Deque.
	 * @return Retorna un iterador de todos los elementos.
	 */
	public Iterator<E> iterator() {
		return lista.iterator();
	}
	
	/**
	 * Devuelve un iterador descendente de todos los elementos almacenados en el Deque.
	 * @return Retotna un iterador descendente de los elementos.
	 */
	public Iterator<E> descendingIterator() {
		PositionList<E> listaDescendente=new ListaDE<E>();
		for (E elem:lista)
			listaDescendente.addFirst(elem);
		return listaDescendente.iterator();
	}
	
	/**
	 * Consulta todos los elementos almacenados en el Deque y los inserta en un arreglo.
	 * @return Retorna un arreglo que contiene todos los elementos almacenados en el Deque.
	 */
	public Object[] toArray() {
		E[] elementos=(E[]) new Object[lista.size()];
		Position<E> pos=null;
		try {
			pos=(!lista.isEmpty()) ? lista.first() : null;
			int i=0;
			while (pos!=null) {
				elementos[i]=pos.element();
				pos=(pos!=lista.last()) ? lista.next(pos) : null;
				i++;
			}
		}
		catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			e.printStackTrace();
		}
		return elementos;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
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
	public <T> T[] toArray(T[] a) {
		return null;
	}
}