package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Pck_Model.ModelParticipante;
import Pck_Persistencia.ConnectionFactory;

public class DaoParticipante {
    private Connection connection;

    public DaoParticipante() {
         this.connection = ConnectionFactory.getConnection();
    }

    public void insertParticipante(ModelParticipante participante) throws SQLException {
        String query = "CALL PROC_INSERT_T05(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, participante.getV05_grupo());
            preparedStatement.setInt(2, participante.getV05_codigo_T02_Usuario());
            preparedStatement.setInt(3, participante.getV05_codigo_T03_Perfil());
            preparedStatement.setInt(4, participante.getV05_codigo_T04_Proposicao());
            preparedStatement.execute();
        }
    }

    public void updateParticipante(ModelParticipante participante) throws SQLException {
        String query = "CALL PROC_UPDATE_T05(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, participante.getV05_codigo());
            preparedStatement.setString(2, participante.getV05_grupo());
            preparedStatement.setInt(3, participante.getV05_codigo_T02_Usuario());
            preparedStatement.setInt(4, participante.getV05_codigo_T03_Perfil());
            preparedStatement.setInt(5, participante.getV05_codigo_T04_Proposicao());
            preparedStatement.execute();
        }
    }

    public void deleteParticipante(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T05(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }
}
