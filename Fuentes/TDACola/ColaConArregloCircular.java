package TDACola;
import Excepciones.EmptyQueueException;

/**
 * Clase que implementa una cola con un arreglo circular de acuerdo a la interfaz Queue.
 * @author Gonzalo Perez & Juan Rapino.
 * 
 * @param <E>: Tipo de dato de los elementos a almacenar en la cola.
 */
public class ColaConArregloCircular<E> implements Queue<E> {

    protected E[] q;
    protected int front, rear;

    /**
     * Crea una cola implementada con un arreglo circular inicialmente vacía.
     */
    public ColaConArregloCircular() {
        q = (E[]) new Object[100];
        front = 0;
        rear = 0;
    }

    @Override
    public int size() {
        return (q.length - front + rear) % q.length;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public E front() throws EmptyQueueException {
        if(front == rear) {
            throw new EmptyQueueException("La cola está vacía.");
        }
        return q[front];
    }

    @Override
    public void enqueue(E element) {
        if((q.length - front + rear) % q.length == q.length-1) {
            redimensionar();
        }
        q[rear] = element;
        rear = (rear + 1) % q.length;
    }
    
    /**
     * Redimensiona el tamaño de la cola aumentando su capacidad.
     */
    private void redimensionar() {
      E[] aux=(E[]) new Object[q.length*2];
      int ocupados=(q.length - front + rear) % q.length;
      for (int i=0; i<ocupados; i++) {
      	aux[i]=q[front];
      	front=(front+1) % q.length;
      }
      rear=ocupados;
      front=0;
      q=aux;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
    	E temp;
        if(front == rear) {
            throw new EmptyQueueException("Cola vacÃ­a.");
        }
        else {
            temp = q[front];
            q[front] = null;
            front = (front + 1) % (q.length);
        }
        return temp;
    }
}