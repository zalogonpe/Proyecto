package TDADiccionario;
import TDALista.*;

/**
 * Clase que implementa un diccionario utilizando una tabla hash abierta.
 * @author Gonzalo Perez
 *
 * @param <K> Tipo de dato de las claves del diccionario.
 * @param <V> Tipo de dato de los valores del diccionario.
 */
public class DiccionarioConHashAbierto<K, V> implements Dictionary<K, V> {
  //Atributos de instancia
  protected PositionList<Entrada<K, V>>[] arreglo;
  protected int cantEntradas;
  private final float fc=0.9f;
		  
  //Constructor
  /**
   * Crea un diccionario vacío con capacidad inicial para 11 elementos.
   */
  public DiccionarioConHashAbierto() {
	arreglo=(PositionList<Entrada<K, V>>[]) new PositionList[11];
	for (int i=0; i<11; i++)
		arreglo[i]=new ListaDE<Entrada<K, V>>();
	cantEntradas=0;
  }
  
  //Consultas
  /**
   * Computa el valor hash de la clave pasada por parámetro.
   * @param clave Clave a computar su valor hash.
   * @return Retorna el valor hash de la clave pasada por parámetro.
   */
  protected int hash(K clave) {
	return Math.abs(clave.hashCode()) % arreglo.length;
  }
  
  @Override
  public Entry<K,V> find(K clave) throws InvalidKeyException {
	if (clave==null)
	   throw new InvalidKeyException("La clave es inválida.");
	int bucket=hash(clave);
	Entry<K, V> entrada=null;
	Position<Entrada<K, V>> pos;
	try {
		pos=(!arreglo[bucket].isEmpty()) ? arreglo[bucket].first() : null;
		while (pos!=null && entrada==null) {
			if (pos.element().getKey().equals(clave)) {
				entrada=pos.element();
			}
			else pos=(pos!=arreglo[bucket].last()) ? arreglo[bucket].next(pos) : null;
		}
	}
	catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
		e.printStackTrace();
	}
	return entrada;
  }
  
  @Override
  public Iterable<Entry<K,V>> findAll(K clave) throws InvalidKeyException {
    if (clave==null)
	   throw new InvalidKeyException("La clave es inválida.");
    int bucket=hash(clave);
	PositionList<Entry<K, V>> entradas=new ListaDE<Entry<K, V>>();
	for (Entry<K, V> entrada:arreglo[bucket]) {
		if (entrada.getKey().equals(clave))
			entradas.addLast(entrada);
	}
	return entradas;
  }
  
  @Override
  public Entry<K, V> insert(K clave, V valor) throws InvalidKeyException {
	if (clave==null)
	   throw new InvalidKeyException("La clave es inválida.");
	if (cantEntradas/arreglo.length>=fc)
		redimensionar();
	int bucket=hash(clave);
	Entrada<K, V> nuevaEntrada=new Entrada<K, V>(clave, valor);
	arreglo[bucket].addLast(nuevaEntrada);
	cantEntradas++;
	return nuevaEntrada;
  }
  
  /**
   * Redimensiona el tamaño del diccionario extendiendolo cuando se supera el valor establecido por el factor de carga.
   */
  private void redimensionar() {
	try {
		int nuevoTamaño=proximoPrimo(cantEntradas*2);
		PositionList<Entrada<K, V>> listaAnt;
		Entrada<K,V> entrada=null;
		int bucket;
		PositionList<Entrada<K, V>>[] arregloAnt=arreglo;
		arreglo=(PositionList<Entrada<K, V>>[]) new PositionList[nuevoTamaño];
		for (int r=0; r<arreglo.length; r++)
			arreglo[r]=new ListaDE<Entrada<K, V>>();
		for (int i=0; i<arregloAnt.length; i++) {
			listaAnt=arregloAnt[i];
			while (!listaAnt.isEmpty()) {
				  entrada=listaAnt.remove(listaAnt.first());
				  bucket=hash(entrada.getKey());
				  arreglo[bucket].addLast(entrada);
			}
			arregloAnt[i]=null;
		}
	}
	catch (EmptyListException | InvalidPositionException e) {
		  e.printStackTrace();
	}
  }
  
  /**
   * Calcula el proximo número primo al tamaño pasado por parámetro.
   * @param nuevoTamaño Nuevo tamaño del mapeo.
   * @return Retorna el proximo número primo al número pasado por parámetro.
   */
  private int proximoPrimo(int nuevoTamaño) {
	int resultado=nuevoTamaño;
	while (!esPrimo(resultado))
		  if (resultado % 2==0)
			  resultado++;
		  else resultado=resultado+2;
	return resultado;
  }
  
  /**
   * Consulta si el número pasado por parámetro es primo.
   * @param n Número a verificar si es primo.
   * @return Retorna verdadero si el número pasado por parámetro es primo, falso en caso contrario.
   */
  private boolean esPrimo(int n) {
	boolean es=true;
	int div=2;
	while (div<n && es) {
		  if (n % div==0)
			 es=false;
		  div++;
	}
	return es;
  }
  
  @Override
  public Entry<K,V> remove(Entry<K,V> entrada) throws InvalidEntryException {
	if (entrada==null)
	   throw new InvalidEntryException("La entrada es inválida.");
	int bucket=hash(entrada.getKey());
	Entry<K, V> eliminada=null;
	Position<Entrada<K, V>> pos=null;
	try {
		if (!arreglo[bucket].isEmpty()) {
			pos=arreglo[bucket].first();
			while (pos!=null && eliminada==null) {
				if (pos.element().equals(entrada)) {
					eliminada=arreglo[bucket].remove(pos);
					cantEntradas--;
				}
				else pos=(pos!=arreglo[bucket].last()) ? arreglo[bucket].next(pos) : null;
			}
			if (eliminada==null)
				throw new InvalidEntryException("La entrada no pertenece al diccionario.");
		}
		else throw new InvalidEntryException("La entrada no pertenece al diccionario.");
	}
	catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
		e.printStackTrace();
	}
	return eliminada;
  }
  
  @Override
  public Iterable<Entry<K, V>> entries() {
    PositionList<Entry<K, V>> entradas=new ListaDE<Entry<K, V>>();
    for (int i=0; i<arreglo.length; i++) {
    	for (Entrada<K, V> entrada:arreglo[i])
    		entradas.addLast(entrada);
    }
	return entradas;
  }
  
  @Override
  public int size() {
	return cantEntradas;
  }
  
  @Override
  public  boolean isEmpty() {
	return cantEntradas==0;
  }
}