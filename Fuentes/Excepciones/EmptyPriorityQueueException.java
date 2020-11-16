package Excepciones;

/**
 * Modela la excepción que se produce ante una cola con prioridad vacía.
 * @author Gonzalo Perez & Juan Rapino
 */
public class EmptyPriorityQueueException extends Exception {
  /**
   * Inicializa una excepción por cola con prioridad vacía describiendo su origen.
   * @param msj Mensaje que describe el origen del disparó la excepción.
   */
  public EmptyPriorityQueueException(String msj) {
	super(msj);
  }
}