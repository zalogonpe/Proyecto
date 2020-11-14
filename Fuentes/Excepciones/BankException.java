package Excepciones;

/**
 * Modela una excepción que se produce ante falta de fondos en la cuenta. 
 * @author Gonzalo Perez
 *
 */
public class BankException extends Exception {
	/**
	 * Inicializa una excepción por falta de fondos en la cuenta describiendo su origen.
	 * @param msg Mensaje que describe el origen del disparo de la excepción.
	 */
	public BankException(String msg) {
		super(msg);
	}
}