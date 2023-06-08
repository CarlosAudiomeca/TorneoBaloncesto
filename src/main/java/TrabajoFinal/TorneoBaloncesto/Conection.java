package TrabajoFinal.TorneoBaloncesto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class Conection {
	private Connection conexion;
	
	private static Conection instance = null;
	
	private static final String CLASE="com.mysql.cj.jdbc.Driver";
	
	private Conection(String url, String user, String password)throws SQLException {
		
		try {
			Class.forName(CLASE);
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+url,user,password);
		
	}
	
	public void cerrarConexion()throws SQLException{
		if (conexion!=null && ! conexion.isClosed()) {
			conexion.close();
		}
	}
	
	public static Conection getInstance(String url, String user, String password) throws SQLException {
		
		if(instance==null) {
			instance= new Conection(url, user, password);
		}
		
		return instance;
	}
	
	public void insertarjugador(Jugador jugador) throws SQLException{

		 String consulta="INSERT INTO jugador (id, nombre, apellidos, fecha_nacimiento, equipo_id) VALUES(?,?,?,?,?)";

		 try {

		 PreparedStatement statement = conexion.prepareStatement(consulta);

		 statement.setInt(1, jugador.getId());

		 statement.setString(2, jugador.getNombre());

		 statement.setString(3, jugador.getApellidos());

		 DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String fecha = jugador.getFechaNacimiento().format(formateador);
		 statement.setString(4, fecha);
		 
		 statement.setInt(5,  jugador.getEquipo().getId());
		 
		 

		 statement.executeUpdate();

		 statement.close();


		 

		 } catch (SQLException e) {

		 // TODO Auto-generated catch block

		 e.printStackTrace();

		 }

		 }
	
}
