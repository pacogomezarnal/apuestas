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
import javax.swing.JComboBox;


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private Liga liga;
	private VentanaLiga vLiga;
	private Equipo equipo;
	private JTextField textField;
	private JTextField textField_1;
	private VentanaEquipo frameEquipo;
	private JComboBox<Equipo> comboBox;

	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga ligaModificar) {
		
		liga=ligaModificar;
		vLiga=this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Liga");
		lblNewLabel.setBounds(10, 21, 193, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 43, 235, 20);
		textField.setText(liga.getnombreLiga());
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNmeroDeEquipos = new JLabel("N\u00FAmero de equipos");
		lblNmeroDeEquipos.setBounds(301, 21, 100, 14);
		contentPane.add(lblNmeroDeEquipos);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(315, 43, 86, 20);
		//Anyadimos numero de equipos
		textField_1.setText(String.valueOf(liga.getNumEquipos()));
		contentPane.add(textField_1);
		
		JLabel lblEquipoAModificar = new JLabel("Equipos");
		lblEquipoAModificar.setBounds(10, 92, 193, 14);
		contentPane.add(lblEquipoAModificar);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEquipoWindow(liga.getEquipo(comboBox.getSelectedIndex()),true);
				//frameEquipo = new VentanaEquipo(liga.getEquipo(Integer.valueOf(textField_2.getText())));
				//frameEquipo.setVisible(true);
				//frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(112, 162, 89, 23);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox<Equipo>();
		comboBox.setBounds(10, 117, 193, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				liga.newEquipo();
				System.out.println(liga.getNumEquipos()-1);
				openEquipoWindow(liga.getEquipo(liga.getNumEquipos()-1),false);
			}
		});
		btnNewButton_1.setBounds(10, 162, 41, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("-");
		button.setBounds(61, 162, 41, 23);
		contentPane.add(button);
	}
	
	private void openEquipoWindow(Equipo equipo,boolean modifica)
	{
		frameEquipo = new VentanaEquipo(equipo,this.comboBox,modifica,this.liga);
		frameEquipo.setVisible(true);
		frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
