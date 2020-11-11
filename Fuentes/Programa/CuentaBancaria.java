package Programa;
import TDACola.ColaConArregloCircular;
import TDACola.EmptyQueueException;
import TDACola.Queue;
import TDAColaCP.EmptyPriorityQueueException;
import TDAColaCP.Heap;
import TDAColaCP.InvalidKeyException;
import TDAColaCP.PriorityQueue;
import TDADeque.Deque;
import TDADiccionario.Dictionary;
import TDALista.PositionList;
import TDAPila.EmptyStackException;
import TDAPila.PilaEnlazada;
import TDAPila.Stack;

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
	 * @param monto Monto de la nueva transacción.
	 * @throws BankException Si tiene fondos insuficientes para realizar la transacción.
	 */
	public void realizarTransaccion(float monto) throws BankException {
		Transaccion nueva;
		if (monto<0) {
			if (Math.abs(monto)<500)
				nueva=new Transaccion("Extracción", Math.abs(monto));
			else throw new BankException("Fondos insuficientes en la cuenta.");
		}
		else nueva=new Transaccion("Deposito", monto);
		historial.addLast(nueva);
		saldo=saldo+monto;
	}
	
	//Consultas
	public Transaccion masReciente() {
		
	}
	
	public Transaccion masHistorica() {
		
	}
	
	/**
	 * Consulta la transaccón más costosa que se realizó en la cuenta.
	 * @return Retorna la transacción más costosa en el historial de la cuenta.
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
	
	public PositionList<Transaccion> mismoMonto() {
		
	}
	
	/**
	 * Verifica si la contraseña pasada por parámetro respeta el formato especificado.
	 * De ser así, se brinda acceso al sistema, en caso contrario la aplicación permanece bloqueada. 
	 * @param contraseña Es el código de acceso ingresado.
	 * @return Verdadero si el código de acceso es valido, falso en caso contrario.
	 */
	public boolean validarAcceso(String contraseña) {
		boolean esValida = contraseña.length()>1;
		int indice = 0;
		char leido = '@';
		boolean finalizoApellido = false;
		Stack<Character> pilaAux = new PilaEnlazada<Character>();
		Queue<Character> colaAux = new ColaConArregloCircular<Character>();
		try {
			while (esValida && indice<contraseña.length()) {
				while (!finalizoApellido && indice<contraseña.length()) {
					leido = contraseña.charAt(indice);
					indice++;
					if (leido == 'x')
						finalizoApellido = true;
					else pilaAux.push(leido);
				}
				if (!finalizoApellido)
					esValida = false;
				while (esValida && indice<contraseña.length() && !pilaAux.isEmpty()) {
					leido = contraseña.charAt(indice);
					indice++;
					if (leido == pilaAux.top())
						colaAux.enqueue(pilaAux.pop());
					else esValida = false;
				}
				if (!(indice<contraseña.length()) || !pilaAux.isEmpty())
					esValida = false;
				while (esValida && indice<contraseña.length() && !colaAux.isEmpty()) {
					leido = contraseña.charAt(indice);
					indice++;
					if (leido == colaAux.front())
						colaAux.dequeue();
					else esValida = false;
				}
				if (!colaAux.isEmpty())
					esValida = false;
			}
			if (indice!=contraseña.length() || !pilaAux.isEmpty() || !colaAux.isEmpty())
				esValida = false;
		}
		catch (EmptyStackException | EmptyQueueException e) {
			System.out.println(e.toString());
		}
		return esValida;
	}
}