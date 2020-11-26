package Programa;
import Excepciones.BankException;
import Excepciones.InvalidKeyException;
import TDACola.ColaConArregloCircular;
import Excepciones.EmptyQueueException;
import TDACola.Queue;
import Excepciones.EmptyPriorityQueueException;
import TDAColaCP.Heap;
import TDAColaCP.PriorityQueue;
import TDADeque.Deque;
import TDADiccionario.DiccionarioConHashAbierto;
import TDADiccionario.Dictionary;
import TDADiccionario.Entry;
import Excepciones.EmptyStackException;
import TDAPila.PilaEnlazada;
import TDAPila.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
	 * Crea una nueva cuenta bancaria con un saldo inicial de 0 y un historial de transacciones vac�o.
	 */
	public CuentaBancaria() {
		historial=new Deque<Transaccion>();
		saldo=0;
	}
	
	//Comandos
	/**
	 * Genera una nueva transaccion agregandola al historial y modificando el saldo de la cuenta.
	 * @param monto Monto de la nueva transacci�n.
	 * @param desc Descripci�n de la transacci�n.
	 * @throws BankException Si tiene fondos insuficientes para realizar la transacci�n o si el monto de la transacci�n es igual a 0.
	 */
	public void realizarTransaccion(float monto, String desc) throws BankException {
		Transaccion nueva;
		if (monto<0) {
			if (saldo+monto>=-5000)
				nueva=new Transaccion(Math.abs(monto), "Extracci�n", desc);
			else throw new BankException("Fondos insuficientes en la cuenta.");
		}
		else {
			if (monto>0)
				nueva=new Transaccion(monto, "Deposito", desc);
			else throw new BankException("Monto inv�lido.");
		}
		historial.addLast(nueva);
		saldo=saldo+monto;
	}
	
	//Consultas
	/**
	 * Consulta la transacci�n m�s reciente que se realiz� en la cuenta.
	 * @return Retorna la transacci�n m�s reciente de la cuenta.
	 * @throws BankException Si el historial de transacciones de la cuenta est� vac�o.
	 */
	public Transaccion masReciente() throws BankException {
		Transaccion reciente = null;
		
		try {
			if(historial.isEmpty())
				throw new BankException("No se han realizado transacciones en la cuenta.");
			reciente = historial.getLast();
		}
		catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}
		
		return reciente;
	}

	/**
	 * Consulta la transacci�n m�s hist�rica que se realiz� en la cuenta.
	 * @return Retorna la transacci�n m�s hist�rica de la cuenta.
	 * @throws BankException Si el historial de transacciones de la cuenta est� vac�o.
	 */
	public Transaccion masHistorica() throws BankException {
		Transaccion historica = null;
		
		try {
			if(historial.isEmpty())
				throw new BankException("No se han realizado transacciones en la cuenta.");
			historica = historial.getFirst();
		}
		catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}
		
		return historica;
	}
	
	/**
	 * Consulta la transacc�n m�s costosa que se realiz� en la cuenta.
	 * @return Retorna la transacci�n m�s costosa de la cuenta.
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
	 * Consulta todas las transacciones realizadas con igual monto al dado y los retorna.
	 * @param monto Monto de las transacciones a buscar.
	 * @return Retorna una coleccion iterable de transacciones monto igual al dado.
	 */
	public Iterable<Entry<Float, Transaccion>> mismoMonto(float monto) {
		Dictionary<Float, Transaccion> diccionarioDeque = new DiccionarioConHashAbierto<Float, Transaccion>();
		Iterable<Entry<Float,Transaccion>> mismoMonto = null;
		Iterator<Transaccion> it;
		Transaccion transaccion;
		try {
			if(!historial.isEmpty()) {		//si el historial esta vacio, entonces no hago nada
					it = historial.iterator();
					while (it.hasNext()) {	//recorro el historial y paso los elementos de este al diccionario
						transaccion = it.next();
						diccionarioDeque.insert(transaccion.getMonto(), transaccion);
					}
					mismoMonto = diccionarioDeque.findAll(monto);  //le asigno una coleccion iterable con todas las transacciones (valor) con mismo monto (clave)
			} //end if
		}
		catch (InvalidKeyException e) {
			System.out.println(e.toString());
		}
		return mismoMonto;
	}

	/**
	 * Verifica si la contrase�a pasada por par�metro respeta el formato especificado.
	 * De ser as�, se brinda acceso al sistema, en caso contrario la aplicaci�n permanece bloqueada. 
	 * @param contrase�a C�digo de acceso ingresado.
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
			//Ciclo que recorre la cadena en su totalidad
			while (esValida && indice<contrase�a.length()) {
				//Ciclo que recorrer la primera parte de la cadena(A)
				while (!finalizoApellido && indice<contrase�a.length()) {
					leido = contrase�a.charAt(indice);
					indice++;
					if (leido=='0' || leido=='1' || leido=='2' || leido=='3'|| leido=='4' || leido=='5' || leido=='6' || leido=='7' || leido=='8' || leido=='9') {
						finalizoApellido=true;
						esValida=false;
					}
					if (leido == 'x')
						finalizoApellido = true;
					else pilaAux.push(leido);
				}
				if (!finalizoApellido)
					esValida = false;
				//Ciclo que recorre la primera aparici�n de la cadena A' despu�s de que aparece una 'x'
				while (esValida && indice<contrase�a.length() && !pilaAux.isEmpty()) {
					leido = contrase�a.charAt(indice);
					indice++;
					if (leido == pilaAux.top())
						colaAux.enqueue(pilaAux.pop());
					else esValida = false;
				}
				if (!(indice<contrase�a.length()) || !pilaAux.isEmpty())
					esValida = false;
				//Ciclo que recorre la segunda aparici�n de la cadena A'
				while (esValida && indice<contrase�a.length() && !colaAux.isEmpty()) {
					leido = contrase�a.charAt(indice);
					indice++;
					if (leido == colaAux.front())
						colaAux.dequeue();
					else esValida = false;
				}
				if (!colaAux.isEmpty())
					esValida = false;
			//}
			if (indice!=contrase�a.length() || !pilaAux.isEmpty() || !colaAux.isEmpty())
				esValida = false;
		}
		catch (EmptyStackException | EmptyQueueException e) {
			System.out.println(e.toString());
		}
		return esValida;
	}
}