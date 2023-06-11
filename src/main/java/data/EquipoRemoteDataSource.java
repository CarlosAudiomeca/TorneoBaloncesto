package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.models.Categoria;
import domain.models.Equipo;

public class EquipoRemoteDataSource {
	private Connection conexion;
	
	private static EquipoRemoteDataSource instance = null;
	
	private static final String CLASE="com.mysql.cj.jdbc.Driver";
	
	private EquipoRemoteDataSource(String url, String user, String password)throws SQLException {
		
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
	
	public static EquipoRemoteDataSource getInstance(String url, String user, String password) throws SQLException {
		
		if(instance==null) {
			instance= new EquipoRemoteDataSource(url, user, password);
		}
		
		return instance;
	}
	
	public void insertarEquipo(Equipo equipo) throws SQLException{

		 String consulta="INSERT INTO equipos (id, nombre, categoria) VALUES(?,?,?)";

		 try {
			 PreparedStatement statement = conexion.prepareStatement(consulta);
			 statement.setInt(1, equipo.getId());
			 statement.setString(2, equipo.getNombre());
			 statement.setString(3,equipo.getCategoria().name());
			 statement.executeUpdate();
			 statement.close();
		 } catch (SQLException e) {

			 // TODO Auto-generated catch block

			 e.printStackTrace();

		 }

		 }
	
	public void deleteEquipo (int id) {
		String consulta="DELETE FROM equipos WHERE id="+id;

		 try {
			 PreparedStatement statement = conexion.prepareStatement(consulta);
		 	statement.execute();
		 	statement.close();
		 } catch (SQLException e) {
		 }
	}
	
	public Equipo searchEquipo (int id) {
		Equipo equipo = new Equipo();
		String consulta="SELECT * FROM equipos WHERE id="+id;

		 try {
			PreparedStatement statement = conexion.prepareStatement(consulta);
		 	ResultSet resultSet = statement.executeQuery();
		 	
		 	resultSet.next();
		 	equipo.setId(resultSet.getInt("id"));
		 	equipo.setNombre(resultSet.getString("nombre"));
		 	equipo.setCategoria(Categoria.valueOf(resultSet.getString("categoria")));
		 	statement.close();
		 	resultSet.close();
		 } catch (SQLException e) {
		 }
		 return equipo;
	}
}
