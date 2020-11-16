package Excepciones;

/**
 * Modela la excepción que se produce ante una entrada que es inválida.
 * @author Gonzalo Perez & Juan Rapino
 */
public class InvalidEntryException extends Exception {
  /**
   * Inicializa una excepción por entrada inválida describiendo su origen.
   * @param msj Mensaje que describe el origen del disparo de la excepción.
   */
  public InvalidEntryException(String msj) {
	super(msj);
  }
}