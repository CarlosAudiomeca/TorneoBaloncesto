package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.models.Arbitro;
import domain.models.Categoria;

public class ArbitroRemoteDataSource {
		private Connection conexion;
		
		private static ArbitroRemoteDataSource instance = null;
		
		private static final String CLASE="com.mysql.cj.jdbc.Driver";
		
		private ArbitroRemoteDataSource(String url, String user, String password)throws SQLException {
			
			try {
				Class.forName(CLASE);
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/"+url,user,password);
			
		}
		
		public void cerrarConexion()throws SQLException{
			if (conexion!=null && ! conexion.isClosed()) {
				conexion.close();
			}
		}
		
		public static ArbitroRemoteDataSource getInstance(String url, String user, String password) throws SQLException {
			
			if(instance==null) {
				instance= new ArbitroRemoteDataSource(url, user, password);
			}
			
			return instance;
		}
		
		public void insertarArbitro(Arbitro arbitro) throws SQLException{

			 String consulta="INSERT INTO arbitros (id, nombre, apellidos, categoria) VALUES(?,?,?,?)";

			 try {
				 PreparedStatement statement = conexion.prepareStatement(consulta);
				 statement.setInt(1, arbitro.getId());
				 statement.setString(2, arbitro.getNombre());
				 statement.setString(3, arbitro.getApellidos());
				 statement.setString(4,arbitro.getCategoria().name());
				 statement.executeUpdate();
				 statement.close();
			 } catch (SQLException e) {

				 // TODO Auto-generated catch block

				 e.printStackTrace();

			 }

			 }
		
		public void deleteArbitro (int id) {
			String consulta="DELETE FROM arbitros WHERE id="+id;

			 try {
				 PreparedStatement statement = conexion.prepareStatement(consulta);
			 	statement.execute();
			 	statement.close();
			 } catch (SQLException e) {
			 }
		}
		
		public Arbitro searchArbitro (int id) {
			Arbitro arbitro = new Arbitro();
			String consulta="SELECT * FROM arbitros WHERE id="+id;

			 try {
				PreparedStatement statement = conexion.prepareStatement(consulta);
			 	ResultSet resultSet = statement.executeQuery();
			 	
			 	resultSet.next();
			 	arbitro.setId(resultSet.getInt("id"));
			 	arbitro.setNombre(resultSet.getString("nombre"));
			 	arbitro.setApellidos(resultSet.getString("apellidos"));
			 	arbitro.setCategoria(Categoria.valueOf(resultSet.getString("categoria")));
			 	statement.close();
			 	resultSet.close();
			 } catch (SQLException e) {
			 }
			 return arbitro;
		}
	}
