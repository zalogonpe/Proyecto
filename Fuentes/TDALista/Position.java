package TDALista;

/**
 * Interface Position.
 * Representa una posición de lista.
 * @author Gonzalo Perez & Juan Rapino
 *
 * @param <E> Tipo de dato del elemento asociado a la posición.
 */
public interface Position<E> {
	/**
	 * Consulta el elemento asociado a la posición y lo retorna.
	 * @return Retorna el elemento asociado a la posición. 
	 */
    public E element();
}
