package TDAColaCP;

/**
 * Clase que respresenta una entrada que contiene un par clave-valor.
 * @author Gonzalo Perez
 *
 * @param <K> Tipo de dato de la clave de la entrada.
 * @param <V> Tipo de dato del valor de la entrada.
 */
public class Entrada<K, V> implements Entry<K, V> {
  protected K clave;
  protected V valor;
  //Constructor
  /**
   * Crea una nueva entrada con la clave y el valor pasado por parámetro. 
   * @param k Clave de la entrada.
   * @param v Valor de la entrada.
   */
  public Entrada(K k, V v) {
	clave=k;
	valor=v;
  }
  
  //Comandos
  /**
   * Setea la clave de la entrada.
   * @param k Nueva clave a setear en la entrada.
   */
  public void setKey(K k) {
	clave=k;
  }
  
  /**
   * Setea el valor de la entrada.
   * @param v Nuevo valor a setear en la entrada.
   */
  public void setValue(V v) {
	valor=v;
  }
  
  //Consultas
  @Override
  public K getKey() {
	return clave;
  }
  
  @Override
  public V getValue() {
	return valor;
  }
  
  public String toString() {
	return "["+getKey()+", "+getValue()+"]";
  }
}