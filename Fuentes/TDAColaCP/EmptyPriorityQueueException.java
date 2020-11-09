package TDAColaCP;

/**
 * Modela la excepción que se produce ante una cola con prioridad vacía.
 * @author Gonzalo Perez
 */
public class EmptyPriorityQueueException extends Exception {
  /**
   * Inicializa una excepción por cola con prioridad vacía describiendo su origen.
   * @param msj Mensaje que describe el evento que disparó la exceptión.
   */
  public EmptyPriorityQueueException(String msj) {
	super(msj);
  }
}