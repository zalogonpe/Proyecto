package Excepciones;

/**
 * Modela una excepci�n que se produce ante falta de fondos en la cuenta. 
 * @author Gonzalo Perez
 *
 */
public class BankException extends Exception {
	/**
	 * Inicializa una excepci�n por falta de fondos en la cuenta describiendo su origen.
	 * @param msg Mensaje que describe el origen del disparo de la excepci�n.
	 */
	public BankException(String msg) {
		super(msg);
	}
}