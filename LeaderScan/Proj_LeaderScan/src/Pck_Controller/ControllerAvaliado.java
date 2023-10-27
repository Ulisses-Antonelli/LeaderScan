package Pck_Controller;

import java.sql.SQLException;

import Pck_Dao.DaoAvaliado;
import Pck_Model.ModelAvaliado;

public class ControllerAvaliado {

    private DaoAvaliado daoAvaliado;

    public ControllerAvaliado() {
        this.daoAvaliado = new DaoAvaliado();
    }

    public void inserirAvaliado(String nome, float grauCertezaResultante, float grauIncertezaResultante,
            int codigoProposicao) throws SQLException {
        ModelAvaliado avaliado = new ModelAvaliado();
        avaliado.setV07_nome(nome);
        avaliado.setV07_grau_certeza_resultante(grauCertezaResultante);
        avaliado.setV07_grau_incerteza_resultante(grauIncertezaResultante);
        avaliado.setV07_codigo_T04_Proposicao(codigoProposicao);
        daoAvaliado.insertAvaliado(avaliado);
    }

    public void atualizarAvaliado(String nome, float grauCertezaResultante, float grauIncertezaResultante,
            int codigoProposicao) throws SQLException {
        ModelAvaliado avaliado = new ModelAvaliado();
        avaliado.setV07_nome(nome);
        avaliado.setV07_grau_certeza_resultante(grauCertezaResultante);
        avaliado.setV07_grau_incerteza_resultante(grauIncertezaResultante);
        avaliado.setV07_codigo_T04_Proposicao(codigoProposicao);
        daoAvaliado.updateAvaliado(avaliado);
    }

    public void excluirAvaliado(int codigo) throws SQLException {
        daoAvaliado.deleteAvaliado(codigo);
    }

}
