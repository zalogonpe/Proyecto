package TDALista;

/**
 * Modela la excepción que se produce ante una lista vacía.
 * @author Gonzalo Perez
 */
public class EmptyListException extends Exception {
  /**
   * Inicializa una excepción por lista vacía.
   * @param msj Mensaje que describe el origen del disparo de la excepción.
   */
  public EmptyListException(String msj) {
	super(msj);
  }
}