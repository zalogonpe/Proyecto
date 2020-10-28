package TDADiccionario;

/**
 * Modela la excepción que se produce ante una entrada que es inválida.
 * @author Gonzalo Perez
 */
public class InvalidEntryException extends Exception {
  /**
   * Inicializa una excepción por entrada inválida y describe su origen.
   * @param msj Mensaje que describe el origen del disparo de la excepción.
   */
  public InvalidEntryException(String msj) {
	super(msj);
  }
}