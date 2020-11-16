package TDAColaCP;
import java.util.Comparator;

/**
 * Clase que brinda un método para comparar dos elementos comparables.
 * @author Gonzalo Perez
 *
 * @param <E> Tipo de dato de los elementos a comparar.
 */
public class Comparador<E> implements Comparator<E> {
	/**
	 * Compara a los dos elementos pasados por parámetro.
	 * @param o1 Primer elemento a comparar.
	 * @param o2 Segundo elemento a comparar.
	 * @return Retorna 0 si los elementos son iguales, 
	 * 			un número positivo si el segundo elemento es mayor que el primero o 
	 * 			un número negativo si el primer elemento es mayor que el segundo.
	 */
	public int compare(E o1, E o2) {
		return ((Comparable<E>) o2).compareTo(o1);
	}
}