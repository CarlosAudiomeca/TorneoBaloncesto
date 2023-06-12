package domain.useCase;

import java.sql.SQLException;

import data.PartidoRemoteDataSource;
import domain.models.Partido;

public class SearchPartidoUseCase {

    PartidoRemoteDataSource conexion;

    public SearchPartidoUseCase() throws SQLException {

        conexion = PartidoRemoteDataSource.getInstance("torneo_baloncesto","root","");

    }

    public Partido execute(int id) throws SQLException {
        Partido partido = null;
        partido=conexion.searchPartido(id);
        return partido;
    }

}
