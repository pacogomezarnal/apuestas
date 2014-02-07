import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private Equipo equipo;


	/**
	 * Create the frame.
	 */
	public VentanaEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre del Equipo");
		lblNombre.setBounds(10, 33, 106, 14);
		contentPane.add(lblNombre);
		
		JLabel label = new JLabel("Nombre del Equipo");
		label.setBounds(10, 70, 106, 14);
		contentPane.add(label);
		
		//Creacion del equipo
		equipo=new Equipo("",0,0,0,0);
	}
	
	private void guardarEnFichero(){
		ObjectOutputStream salida;
		try// abre el archivo
		{
			salida = new ObjectOutputStream(new FileOutputStream( "clientes.ser") );
			salida.writeObject( equipo ); // envía el registro como salida
			if( salida != null)
				salida.close();
		}// fin de try
		catch( IOException ioException )
		{
			System.err.println("Error al abrir el archivo.");
		}// fin de catch
	}// fin del método guardarEnFichero
			
}
