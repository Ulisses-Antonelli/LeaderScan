package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Pck_Model.ModelProposicao;
import Pck_Persistencia.ConnectionFactory;

public class DaoProposicao {
    private Connection connection;

    public DaoProposicao() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void insertProposicao(ModelProposicao proposicao) throws SQLException {
        String query = "CALL PROC_INSERT_T04(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, proposicao.getV04_titulo());
            preparedStatement.setString(2, proposicao.getV04_descricao());
            preparedStatement.setInt(3, proposicao.getV04_limite_decisao());
            preparedStatement.setString(4, proposicao.getV04_data_criacao());
            preparedStatement.execute();
        }
    }

    public void updateProposicao(ModelProposicao proposicao) throws SQLException {
        String query = "CALL PROC_UPDATE_T04(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, proposicao.getV04_codigo());
            preparedStatement.setString(2, proposicao.getV04_titulo());
            preparedStatement.setString(3, proposicao.getV04_descricao());
            preparedStatement.setInt(4, proposicao.getV04_limite_decisao());
            preparedStatement.setString(5, proposicao.getV04_data_criacao());
            preparedStatement.execute();
        }
    }

    public void deleteProposicao(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T04(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }
}
