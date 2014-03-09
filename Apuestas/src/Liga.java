import java.io.Serializable;


public class Liga implements Serializable{
	private int numEquipos;
	private Equipo equipos[];
	private String nombreLiga;

	public Liga() {
		numEquipos=20;
		equipos=new Equipo[numEquipos];
		nombreLiga="Liga Futbol Española";
		for (int i=0;i<numEquipos;i++)
		{
			equipos[i]=new Equipo();
		}
	}
	
	public Liga(int numero,String nombre) {
		numEquipos=numero;
		nombreLiga=nombre;
		equipos=new Equipo[numEquipos];
		for (int i=0;i<numEquipos;i++)
		{
			equipos[i]=new Equipo();
		}
	}
	
	public void setnombreLiga(String nombre){
		nombreLiga=nombre;
	}
	
	public String getnombreLiga(){
		return nombreLiga;
	}

	public int getNumEquipos(){
		return numEquipos;
	}
	
	public Equipo getEquipo(int posicion)
	{
		return equipos[posicion];
	}
	public void setEquipo(Equipo equipo,int posicion)
	{
		equipos[posicion]=equipo;
	}
	
}
