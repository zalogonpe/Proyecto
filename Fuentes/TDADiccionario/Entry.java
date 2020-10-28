package TDADiccionario;

/**
 * Interfaz Entry. Brinda los métodos que puede realizar una entrada.
 * @author Gonzalo Perez
 *
 * @param <K> Tipo de dato de la clave de la entrada.
 * @param <V> Tipo de dato del valor de la entrada.
 */
public interface Entry<K, V> {
  /**
   * Consulta la clave almacenada en la entrada.
   * @return Retorna la clave de la entrada.
   */
  public K getKey();
  /**
   * Consulta el valor almacenado en la entrada.
   * @return Retorna el valor de la entrada.
   */
  public V getValue();
}