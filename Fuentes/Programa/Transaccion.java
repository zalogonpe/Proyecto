package Programa;

/**
 * Clase que modela una transacción.
 * @author Gonzalo Perez & Juan Rapino
 *
 */
public class Transaccion {
	//Atributos de instancia
	private float monto;
	private String tipo;
	
	//Constructor
	/**
	 * Crea una nueva transacción con el monto pasado por parámetro.
	 * @param t Tipo de la transacción.
	 * @param m Monto de la transacción.
	 */
	public Transaccion(String t,float m) {
		tipo=t;
		monto=m;
	}
	
	//Consultas
	/**
	 * Consulta el tipo de operación de la transacción.
	 * @return Retorna el tipo de operación de la transacción.
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Consulta el monto de la transacción.
	 * @return Retorna el monto de la transacción.
	 */
	public float getMonto() {
		return monto;
	}
}