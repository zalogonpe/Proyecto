package GUI;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import Excepciones.BankException;
import Programa.*;
import TDADiccionario.Entry;

public class GUI extends JFrame {
	private JPanel panelAcceso, panelBotones, panelPrincipal;
	private JPasswordField cajaContrase�a;
	private JLabel etiquetaSaldo;
	private JButton botonIngresar, botonSalir, botonRealizar, botonReciente, botonHistorica, botonCostosa, botonMonto;
	private CuentaBancaria cuenta;
	
	/**
	 * Create the application.
	 */
	public GUI() {
		super("BNS");
		getContentPane().setLayout(new BorderLayout());
		setSize(new Dimension(925, 405));
		setResizable(false);
		setIconImage(new ImageIcon("Fondo GUI.jpg").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cuenta=new CuentaBancaria();
		armarComponentes();
		armarPaneles();
		getContentPane().add(panelPrincipal);
	}
	
	private void armarComponentes() {
		//Creo la caja de texto para la contrase�a
		cajaContrase�a=new JPasswordField();
		cajaContrase�a.setToolTipText("Ingrese su contrase�a");
		cajaContrase�a.setColumns(50);
		
		//Creo la etiqueta que siempre muestra el saldo de la cuenta
		etiquetaSaldo=new JLabel(); etiquetaSaldo.setText(" Saldo: $"+cuenta.consultarSaldo());
		etiquetaSaldo.setVerticalAlignment(SwingConstants.BOTTOM);
		
		//Creo los botones 
		botonIngresar=new JButton("Ingresar"); botonIngresar.setActionCommand("Ingresar");
		botonSalir=new JButton("Salir");
		botonSalir.setActionCommand("Salir"); botonSalir.setEnabled(false);
		botonRealizar=new JButton("Realizar transacci�n"); botonRealizar.setEnabled(false);
		botonReciente=new JButton("Operaci�n m�s reciente");
		botonReciente.setActionCommand("Reciente"); botonReciente.setEnabled(false);
		botonHistorica=new JButton("Operaci�n m�s historica");
		botonHistorica.setActionCommand("Historica"); botonHistorica.setEnabled(false);
		botonCostosa=new JButton("Operacion m�s costosa");
		botonCostosa.setActionCommand("Costosa"); botonCostosa.setEnabled(false);
		botonMonto=new JButton("Operaciones con mismo monto"); botonMonto.setEnabled(false);
		
		//Agrego los oyentes para cada bot�n
		OyenteAcceso acceso=new OyenteAcceso();
		botonIngresar.addActionListener(acceso); botonSalir.addActionListener(acceso);
		OyenteTransaccion transaccion=new OyenteTransaccion();
		botonRealizar.addActionListener(transaccion);
		OyenteOperaciones operaciones=new OyenteOperaciones();
		botonReciente.addActionListener(operaciones); botonHistorica.addActionListener(operaciones);
		botonCostosa.addActionListener(operaciones);
		OyenteMonto monto=new OyenteMonto();
		botonMonto.addActionListener(monto);
	}
	
	private void armarPaneles() {
		//Creo el panel de acceso al sistema y le agrego los componentes correspondientes.
		panelAcceso=new JPanel();
		panelAcceso.setOpaque(false);
		panelAcceso.add(cajaContrase�a);
		panelAcceso.add(botonIngresar); panelAcceso.add(botonSalir);
		
		//Creo el panel de botones y les agrego los botones correspondientes.
		panelBotones=new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.add(botonRealizar); panelBotones.add(botonReciente);
		panelBotones.add(botonHistorica); panelBotones.add(botonCostosa);
		panelBotones.add(botonMonto);
		
		try {
			panelPrincipal=new PanelConFondo("Fondo GUI.jpg");
			panelPrincipal.setLayout(new BorderLayout());
			panelPrincipal.add(panelAcceso, BorderLayout.NORTH);
			panelPrincipal.add(etiquetaSaldo, BorderLayout.WEST);
			panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI gui = new GUI();
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private class OyenteAcceso implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			JOptionPane aviso;
			boolean valida;
			if (evento.getActionCommand().equals("Ingresar")) {
				String contrase�a=new String(cajaContrase�a.getPassword());
				valida=cuenta.validarAcceso(contrase�a);
				if (valida) {
					cajaContrase�a.setEnabled(false);
					botonIngresar.setEnabled(false); botonSalir.setEnabled(true);
					botonRealizar.setEnabled(true); botonReciente.setEnabled(true);
					botonHistorica.setEnabled(true); botonCostosa.setEnabled(true);
					botonMonto.setEnabled(true);
				}
				else {
					aviso=new JOptionPane();
					aviso.showMessageDialog(null, "La contrase�a es invalida", "Error", JOptionPane.ERROR_MESSAGE);
					cajaContrase�a.setText("");
				}
			}
			if (evento.getActionCommand().equals("Salir")) {
				cajaContrase�a.setEnabled(true); cajaContrase�a.setText("");
				botonSalir.setEnabled(false); botonIngresar.setEnabled(true);
				botonRealizar.setEnabled(false); botonReciente.setEnabled(false);
				botonHistorica.setEnabled(false); botonCostosa.setEnabled(false);
				botonMonto.setEnabled(false); etiquetaSaldo.setText("Saldo: $0.0");
			}
		}
	}
	private class OyenteTransaccion implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			JOptionPane mensaje=new JOptionPane();
			String montoEntrada=mensaje.showInputDialog(null, "Ingrese el monto de la transacci�n:", "", JOptionPane.QUESTION_MESSAGE);
			float monto;
			try {
				if (montoEntrada!=null && !montoEntrada.equals("")) {
					monto=Float.valueOf(montoEntrada);
					cuenta.realizarTransaccion(monto);
					etiquetaSaldo.setText("Saldo: $"+cuenta.consultarSaldo());
					if (monto>0)
						mensaje.showMessageDialog(null, "Se depositaron en la cuenta $"+monto, "Confirmaci�n", JOptionPane.INFORMATION_MESSAGE);
					else {
						if (monto<0)
							mensaje.showMessageDialog(null, "Se extrajeron de la cuenta $"+Math.abs(monto), "Confirmaci�n", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else mensaje.showMessageDialog(null, "No se ingreso un monto v�lido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			catch (BankException e) {
				mensaje.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private class OyenteOperaciones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			Transaccion transaccion;
			JOptionPane mensaje=new JOptionPane();
			try {
				if (evento.getActionCommand().equals("Reciente")) {
					transaccion=cuenta.masReciente();
					mensaje.showMessageDialog(null, transaccion.getTipo()+": $"+transaccion.getMonto(), "Operaci�n m�s reciente", JOptionPane.INFORMATION_MESSAGE);
				}
				if (evento.getActionCommand().equals("Historica")) {
					transaccion=cuenta.masHistorica();
					mensaje.showMessageDialog(null, transaccion.getTipo()+": $"+transaccion.getMonto(), "Operaci�n m�s historica", JOptionPane.INFORMATION_MESSAGE);
				}
				if (evento.getActionCommand().equals("Costosa")) {
					transaccion=cuenta.masCostosa();
					if (transaccion!=null)
						mensaje.showMessageDialog(null, transaccion.getTipo()+": $"+transaccion.getMonto(), "Operaci�n m�s costosa", JOptionPane.INFORMATION_MESSAGE);
					else mensaje.showMessageDialog(null, "No hay operaciones registradas para consultar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
			catch (BankException e) {
				mensaje.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	private class OyenteMonto implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			float monto;
			String operaciones="";
			Iterable<Entry<Float, Transaccion>> listadoOperaciones;
			JOptionPane mensaje=new JOptionPane();
			String montoEntrada=mensaje.showInputDialog(null, "Ingrese el monto de las transacci�nes que desea consultar:", "", JOptionPane.QUESTION_MESSAGE);
			if (montoEntrada!=null && !montoEntrada.equals("")) {
				monto=Float.valueOf(montoEntrada);
				listadoOperaciones=cuenta.mismoMonto(monto);
				if (listadoOperaciones!=null) {
					for (Entry<Float, Transaccion> transaccion:listadoOperaciones)
						operaciones=operaciones+transaccion.getValue().getTipo()+": $"+transaccion.getKey()+"\n";
					if (!operaciones.equals(""))
						mensaje.showMessageDialog(null, operaciones, "Operaciones con el mismo monto", JOptionPane.PLAIN_MESSAGE);
					else mensaje.showMessageDialog(null, "No se encontraron operaciones registradas con el monto ingresado para consultar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else mensaje.showMessageDialog(null, "No hay operaciones registradas para consultar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			else mensaje.showMessageDialog(null, "No se ingreso un monto v�lido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
}