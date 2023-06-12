package data;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import domain.models.Partido;
import domain.useCase.SearchEquipoUseCase;
import domain.useCase.SearchPistaUseCase;

public class PartidoRemoteDataSource {
    private Connection conexion;

    private static PartidoRemoteDataSource instance = null;

    private static final String CLASE="com.mysql.cj.jdbc.Driver";

    private PartidoRemoteDataSource(String url, String user, String password)throws SQLException {

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

    public static PartidoRemoteDataSource getInstance(String url, String user, String password) throws SQLException {

        if(instance==null) {
            instance= new PartidoRemoteDataSource(url, user, password);
        }

        return instance;
    }

    public void insertarPartido(Partido partido) throws SQLException{

        String consulta="INSERT INTO partido (id, hora, pista_id, equipo1_id, equipo2_id, arbitro_id, resultado) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, partido.getId());
            SimpleDateFormat formato = new SimpleDateFormat("HH:mm");

//            String tiempo = formato.format(partido.getHora());
//            statement.setString(2, tiempo);
            statement.setTime(2, partido.getHora());
            statement.setInt(3, partido.getPista().getId());
            statement.setInt(4, partido.getEquipo1().getId());
            statement.setInt(5, partido.getEquipo1().getId());
            statement.setInt(6,  partido.getArbitro().getId());
            statement.setString(7, partido.getResultado());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    public void deletePartido (int id) {
        String consulta="DELETE FROM partido WHERE id="+id;

        try {
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
        }
    }

    public Partido searchPartido (int id) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Partido partido = new Partido();
        String consulta="SELECT * FROM partido WHERE id="+id;

        try {
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            partido.setId(resultSet.getInt("id"));
            partido.setHora(resultSet.getTime("hora"));
            SearchPistaUseCase searchPistaUseCase = new SearchPistaUseCase();
            partido.setPista(searchPistaUseCase.execute(resultSet.getInt("pista_id")));
            SearchEquipoUseCase searchEquipoUseCase = new SearchEquipoUseCase();
            partido.setEquipo1(searchEquipoUseCase.execute(resultSet.getInt("equipo1_id")));
            partido.setEquipo2(searchEquipoUseCase.execute(resultSet.getInt("equipo2_id")));
            //arbitro, esperando a Pablo
            partido.setResultado(resultSet.getString("resultado"));
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
        }
        return partido;
    }
}
