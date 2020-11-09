package TDAColaCP;
import java.util.Comparator;

/**
 * Clase que brinda un m�todo para comparar dos elementos comparables.
 * @author Gonzalo Perez
 *
 * @param <E> Tipo de dato de los elementos a comparar.
 */
public class Comparador<E> implements Comparator<E> {
	@Override
	public int compare(E o1, E o2) {
		return ((Comparable<E>) o2).compareTo(o1);
	}
}