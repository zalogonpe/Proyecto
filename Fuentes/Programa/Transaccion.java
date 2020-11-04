package Programa;

public class Transaccion {
	//Atributos de instancia
	private float monto;
	
	//Constructor
	/**
	 * Crea una nueva transacci�n con el monto pasado por par�metro.
	 * @param m Monto de la transacci�n.
	 */
	public Transaccion(float m) {
		monto=m;
	}
	
	//Consultas
	/**
	 * Consulta el monto de la transacci�n.
	 * @return Retorna el monto de la transacci�n.
	 */
	public float getMonto() {
		return monto;
	}
}