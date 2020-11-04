package Programa;

public class Transaccion {
	//Atributos de instancia
	public float monto;
	
	//Constructor
	/**
	 * Crea una nueva transacci�n.
	 * @param m Monto de la transacci�n.
	 */
	public Transaccion(float m) {
		monto=m;
	}
	
	//Consultas
	/**
	 * consulta el monto de la transacci�n.
	 * @return Monto de la transacci�n.
	 */
	public float getMonto() {
		return monto;
	}
}