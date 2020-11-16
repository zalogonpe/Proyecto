package Excepciones;

/**
 * Modela la excepci�n que se produce ante una cola con prioridad vac�a.
 * @author Gonzalo Perez & Juan Rapino
 */
public class EmptyPriorityQueueException extends Exception {
  /**
   * Inicializa una excepci�n por cola con prioridad vac�a describiendo su origen.
   * @param msj Mensaje que describe el origen del dispar� la excepci�n.
   */
  public EmptyPriorityQueueException(String msj) {
	super(msj);
  }
}