package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Pck_Model.ModelPerfil;
import Pck_Persistencia.ConnectionFactory;

public class DaoPerfil {
    private Connection connection;

    public DaoPerfil() {
        this.connection = ConnectionFactory.getConnection();
    }

    public List<List<Object>> selectPerfis() throws SQLException {
        String query = "SELECT * FROM T03_perfil";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ArrayList<List<Object>> retorno = new ArrayList<>();
            ResultSet rs;

            rs = preparedStatement.executeQuery();
            
            
            while(rs.next()){
                int codigo              = rs.getInt("A03_codigo");
                String nome_perfil      = rs.getString("A03_nome_perfil");
                Boolean pms_criar       = rs.getBoolean("A03_pms_criar_prop");
                Boolean pms_resp        = rs.getBoolean("A03_pms_responder_prop");
                Float peso              = rs.getFloat("A03_peso_perfil");

                ArrayList<Object> list = new ArrayList<>(Arrays.asList(codigo, nome_perfil, pms_criar, pms_resp, peso));
                
                retorno.add(list);
            }

            return retorno;
        }
    }

    public void insertPerfil(ModelPerfil perfil) throws SQLException {
        String query = "CALL PROC_INSERT_T03(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, perfil.getV03_privilegio());
            preparedStatement.setString(2, perfil.getV03_permissao_prop());
            preparedStatement.setString(3, perfil.getV03_criacao_prop());
            preparedStatement.setInt(4, perfil.getV03_peso_perfil());
            preparedStatement.execute();
        }
    }

    public void updatePerfil(ModelPerfil perfil) throws SQLException {
        String query = "CALL PROC_UPDATE_T03(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, perfil.getV03_codigo());
            preparedStatement.setString(2, perfil.getV03_privilegio());
            preparedStatement.setString(3, perfil.getV03_permissao_prop());
            preparedStatement.setString(4, perfil.getV03_criacao_prop());
            preparedStatement.setInt(5, perfil.getV03_peso_perfil());
            preparedStatement.execute();
        }
    }

    public void deletePerfil(int codigo) throws SQLException {
        String query = "CALL PROC_DELETE_T03(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        }
    }

}
