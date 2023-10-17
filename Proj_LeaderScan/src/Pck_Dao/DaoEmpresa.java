package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Pck_Model.ModelEmpresa;
import Pck_Persistencia.ConnectionFactory;

public class DaoEmpresa {
    private Connection connection;

    public DaoEmpresa() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void insertEmpresa(ModelEmpresa empresa) throws SQLException {
        String query = "CALL PROC_INSERT_T01(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, empresa.getV01_nome());
            preparedStatement.execute();
        }
    }

    public void updateEmpresa(ModelEmpresa empresa) throws SQLException {
        String query = "CALL PROC_UPDATE_T01(?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, empresa.getV01_codigo());
            preparedStatement.setString(2, empresa.getV01_nome());
            preparedStatement.execute();
        }
    }

    public void deleteEmpresa(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T01(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }
}
