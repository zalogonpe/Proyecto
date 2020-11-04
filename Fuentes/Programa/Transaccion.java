package Programa;

public class Transaccion {
	//Atributos de instancia
	private float monto;
	
	//Constructor
	/**
	 * Crea una nueva transacción con el monto pasado por parámetro.
	 * @param m Monto de la transacción.
	 */
	public Transaccion(float m) {
		monto=m;
	}
	
	//Consultas
	/**
	 * Consulta el monto de la transacción.
	 * @return Retorna el monto de la transacción.
	 */
	public float getMonto() {
		return monto;
	}
}