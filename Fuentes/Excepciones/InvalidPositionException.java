package Excepciones;

/**
 * Modela la excepción que se produce ante una posición que es inválida.
 * @author Gonzalo Perez
 */
public class InvalidPositionException extends Exception {
  /**
   * Inicializa una excepción por posición inválida.
   * @param msj Mensaje que describe el origen del disparo de excepción.
   */
  public InvalidPositionException(String msj) {
	super(msj);
  }
}