package Excepciones;

/**
 * Modela la excepci�n que se produce ante una clave inv�lida.
 * @author Gonzalo Perez & Juan Rapino
 */
public class InvalidKeyException extends Exception {
  /**
   * Inicializa la excepci�n que se produce ante una clave inv�lida describiendo su origen.
   * @param msj Mensaje que describe el evento que dispar� la excepci�n.
   */
  public InvalidKeyException(String msj) {
	super(msj);
  }
}