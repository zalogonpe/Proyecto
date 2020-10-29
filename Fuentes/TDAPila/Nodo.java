package TDAPila;

public class Nodo<E> {
    private Nodo<E> siguiente;
    private E elemento;

    public Nodo(E item){
        this(item, null);
    }

    public Nodo(E item, Nodo<E> sig){
        siguiente = sig;
        elemento = item;
    }

    public void setSiguiente(Nodo<E> siguiente){
        this.siguiente = siguiente;
    }

    public void setElemento(E elemento){
        this.elemento = elemento;
    }

    public Nodo<E> getSiguiente(){
        return siguiente;
    }

    public E getElemento(){
        return elemento;
    }
}
