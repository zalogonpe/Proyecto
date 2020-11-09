package TDAColaCP;
import java.util.Comparator;

/**
 * Clase Heap que implementa una cola con prioridad. 
 * @author Gonzalo Perez
 *
 * @param <K> Tipo de dato de la prioridad de la cola.
 * @param <V> Tipo de dato del valor asociado a la prioridad.
 */
public class Heap<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
  //Atributos de instancia
  protected Entrada<K, V> [] arreglo;
  protected Comparator<K> comp;
  protected int tamaño;
  
  //Constructor
  /**
   * Crea un heap inicialmente vacío.
   */
  public Heap() {
	arreglo=(Entrada<K, V> []) new Entrada[100];
	comp=new Comparador<K>();
	tamaño=0;
  }
  
  //Consultas
  @Override
  public Entry<K,V> min() throws EmptyPriorityQueueException {
	if (tamaño==0)
		throw new EmptyPriorityQueueException("La cola con prioridad está vacía.");
	return arreglo[1];
  }
  
  @Override
  public Entry<K,V> insert(K prioridad,V valor) throws InvalidKeyException {
	if (prioridad==null)
		throw new InvalidKeyException("La clave es invalida.");
	Entrada<K, V> aux;
	if (tamaño==arreglo.length-1) {
		redimensionar();
	}
	Entrada<K, V> nuevaEntrada=new Entrada<K, V>(prioridad, valor);
	tamaño++;
	arreglo[tamaño]=nuevaEntrada;
	int i=tamaño;
	boolean seguir=true;
	while (i>1 && seguir) {
		if (comp.compare(arreglo[i].getKey(), arreglo[i/2].getKey())<0) {
			aux=arreglo[i];
			arreglo[i]=arreglo[i/2];
			arreglo[i/2]=aux;
			i=i/2;
		}
		else seguir=false;
	}
	return nuevaEntrada;
  }
  
  /**
   * Redimensiona el tamaño del heap aumentando su capacidad. 
   */
  private void redimensionar() {
	Entrada<K, V> [] arregloAux;
    arregloAux=(Entrada<K, V>[]) new Entrada[arreglo.length*2];
	for (int r=0; r<arreglo.length; r++)
		arregloAux[r]=arreglo[r];
	arreglo=arregloAux;
  }
  
  @Override
  public Entry<K,V> removeMin() throws EmptyPriorityQueueException {
	if (tamaño==0)
		throw new EmptyPriorityQueueException("La cola con prioridad está vacía.");
	Entry<K, V> minimo=arreglo[1];
	Entrada<K, V> aux;
	int i, hijoIzq, hijoDer, posMin=1;
	boolean seguir, tieneHI, tieneHD;
	if (tamaño==1) {
		arreglo[tamaño]=null; tamaño=0;
	}
	else {
		 arreglo[1]=arreglo[tamaño];
		 arreglo[tamaño]=null;
		 tamaño--;
		 //Burbujeo la nueva raíz hasta encontrar su ubicación correcta
		 i=1;
		 seguir=true;
		 while (seguir) {
			   hijoIzq=i*2;
			   hijoDer=i*2+1;
			   tieneHI=(hijoIzq<=tamaño);
			   tieneHD=(hijoDer<=tamaño);
			   if (!tieneHI)
				   seguir=false;
			   else {
				    posMin=hijoIzq;
				    if (tieneHD)
				    	if (comp.compare(arreglo[hijoIzq].getKey(), arreglo[hijoDer].getKey())>0)
				    		posMin=hijoDer;
				    if (comp.compare(arreglo[i].getKey(), arreglo[posMin].getKey())>0) {
				    	aux=arreglo[i];
				    	arreglo[i]=arreglo[posMin];
				    	arreglo[posMin]=aux;
				    	i=posMin;
				    }
				    else seguir=false;
			   }
		 }
	}
	return minimo;
  }
  
  @Override
  public int size() {
	return tamaño;
  }
  
  @Override
  public boolean isEmpty() {
	return tamaño==0;
  }
}