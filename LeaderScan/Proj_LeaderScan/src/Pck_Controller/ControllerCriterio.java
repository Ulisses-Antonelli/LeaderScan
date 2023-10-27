package Pck_Controller;

import java.sql.SQLException;

import Pck_Dao.DaoCriterio;
import Pck_Model.ModelCriterio;

public class ControllerCriterio {

    private DaoCriterio daoCriterio;

    public ControllerCriterio() {
        this.daoCriterio = new DaoCriterio();
    }

    public void inserirCriterio(String descricao, int peso, int codigoProposicao) throws SQLException {
        ModelCriterio criterio = new ModelCriterio();
        criterio.setV06_descricao(descricao);
        criterio.setV06_peso(peso);
        criterio.setV06_codigo_T04_Proposicao(codigoProposicao);
        daoCriterio.insertCriterio(criterio);
    }

    public void atualizarCriterio(String descricao, int peso, int codigoProposicao) throws SQLException {
        ModelCriterio criterio = new ModelCriterio();
        criterio.setV06_descricao(descricao);
        criterio.setV06_peso(peso);
        criterio.setV06_codigo_T04_Proposicao(codigoProposicao);
        daoCriterio.updateCriterio(criterio);
    }

    public void excluirCriterio(int codigo) throws SQLException {
        daoCriterio.deleteCriterio(codigo);
    }
}
