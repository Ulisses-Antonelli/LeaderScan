package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Pck_Model.ModelVotos;
import Pck_Persistencia.ConnectionFactory;

public class DaoVotos {
    private Connection connection;

    public DaoVotos() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void insertVotos(ModelVotos votos) throws SQLException {
        String query = "CALL PROC_INSERT_T08(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setFloat(1, votos.getV08_grau_certeza_individual());
            preparedStatement.setFloat(2, votos.getV08_grau_incerteza_individual());
            preparedStatement.setInt(3, votos.getV08_codigo_T05_Participante());
            preparedStatement.setInt(4, votos.getV08_codigo_T06_Criterio());
            preparedStatement.setInt(5, votos.getV08_codigo_T07_Avaliado());
            preparedStatement.execute();
        }
    }

    public void updateVotos(ModelVotos votos) throws SQLException {
        String query = "CALL PROC_UPDATE_T08(?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, votos.getV08_codigo());
            preparedStatement.setFloat(2, votos.getV08_grau_certeza_individual());
            preparedStatement.setFloat(3, votos.getV08_grau_incerteza_individual());
            preparedStatement.setInt(4, votos.getV08_codigo_T05_Participante());
            preparedStatement.setInt(5, votos.getV08_codigo_T06_Criterio());
            preparedStatement.setInt(6, votos.getV08_codigo_T07_Avaliado());
            preparedStatement.execute();
        }
    }

    public void deleteVotos(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T08(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }
}
