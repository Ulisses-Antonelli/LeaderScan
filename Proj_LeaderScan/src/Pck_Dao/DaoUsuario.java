package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Pck_Model.ModelUsuario;
import Pck_Persistencia.ConnectionFactory;

public class DaoUsuario {
    private Connection connection;

    public DaoUsuario() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void insertUsuario(ModelUsuario usuario) throws SQLException {
        String query = "CALL PROC_INSERT_T02(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getV02_nome());
            preparedStatement.setString(2, usuario.getV02_email());
            preparedStatement.setString(3, usuario.getV02_senha());
            preparedStatement.execute();
        }
    }

    public void updateUsuario(ModelUsuario usuario) throws SQLException {
        String query = "CALL PROC_UPDATE_T02(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, usuario.getV02_codigo());
            preparedStatement.setString(2, usuario.getV02_nome());
            preparedStatement.setString(3, usuario.getV02_email());
            preparedStatement.setString(4, usuario.getV02_senha());
            preparedStatement.execute();
        }
    }

    public void deleteUsuario(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T02(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }
}
