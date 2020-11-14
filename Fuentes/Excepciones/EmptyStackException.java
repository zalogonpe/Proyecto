package Excepciones;

/**
 * Modela la excepción que se produce ante una pila vacía.
 * @author Gonzalo Perez
 */
public class EmptyStackException extends Exception {
  /**
   * Inicializa una excepción por pila vacía descrbiendo su origen.
   * @param msj Mensaje que describe el origen del disparo de la excepción.
   */
  public EmptyStackException(String msj) {
	super(msj);
  }
}