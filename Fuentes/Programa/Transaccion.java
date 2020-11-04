package Programa;

public class Transaccion {
	//Atributos de instancia
	public float monto;
	
	//Constructor
	/**
	 * Crea una nueva transacción.
	 * @param m Monto de la transacción.
	 */
	public Transaccion(float m) {
		monto=m;
	}
	
	//Consultas
	/**
	 * consulta el monto de la transacción.
	 * @return Monto de la transacción.
	 */
	public float getMonto() {
		return monto;
	}
}