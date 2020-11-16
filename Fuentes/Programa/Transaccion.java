package Programa;

/**
 * Clase que modela una transacci�n.
 * @author Gonzalo Perez & Juan Rapino
 *
 */
public class Transaccion {
	//Atributos de instancia
	private float monto;
	private String tipo;
	
	//Constructor
	/**
	 * Crea una nueva transacci�n con el monto pasado por par�metro.
	 * @param t Tipo de la transacci�n.
	 * @param m Monto de la transacci�n.
	 */
	public Transaccion(String t,float m) {
		tipo=t;
		monto=m;
	}
	
	//Consultas
	/**
	 * Consulta el tipo de operaci�n de la transacci�n.
	 * @return Retorna el tipo de operaci�n de la transacci�n.
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Consulta el monto de la transacci�n.
	 * @return Retorna el monto de la transacci�n.
	 */
	public float getMonto() {
		return monto;
	}
}