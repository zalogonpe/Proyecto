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
	private Deque historial;
	private float saldo;

	public CuentaBancaria() {
		saldo=0;
		historial=new Deque();
	}
	
	//Comandos
	public void realizarTransaccion(float monto) {
		
	}
	
	//Consultas
	public Transaccion masReciente() {
		
	}
	
	public Transaccion masHistorica() {
		
	}
	
	public Transaccion masCostosa() {
		
	}
	
	public float consultarSaldo() {
		return saldo;
	}
	
	public Dictionary<Float, Transaccion> mismoMonto() {
		
	}
	
	/**
	 * Verifica si la contraseña pasada por parámetro respeta el formato especificado.
	 * De ser así, se brinda acceso al sistema, en caso contrario la aplicación permanece bloqueada. 
	 * @param contraseña Es el código de acceso ingresado.
	 * @return Verdadero si el código de acceso es valido, falso en caso contrario.
	 */
	public boolean validarAcceso(String contraseña) {
		try {
			boolean esValida = contraseña.length()>1;
			int indice = 0;
			char leido = '@';
			boolean finalizoApellido = false;
			Stack<Character> pilaAux = new PilaEnlazada<Character>();
			Queue<Character> colaAux = new ColaConArregloCircular<Character>();
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
			return esValida;
		}
		catch (EmptyStackException | EmptyQueueException e) {
			e.printStackTrace();
		}
		return false;
	}
}