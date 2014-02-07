import java.awt.EventQueue;
/*
 * Clase principal que lanza el resto
 */

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipo frame = new VentanaEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		

	}

}
