package Pck_Controller;

import java.sql.SQLException;

import Pck_Dao.DaoProposicao;
import Pck_Model.ModelProposicao;

public class ControllerProposicao {

    private DaoProposicao daoProposicao;

    public ControllerProposicao() {
        this.daoProposicao = new DaoProposicao();
    }

    public void inserirProposicao(String titulo, String descricao, int limite_decisao, String data_criacao)
            throws SQLException {
        ModelProposicao proposicao = new ModelProposicao();
        proposicao.setV04_titulo(titulo);
        proposicao.setV04_descricao(descricao);
        proposicao.setV04_limite_decisao(limite_decisao);
        proposicao.setV04_data_criacao(data_criacao);

        daoProposicao.insertProposicao(proposicao);
    }

    public void inserirProposicao(String titulo, String descricao, String data_criacao)
            throws SQLException {
        ModelProposicao proposicao = new ModelProposicao();
        proposicao.setV04_titulo(titulo);
        proposicao.setV04_descricao(descricao);
        proposicao.setV04_data_criacao(data_criacao);

        daoProposicao.insertProposicao(proposicao);
    }

    public void atualizarProposicao(String titulo, String descricao, int limite_decisao, String data_criacao)
            throws SQLException {
        ModelProposicao proposicao = new ModelProposicao();
        proposicao.setV04_titulo(titulo);
        proposicao.setV04_descricao(descricao);
        proposicao.setV04_limite_decisao(limite_decisao);
        proposicao.setV04_data_criacao(data_criacao);

        daoProposicao.updateProposicao(proposicao);
    }

    public void excluirProposicao(int condigo) throws SQLException {
        daoProposicao.deleteProposicao(condigo);
    }
}
