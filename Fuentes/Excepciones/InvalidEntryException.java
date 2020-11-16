package Excepciones;

/**
 * Modela la excepci�n que se produce ante una entrada que es inv�lida.
 * @author Gonzalo Perez & Juan Rapino
 */
public class InvalidEntryException extends Exception {
  /**
   * Inicializa una excepci�n por entrada inv�lida describiendo su origen.
   * @param msj Mensaje que describe el origen del disparo de la excepci�n.
   */
  public InvalidEntryException(String msj) {
	super(msj);
  }
}