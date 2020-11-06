package Programa;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
	private JPanel panelBotones;
	private JButton botonIngresar, botonRealizar, botonMonto, botonReciente, botonHistorica, botonCostosa;
	
	/**
	 * Create the application.
	 */
	public GUI() {
		super("Banco UNS");
		getContentPane().setLayout(new BorderLayout());
		setSize(new Dimension(800, 500));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		armarComponentes();
		armarPaneles();
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
	}
	
	private void armarComponentes() {
		botonIngresar=new JButton("Ingresar");
		botonRealizar=new JButton("Realizar transacción");
		botonMonto=new JButton("Operaciones con mismo monto");
		botonReciente=new JButton("Operación más reciente");
		botonHistorica=new JButton("Operación más historica");
		botonCostosa=new JButton("Operacion más costosa");
	}
	
	private void armarPaneles() {
		panelBotones=new JPanel();
		panelBotones.add(botonRealizar); panelBotones.add(botonMonto);
		panelBotones.add(botonReciente); panelBotones.add(botonHistorica);
		panelBotones.add(botonCostosa);
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
}