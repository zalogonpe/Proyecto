package TDAColaCP;

/**
 * Modela la excepci�n que se produce ante una cola con prioridad vac�a.
 * @author Gonzalo Perez
 */
public class EmptyPriorityQueueException extends Exception {
  /**
   * Inicializa una excepci�n por cola con prioridad vac�a describiendo su origen.
   * @param msj Mensaje que describe el evento que dispar� la excepti�n.
   */
  public EmptyPriorityQueueException(String msj) {
	super(msj);
  }
}