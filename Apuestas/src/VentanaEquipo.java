import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VentanaEquipo extends JFrame {

	//Controles de la ventana
	private JPanel contentPane;
	private Equipo equipo;
	private Liga liga;
	private VentanaLiga vLiga;
	private JComboBox jLiga;
	private JLabel lblNombre ;
	private JTextField equipo_lbl_txt;
	private JTextField golesFav_lbl_txt;
	private JTextField golesCon_lbl_txt;
	private JTextField partiGan_lbl_txt;
	private JTextField partidosPerd_lbl_txt;
	private JButton btnGuardar;
	private boolean modifica;
	
	//Objetos de lectura de ficheros
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;



	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo equipoAModificar,JComboBox jLiga,boolean modifica,Liga liga) {

		//Asignacion del equipo
		equipo=equipoAModificar;
		this.jLiga=jLiga;
		this.modifica=modifica;
		this.liga=liga;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre del Equipo");
		lblNombre.setBounds(10, 33, 106, 14);
		contentPane.add(lblNombre);
		
		equipo_lbl_txt = new JTextField();
		equipo_lbl_txt.setBounds(126, 30, 130, 20);
		contentPane.add(equipo_lbl_txt);
		equipo_lbl_txt.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a Favor");
		lblGolesAFavor.setBounds(10, 69, 106, 14);
		contentPane.add(lblGolesAFavor);
		
		golesFav_lbl_txt = new JTextField();
		golesFav_lbl_txt.setColumns(10);
		golesFav_lbl_txt.setBounds(126, 66, 130, 20);
		contentPane.add(golesFav_lbl_txt);
		
		JLabel lblGolesEnContra = new JLabel("Goles en Contra");
		lblGolesEnContra.setBounds(10, 106, 106, 14);
		contentPane.add(lblGolesEnContra);
		
		golesCon_lbl_txt = new JTextField();
		golesCon_lbl_txt.setColumns(10);
		golesCon_lbl_txt.setBounds(126, 103, 130, 20);
		contentPane.add(golesCon_lbl_txt);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados");
		lblPartidosGanados.setBounds(10, 146, 106, 14);
		contentPane.add(lblPartidosGanados);
		
		partiGan_lbl_txt = new JTextField();
		partiGan_lbl_txt.setColumns(10);
		partiGan_lbl_txt.setBounds(126, 143, 130, 20);
		contentPane.add(partiGan_lbl_txt);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos Perdidos");
		lblPartidosPerdidos.setBounds(10, 185, 106, 14);
		contentPane.add(lblPartidosPerdidos);
		
		partidosPerd_lbl_txt = new JTextField();
		partidosPerd_lbl_txt.setColumns(10);
		partidosPerd_lbl_txt.setBounds(126, 182, 130, 20);
		contentPane.add(partidosPerd_lbl_txt);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarEquipo();
			}
		});
		btnGuardar.setBounds(284, 29, 122, 54);
		contentPane.add(btnGuardar);
		
		//Rellenar datos del equipo al abrir la ventana
		leerEquipo();
		
	}
	
	//Metodo que guarda datos en el objeto equipo
	private void guardarEquipo(){
		equipo.setGolesContra(Integer.valueOf(golesCon_lbl_txt.getText()));
		equipo.setGolesFavor(Integer.valueOf(golesFav_lbl_txt.getText()));
		equipo.setNombre(equipo_lbl_txt.getText());
		equipo.setPartidosGanados(Integer.valueOf(partiGan_lbl_txt.getText()));
		equipo.setPartidosPerdidos(Integer.valueOf(partidosPerd_lbl_txt.getText()));
		if(!modifica)
		{
			jLiga.addItem(equipo);
			this.liga.newEquipoDB(equipo);
		}else{
			Equipo equipoElegido=(Equipo)jLiga.getSelectedItem();
			equipoElegido.setNombre(equipo.getNombre());
		}
		
	}
	
	//Metodo que pone datos desde objeto equipo
	private void leerEquipo(){
		golesCon_lbl_txt.setText(String.valueOf(equipo.getGolesContra()));
		golesFav_lbl_txt.setText(String.valueOf(equipo.getGolesFavor()));
		equipo_lbl_txt.setText(String.valueOf(equipo.getNombre()));
		partiGan_lbl_txt.setText(String.valueOf(equipo.getPartidosGanados()));
		partidosPerd_lbl_txt.setText(String.valueOf(equipo.getPartidosPerdidos()));
		
	}
	
	private void guardarEnFichero(){
		try// abre el archivo
		{
			salida = new ObjectOutputStream(new FileOutputStream( "equipo.ser") );
			salida.writeObject( equipo ); // envía el registro como salida
			if( salida != null)
				salida.close();
		}// fin de try
		catch( IOException ioException )
		{
			System.err.println("Error al abrir el archivo.");
		}// fin de catch
	}// fin del método guardarEnFichero

	private void recuperarFichero(){
		try// abre el archivo
		{
			entrada = new ObjectInputStream(new FileInputStream( "equipo.ser") );
			equipo=(Equipo) entrada.readObject(); // envía el registro como salida
			if( entrada != null)
				entrada.close();
		}// fin de try
		catch( IOException ioException )
		{
			System.err.println("Error al abrir el archivo.");
		}catch(ClassNotFoundException clException){
			System.err.println("Error al crear la clase");
		}
		// fin de catch
	}// fin del método guardarEnFichero	
}
