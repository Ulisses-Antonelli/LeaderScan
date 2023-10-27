package Pck_Controller;

import java.sql.SQLException;

import Pck_Dao.DaoUsuario;
import Pck_Model.ModelUsuario;

public class ControllerUsuario {

    private DaoUsuario daoUsuario;

    public ControllerUsuario() {
        this.daoUsuario = new DaoUsuario();
    }

    public void inserirUsuario(String nome, String email, String senha) throws SQLException {
        ModelUsuario usuario = new ModelUsuario();
        usuario.setV02_nome(nome);
        usuario.setV02_email(email);
        usuario.setV02_senha(senha);
        daoUsuario.insertUsuario(usuario);
    }

    public void atualizarUsuario(String nome, String email, String senha) throws SQLException {
        ModelUsuario usuario = new ModelUsuario();
        usuario.setV02_nome(nome);
        usuario.setV02_email(email);
        usuario.setV02_senha(senha);
        daoUsuario.updateUsuario(usuario);
    }

    public void excluirUsuario(int codigo) throws SQLException {
        daoUsuario.deleteUsuario(codigo);
    }
}
