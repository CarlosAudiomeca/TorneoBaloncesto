package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import domain.models.Pista;
import domain.models.Pista.Ubicacion;

public class PistaRemoteDataSource {
private Connection conexion;
	
	private static PistaRemoteDataSource instance = null;
	
	private static final String CLASE="com.mysql.cj.jdbc.Driver";
	
	private PistaRemoteDataSource(String url, String user, String password)throws SQLException {
		
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
	
	public static PistaRemoteDataSource getInstance(String url, String user, String password) throws SQLException {
		
		if(instance==null) {
			instance= new PistaRemoteDataSource(url, user, password);
		}
		
		return instance;
	}
	
	public void insertarPista(Pista pista) throws SQLException{

		 String consulta="INSERT INTO pista (id, nombre, ubicacion) VALUES(?,?,?)";

		 try {
		 PreparedStatement statement = conexion.prepareStatement(consulta);
		 statement.setInt(1, pista.getId());
		 statement.setString(2, pista.getNombre());
		 //supongo que seria un String asi que lo pasare a String asi que esa sintaxis hace que pongamos el nombre
		 String ladoPista = pista.getUbicacion().name();
		 statement.setString(3, ladoPista);
		 statement.executeUpdate();
		 statement.close();
		 } catch (SQLException e) {

		 // TODO Auto-generated catch block

		 e.printStackTrace();

		 }

		 }
	
	public void deletePista (int id) {
		String consulta="DELETE FROM pista WHERE id="+id;

		 try {
			 PreparedStatement statement = conexion.prepareStatement(consulta);
		 	statement.execute();
		 	statement.close();
		 } catch (SQLException e) {
		 }
	}
	
	public Pista searchPista (int id) {
		
		Pista pista = new Pista();
		String consulta="SELECT * FROM pista WHERE id="+id;

		 try {
			PreparedStatement statement = conexion.prepareStatement(consulta);
		 	ResultSet resultSet = statement.executeQuery();
		 	
		 	resultSet.next();
		 	pista.setId(resultSet.getInt("id"));
		 	pista.setNombre(resultSet.getString("nombre"));
		 	Ubicacion ubicacion = Ubicacion.valueOf( resultSet.getString("ubicacion"));
		 	pista.setUbicacion(ubicacion);
		 	
		 	statement.close();
		 	resultSet.close();
		 } catch (SQLException e) {
		 }
		 return pista;
	}
}
