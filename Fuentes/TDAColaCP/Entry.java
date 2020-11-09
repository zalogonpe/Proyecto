package TDAColaCP;

/**
 * Interafaz Entry que brinda los métodos que puede realizar una entrada.
 * @author Gonzalo  Perez
 *
 * @param <K> Tipo de dato de la clave de la entrada.
 * @param <V> Tipo de dato del valor de la entrada.
 */
public interface Entry<K, V> {
  /**
   * Consulta la clave de la entrada.
   * @return Retorna la clave de la entrada.
   */
  public K getKey();
  
  /**
   * Consulta el valor de la entrada.
   * @return Retorna el valor de la entrada.
   */
  public V getValue();
}