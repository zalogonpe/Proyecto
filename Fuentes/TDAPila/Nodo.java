package TDAPila;

/**
 * Clase que representa a un nodo de pila.
 * @author Gonzalo Perez & Juan Rapino
 *
 * @param <E> Tipo de dato del elemento asociado al nodo. 
 */
public class Nodo<E> {
    private Nodo<E> siguiente;
    private E elemento;

    /**
     * Crea un nodo con el elemento y el nodo siguiente pasados por parámetro.
     * @param item Elemento del nodo.
     * @param sig Nodo siguiente al nodo actual.
     */
    public Nodo(E item, Nodo<E> sig){
        siguiente = sig;
        elemento = item;
    }

    /**
     * Setea el nodo siguiente al nodo actual.
     * @param siguiente Nodo siguiente al nodo actual.
     */
    public void setSiguiente(Nodo<E> siguiente){
        this.siguiente = siguiente;
    }

    /**
     * Setea el elemento al nodo.
     * @param elemento Elemento del nodo.
     */
    public void setElemento(E elemento){
        this.elemento = elemento;
    }

    /**
     * Consulta el nodo siguiente al nodo actual.
     * @return Retorna el nodo siguiente al nodo actual.
     */
    public Nodo<E> getSiguiente(){
        return siguiente;
    }

    /**
     * Consulta el elemento del nodo.
     * @return Elemento del nodo.
     */
    public E getElemento(){
        return elemento;
    }
}