package TDALista;

/**
 * Interface Position.
 * Representa una posici�n de lista.
 * @author Gonzalo Perez & Juan Rapino
 *
 * @param <E> Tipo de dato del elemento asociado a la posici�n.
 */
public interface Position<E> {
	/**
	 * Consulta el elemento asociado a la posici�n y lo retorna.
	 * @return Retorna el elemento asociado a la posici�n. 
	 */
    public E element();
}
