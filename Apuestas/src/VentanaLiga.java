import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private Liga liga;
	private Equipo equipo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private VentanaEquipo frameEquipo;
	private VentanaLiga v;

	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga ligaModificar) {
		
		liga=ligaModificar;
		v=this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Liga");
		lblNewLabel.setBounds(10, 21, 193, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 43, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNmeroDeEquipos = new JLabel("N\u00FAmero de equipos");
		lblNmeroDeEquipos.setBounds(164, 21, 193, 14);
		contentPane.add(lblNmeroDeEquipos);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(164, 43, 86, 20);
		//Anyadimos numero de equipos
		textField_1.setText(String.valueOf(liga.getNumEquipos()));
		contentPane.add(textField_1);
		
		JLabel lblEquipoAModificar = new JLabel("Equipo a modificar");
		lblEquipoAModificar.setBounds(10, 92, 193, 14);
		contentPane.add(lblEquipoAModificar);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 117, 86, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEquipo = new VentanaEquipo(liga.getEquipo(Integer.valueOf(textField_2.getText())));
				frameEquipo.setVisible(true);
				frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(7, 153, 89, 23);
		contentPane.add(btnNewButton);
	}
}
