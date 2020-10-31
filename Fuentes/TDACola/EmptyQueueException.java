package TDACola;

/**
 * Modela la excepci�n que se produce ante una cola vac�a.
 * @author Gonzalo Perez & Jaun Rapino
 */
public class EmptyQueueException extends Exception {
  /**
   * Inicializa una excepci�n por cola vac�a describiendo su origen.
   * @param msj Mensaje que describe el origen del disparo la excepci�n.
   */
  public EmptyQueueException(String msj) {
	super(msj);
  }
}