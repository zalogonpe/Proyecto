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
	private String descripcion;
	
	//Constructor
	/**
	 * Crea una nueva transacci�n con el monto pasado por par�metro.
	 * @param t Tipo de la transacci�n.
	 * @param m Monto de la transacci�n.
	 * @param desc Descripci�n de la transacci�n.
	 */
	public Transaccion(float m, String t, String desc) {
		monto=m;
		tipo=t;
		descripcion=desc;
	}
	
	//Consultas
	/**
	 * Consulta el monto de la transacci�n.
	 * @return Retorna el monto de la transacci�n.
	 */
	public float getMonto() {
		return monto;
	}
	
	/**
	 * Consulta el tipo de operaci�n de la transacci�n.
	 * @return Retorna el tipo de operaci�n de la transacci�n.
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Consulta la descripci�n de la transacci�n.
	 * @return Retorna la descripci�n de la transacci�n.
	 */
	public String getDescripcion() {
		return descripcion;
	}
}