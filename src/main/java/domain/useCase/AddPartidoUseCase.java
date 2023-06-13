package domain.useCase;

import data.PartidoRemoteDataSource;
import domain.models.Partido;

import java.sql.SQLException;

public class AddPartidoUseCase {
    PartidoRemoteDataSource conexion;

    public AddPartidoUseCase() throws SQLException{
        conexion = PartidoRemoteDataSource.getInstance("torneo_baloncesto","root","");
    }

    public void execute(Partido partido){
        try {
            conexion.insertarPartido(partido);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
