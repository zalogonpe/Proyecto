package TDACola;

/**
 * Modela la excepción que se produce ante una cola vacía.
 * @author Gonzalo Perez & Jaun Rapino
 */
public class EmptyQueueException extends Exception {
  /**
   * Inicializa una excepción por cola vacía describiendo su origen.
   * @param msj Mensaje que describe el origen del disparo la excepción.
   */
  public EmptyQueueException(String msj) {
	super(msj);
  }
}