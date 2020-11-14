package Excepciones;

/**
 * Modela la excepci�n que se produce ante una posici�n que es inv�lida.
 * @author Gonzalo Perez
 */
public class InvalidPositionException extends Exception {
  /**
   * Inicializa una excepci�n por posici�n inv�lida.
   * @param msj Mensaje que describe el origen del disparo de excepci�n.
   */
  public InvalidPositionException(String msj) {
	super(msj);
  }
}