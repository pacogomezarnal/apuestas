import java.io.Serializable;
import java.util.ArrayList;


public class Liga implements Serializable{
	private int numEquipos;
	private ArrayList<Equipo> equipos=new ArrayList<Equipo>();
	private String nombreLiga;

	public Liga() {
		numEquipos=0;
		nombreLiga="Liga Futbol Española";
	}
	
	public Liga(int numero,String nombre) {
		numEquipos=numero;
		nombreLiga=nombre;
		for (int i=0;i<numEquipos;i++)
		{
			equipos.add(new Equipo());
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
		return equipos.get(posicion);
	}
	public void newEquipo()
	{
		equipos.add(new Equipo());
		numEquipos++;
	}
	public void deleteEquipo(int posicion)
	{
		equipos.remove(posicion);
	}
	
}
