import java.awt.EventQueue;
/*
 * Clase principal que lanza el resto
 */

public class Principal {

	public static void main(String[] args) {
		Liga liga=new Liga();
		VentanaLiga frame = new VentanaLiga(liga);
		frame.setVisible(true);
	}

}
