import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;


public class Liga implements Serializable{
	private int numEquipos;
	private ArrayList<Equipo> equipos=new ArrayList<Equipo>();
	private String nombreLiga;
	private int idLiga;
	
	//DB
	private Connection conexion = null; //maneja la conexión
	private Statement instruccion = null;// instrucción de consulta
	private ResultSet conjuntoResultados = null;// maneja los resultados

	public Liga(Connection conexion) {
		numEquipos=0;
		nombreLiga="Liga Futbol Española";
		this.conexion=conexion;
		leerLiga();
	}
	
	public Liga(Connection conexion,int numero,String nombre) {
		numEquipos=numero;
		nombreLiga=nombre;
		this.conexion=conexion;
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
	public void newEquipoDB(Equipo equipo)
	{
		try{
			// consulta la base de datos
			instruccion = (Statement) conexion.createStatement();
			// insercion en base de datos
			String sql_inst="INSERT INTO equipos ( idLiga,nombreEquipo,golesFavor,golesEnContra,partidosGanados,partidosPerdidos )";
			sql_inst=sql_inst+ "VALUES( "+idLiga+",'"+equipo.getNombre()+"',"+equipo.getGolesFavor()+","+equipo.getGolesContra()+","+equipo.getPartidosGanados()+","+equipo.getPartidosPerdidos()+")";
			System.out.println(sql_inst);
			instruccion.executeUpdate(sql_inst);
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin
	}
	public void deleteEquipo(int posicion)
	{
		equipos.remove(posicion);
	}
	
	private void leerLiga(){
		try{
			// consulta la base de datos
			instruccion = (Statement) conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery("SELECT idLiga,nombre,numEquipos FROM ligas LIMIT 1");
			conjuntoResultados.next();
			// Almacenar liga
			this.idLiga=(int)conjuntoResultados.getObject("idLiga");
			this.nombreLiga=(String)conjuntoResultados.getObject("nombre");
			this.numEquipos=(int)conjuntoResultados.getObject("numEquipos");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin
	}
	
}
