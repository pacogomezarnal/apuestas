import java.io.Serializable;

public class Equipo implements Serializable{
	
	//atributos del Equipo
	private String nombreEquipo;
	private int golesFavor;
	private int golesEnContra;
	private int partidosGanados;
	private int partidosPerdidos;

	public Equipo(String nom, int golesF,int golesC,int partidosG,int partidosP) {
		// Inicialización
		nombreEquipo=nom;
		golesFavor=golesF;
		golesEnContra=golesC;
		partidosGanados=partidosG;
		partidosPerdidos=partidosP;
	}
	public Equipo(){
		// Inicialización
		nombreEquipo="";
		golesFavor=0;
		golesEnContra=0;
		partidosGanados=0;
		partidosPerdidos=0;		
	}
	
	//Entrada y salida de atributos
	public void setNombre(String nom){
		nombreEquipo=nom;
	}

	public String getNombre(){
		return nombreEquipo;
	}
	
	public void setGolesFavor(int golesF){
		golesFavor=golesF;
	}

	public int getGolesFavor(){
		return golesFavor;
	}
	
	public void setGolesContra(int golesC){
		golesEnContra=golesC;
	}

	public int getGolesContra(){
		return golesEnContra;
	}
	
	public void setPartidosGanados(int partidosG){
		partidosGanados=partidosG;
	}

	public int getPartidosGanados(){
		return partidosGanados;
	}
	
	public void setPartidosPerdidos(int partidosP){
		partidosPerdidos=partidosP;
	}

	public int getPartidosPerdidos(){
		return partidosPerdidos;
	}
	public String toString()
	{
		return nombreEquipo;
	}
}
