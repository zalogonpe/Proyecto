package Excepciones;

/**
 * Modela la excepción que se produce cuando se intenta avanzar o retroceder más allá de los límites de la lista.
 * @author Gonzalo Perez & Juan Rapino
 */
public class BoundaryViolationException extends Exception {
  /**
   * Inicializa una excepción al intentar avanzar más allá de los límites de la lista.
   * @param msj Mensaje que describe el origen del disparo de la excepción.
   */
  public BoundaryViolationException(String msj) {
	super(msj);
  }
}