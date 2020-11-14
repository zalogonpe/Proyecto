package Excepciones;

/**
 * Modela la excepci�n que se produce cuando se intenta avanzar o retroceder m�s all� de los l�mites de la lista.
 * @author Gonzalo Perez
 */
public class BoundaryViolationException extends Exception {
  /**
   * Inicializa una excepci�n al intentar avanzar m�s all� de los l�mites de la lista.
   * @param msj Mensaje que describe el origen de la excepci�n.
   */
  public BoundaryViolationException(String msj) {
	super(msj);
  }
}