package Excepciones;

/**
 * Modela la excepción que se produce ante una clave inválida.
 * @author Gonzalo Perez
 */
public class InvalidKeyException extends Exception {
  /**
   * Inicializa la excepción que se produce ante una clave inválida y describe su origen.
   * @param msj Mensaje que describe el evento que disparó la excepción.
   */
  public InvalidKeyException(String msj) {
	super(msj);
  }
}