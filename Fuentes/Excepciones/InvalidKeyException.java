package Excepciones;

/**
 * Modela la excepci�n que se produce ante una clave inv�lida.
 * @author Gonzalo Perez
 */
public class InvalidKeyException extends Exception {
  /**
   * Inicializa la excepci�n que se produce ante una clave inv�lida y describe su origen.
   * @param msj Mensaje que describe el evento que dispar� la excepci�n.
   */
  public InvalidKeyException(String msj) {
	super(msj);
  }
}