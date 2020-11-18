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
	private String descripcion;
	
	//Constructor
	/**
	 * Crea una nueva transacción con el monto pasado por parámetro.
	 * @param t Tipo de la transacción.
	 * @param m Monto de la transacción.
	 * @param desc Descripción de la transacción.
	 */
	public Transaccion(float m, String t, String desc) {
		monto=m;
		tipo=t;
		descripcion=desc;
	}
	
	//Consultas
	/**
	 * Consulta el monto de la transacción.
	 * @return Retorna el monto de la transacción.
	 */
	public float getMonto() {
		return monto;
	}
	
	/**
	 * Consulta el tipo de operación de la transacción.
	 * @return Retorna el tipo de operación de la transacción.
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Consulta la descripción de la transacción.
	 * @return Retorna la descripción de la transacción.
	 */
	public String getDescripcion() {
		return descripcion;
	}
}