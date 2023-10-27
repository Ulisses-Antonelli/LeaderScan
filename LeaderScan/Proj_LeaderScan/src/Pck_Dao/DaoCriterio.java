package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Pck_Model.ModelCriterio;
import Pck_Persistencia.ConnectionFactory;

public class DaoCriterio {
    private Connection connection;

    public DaoCriterio() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void insertCriterio(ModelCriterio criterio) throws SQLException {
        String query = "CALL PROC_INSERT_T06(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, criterio.getV06_descricao());
            preparedStatement.setInt(2, criterio.getV06_peso());
            preparedStatement.setInt(3, criterio.getV06_codigo_T04_Proposicao());
            preparedStatement.execute();
        }
    }

    public void updateCriterio(ModelCriterio criterio) throws SQLException {
        String query = "CALL PROC_UPDATE_T06(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, criterio.getV06_codigo());
            preparedStatement.setString(2, criterio.getV06_descricao());
            preparedStatement.setInt(3, criterio.getV06_peso());
            preparedStatement.setInt(4, criterio.getV06_codigo_T04_Proposicao());
            preparedStatement.execute();
        }
    }

    public void deleteCriterio(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T06(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }
}
