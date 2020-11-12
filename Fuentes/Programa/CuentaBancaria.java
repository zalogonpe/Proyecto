package Programa;
import TDACola.ColaConArregloCircular;
import TDACola.EmptyQueueException;
import TDACola.Queue;
import TDAColaCP.EmptyPriorityQueueException;
import TDAColaCP.Heap;
import TDAColaCP.InvalidKeyException;
import TDAColaCP.PriorityQueue;
import TDADeque.Deque;
import TDADiccionario.DiccionarioConHashAbierto;
import TDADiccionario.Dictionary;
import TDADiccionario.Entry;
import TDALista.PositionList;
import TDAPila.EmptyStackException;
import TDAPila.PilaEnlazada;
import TDAPila.Stack;

import java.util.Iterator;

/**
 * Clase que modela las funciones del sistema.
 * @author Gonzalo Perez & Juan Rapino
 *
 */
public class CuentaBancaria {
	//Atributos de instancia
	private Deque<Transaccion> historial;
	private float saldo;

	/**
	 * Crea una nueva cuenta bancaria con un saldo inicial de 0 y sin historial de transacciones.
	 */
	public CuentaBancaria() {
		historial=new Deque<Transaccion>();
		saldo=0;
	}
	
	//Comandos
	/**
	 * Genera una nueva transaccion agregandola al historial y modificando el saldo de la cuenta.
	 * @param monto Monto de la nueva transacci�n.
	 * @throws BankException Si tiene fondos insuficientes para realizar la transacci�n.
	 */
	public void realizarTransaccion(float monto) throws BankException {
		Transaccion nueva;
		if (monto<0) {
			if (Math.abs(monto)<500)
				nueva=new Transaccion("Extracci�n", Math.abs(monto));
			else throw new BankException("Fondos insuficientes en la cuenta.");
		}
		else nueva=new Transaccion("Deposito", monto);
		historial.addLast(nueva);
		saldo=saldo+monto;
	}
	
	//Consultas

	public Transaccion masReciente() throws BankException{
		if(historial.isEmpty())
			throw new BankException("Historial vacio");

		return historial.getLast();
	}

	public Transaccion masHistorica() throws BankException{
		if(historial.isEmpty())
			throw new BankException("Historial vacio");

		return historial.getFirst();
	}
	
	/**
	 * Consulta la transacc�n m�s costosa que se realiz� en la cuenta.
	 * @return Retorna la transacci�n m�s costosa en el historial de la cuenta.
	 */
	public Transaccion masCostosa() {
		Transaccion mayor=null;
		try {
			PriorityQueue<Float, Transaccion> transacciones=new Heap<Float, Transaccion>();
			if (!historial.isEmpty()) {
				for (Transaccion t:historial)
					transacciones.insert(t.getMonto(), t);
				mayor=transacciones.removeMin().getValue();
			}
		}
		catch (InvalidKeyException | EmptyPriorityQueueException e) {
			System.out.println(e.toString());
		}
		return mayor;
	}
	
	/**
	 * Consulta el saldo de la cuenta.
	 * @return Retorna el saldo de la cuenta.
	 */
	public float consultarSaldo() {
		return saldo;
	}


	/**
	 * Retorna una colecci�n iterable que contiene todas las entradas con clave igual al monto dado.
	 * @param monto clave de las entradas a buscar.
	 * @return Coleccion iterable de entradas con clave igual al monto dado.
	 */
	//T(n)= c1+c2+c3+c4+c5+  n(c6+c7+c8+c9)+ (el orden de findAll, creo que era 'n' peor caso no me acuerdo) + c10 = 2n ---> O(n)
	public Iterable<Entry<Float, Transaccion>> mismoMonto(float monto) {

		Dictionary<Float, Transaccion> diccionarioDeque = new DiccionarioConHashAbierto<Float, Transaccion>();
		Iterable<Entry<Float,Transaccion>> mismoMonto = null;
		Iterator<Transaccion> it = historial.iterator();
		Transaccion transaccion;

		if(!historial.isEmpty()) {		//si el historial esta vacio, entonces no hago nada
			try {

				while (it.hasNext()) {	//recorro el historial y paso los elementos de este al diccionario
					transaccion = it.next();
					diccionarioDeque.insert(transaccion.getMonto(), transaccion);
				}

				mismoMonto = diccionarioDeque.findAll(monto);  //le asigno una coleccion iterable con todas las transacciones (valor) con mismo monto (clave)

			}catch(TDADiccionario.InvalidKeyException e){
				e.printStackTrace();
			}

		} //end if

		return mismoMonto;
	}


	/**
	 * Verifica si la contrase�a pasada por par�metro respeta el formato especificado.
	 * De ser as�, se brinda acceso al sistema, en caso contrario la aplicaci�n permanece bloqueada. 
	 * @param contrase�a Es el c�digo de acceso ingresado.
	 * @return Verdadero si el c�digo de acceso es valido, falso en caso contrario.
	 */
	public boolean validarAcceso(String contrase�a) {
		boolean esValida = contrase�a.length()>1;
		int indice = 0;
		char leido = '@';
		boolean finalizoApellido = false;
		Stack<Character> pilaAux = new PilaEnlazada<Character>();
		Queue<Character> colaAux = new ColaConArregloCircular<Character>();
		try {
			while (esValida && indice<contrase�a.length()) {
				while (!finalizoApellido && indice<contrase�a.length()) {
					leido = contrase�a.charAt(indice);
					indice++;
					if (leido == 'x')
						finalizoApellido = true;
					else pilaAux.push(leido);
				}
				if (!finalizoApellido)
					esValida = false;
				while (esValida && indice<contrase�a.length() && !pilaAux.isEmpty()) {
					leido = contrase�a.charAt(indice);
					indice++;
					if (leido == pilaAux.top())
						colaAux.enqueue(pilaAux.pop());
					else esValida = false;
				}
				if (!(indice<contrase�a.length()) || !pilaAux.isEmpty())
					esValida = false;
				while (esValida && indice<contrase�a.length() && !colaAux.isEmpty()) {
					leido = contrase�a.charAt(indice);
					indice++;
					if (leido == colaAux.front())
						colaAux.dequeue();
					else esValida = false;
				}
				if (!colaAux.isEmpty())
					esValida = false;
			}
			if (indice!=contrase�a.length() || !pilaAux.isEmpty() || !colaAux.isEmpty())
				esValida = false;
		}
		catch (EmptyStackException | EmptyQueueException e) {
			System.out.println(e.toString());
		}
		return esValida;
	}
}