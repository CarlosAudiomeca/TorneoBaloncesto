package domain.useCase;

import java.sql.SQLException;

import data.PartidoRemoteDataSource;

public class DeletePartidoUseCase {

    PartidoRemoteDataSource conexion;

    public DeletePartidoUseCase() throws SQLException {

        conexion = PartidoRemoteDataSource.getInstance("torneo_baloncesto","root","");

    }

    public void execute(int id) throws SQLException {
        conexion.deletePartido(id);
    }

}
