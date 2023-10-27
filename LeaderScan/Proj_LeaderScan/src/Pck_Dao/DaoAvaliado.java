package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Pck_Model.ModelAvaliado;
import Pck_Persistencia.ConnectionFactory;

public class DaoAvaliado {
    private Connection connection;

    public DaoAvaliado() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void insertAvaliado(ModelAvaliado avaliado) throws SQLException {
        String query = "CALL PROC_INSERT_T07(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, avaliado.getV07_nome());
            preparedStatement.setFloat(2, avaliado.getV07_grau_certeza_resultante());
            preparedStatement.setFloat(3, avaliado.getV07_grau_incerteza_resultante());
            preparedStatement.setInt(4, avaliado.getV07_codigo_T04_Proposicao());
            preparedStatement.execute();
        }
    }

    public void updateAvaliado(ModelAvaliado avaliado) throws SQLException {
        String query = "CALL PROC_UPDATE_T07(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, avaliado.getV07_codigo());
            preparedStatement.setString(2, avaliado.getV07_nome());
            preparedStatement.setFloat(3, avaliado.getV07_grau_certeza_resultante());
            preparedStatement.setFloat(4, avaliado.getV07_grau_incerteza_resultante());
            preparedStatement.setInt(5, avaliado.getV07_codigo_T04_Proposicao());
            preparedStatement.execute();
        }
    }

    public void deleteAvaliado(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T07(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }
}
