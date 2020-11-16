package Excepciones;

/**
 * Modela la excepción que se produce ante una clave inválida.
 * @author Gonzalo Perez & Juan Rapino
 */
public class InvalidKeyException extends Exception {
  /**
   * Inicializa la excepción que se produce ante una clave inválida describiendo su origen.
   * @param msj Mensaje que describe el evento que disparó la excepción.
   */
  public InvalidKeyException(String msj) {
	super(msj);
  }
}