package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import domain.models.Jugador;

public class JugadorRemoteDataSource {
	private Connection conexion;
	
	private static JugadorRemoteDataSource instance = null;
	
	private static final String CLASE="com.mysql.cj.jdbc.Driver";
	
	private JugadorRemoteDataSource(String url, String user, String password)throws SQLException {
		
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
	
	public static JugadorRemoteDataSource getInstance(String url, String user, String password) throws SQLException {
		
		if(instance==null) {
			instance= new JugadorRemoteDataSource(url, user, password);
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
	
	public void deleteJugador (int id) {
		String consulta="DELETE FROM jugador WHERE id="+id;

		 try {
			 PreparedStatement statement = conexion.prepareStatement(consulta);
		 	statement.execute();
		 	statement.close();
		 } catch (SQLException e) {
		 }
	}
	
	public Jugador searchJugador (int id) {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		String consulta="SELECT * FROM jugador WHERE id="+id;

		 try {
			PreparedStatement statement = conexion.prepareStatement(consulta);
		 	ResultSet resultSet = statement.executeQuery();
		 	
		 	resultSet.next();
		 	jugador.setId(resultSet.getInt("id"));
		 	jugador.setNombre(resultSet.getString("nombre"));
		 	jugador.setApellidos(resultSet.getString("apellidos"));
		 	jugador.setFechaNacimiento(LocalDate.parse(resultSet.getString("fecha_nacimiento"),formater));
		 	//jugador.setEquipo(searchEquipoUseCase(resultSet.getInt("equipo_id")));
		 	statement.close();
		 	resultSet.close();
		 } catch (SQLException e) {
		 }
		 return jugador;
	}
}
