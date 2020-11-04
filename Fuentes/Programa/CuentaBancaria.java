package Programa;
import TDACola.ColaConArregloCircular;
import TDACola.EmptyQueueException;
import TDACola.Queue;
import TDADeque.Deque;
import TDADiccionario.Dictionary;
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

	public CuentaBancaria() {
		historial=new Deque<Transaccion>();
		saldo=0;
	}
	
	//Comandos
	/**
	 * Genera una nueva transaccion agregandola al historial y modificando el saldo.
	 * @param monto Monto de la  nueva transacci�n.
	 */
	public void realizarTransaccion(float monto) {
		Transaccion nueva=new Transaccion(monto);
		historial.addLast(nueva);
		if (monto>0)
			saldo=saldo+monto;
		else saldo=saldo-Math.abs(monto);
	}
	
	//Consultas
	public Transaccion masReciente() {
		
	}
	
	public Transaccion masHistorica() {
		
	}
	
	public Transaccion masCostosa() {
		
	}
	
	/**
	 * Consulta el saldo de la cuenta bancaria.
	 * @return Retorna el saldo de la cuenta bancaria.
	 */
	public float consultarSaldo() {
		return saldo;
	}
	
	public Dictionary<Float, Transaccion> mismoMonto() {
		
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
			e.printStackTrace();
		}
		return esValida;
	}
}