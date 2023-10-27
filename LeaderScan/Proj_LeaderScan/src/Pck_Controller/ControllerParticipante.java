package Pck_Controller;

import java.sql.SQLException;

import Pck_Dao.DaoParticipante;
import Pck_Model.ModelParticipante;

public class ControllerParticipante {

    private DaoParticipante daoParticipante;

    public ControllerParticipante() {
        this.daoParticipante = new DaoParticipante();
    }

    public void inserirParticipante(String grupo, int codigoUsuario, int codigoPerfil, int codigoProposicao)
            throws SQLException {
        ModelParticipante participante = new ModelParticipante();
        participante.setV05_grupo(grupo);
        participante.setV05_codigo_T02_Usuario(codigoUsuario);
        participante.setV05_codigo_T03_Perfil(codigoPerfil);
        participante.setV05_codigo_T04_Proposicao(codigoProposicao);
        daoParticipante.insertParticipante(participante);
    }

    public void inserirGrupoParticipante(String grupo) throws SQLException {
        ModelParticipante participante = new ModelParticipante();
        participante.setV05_grupo(grupo);
        //System.out.println(grupo);
        daoParticipante.insertParticipante(participante);
    }

    public void atualizarParticipante(String grupo, int codigoUsuario, int codigoPerfil, int codigoProposicao)
            throws SQLException {
        ModelParticipante participante = new ModelParticipante();
        participante.setV05_grupo(grupo);
        participante.setV05_codigo_T02_Usuario(codigoUsuario);
        participante.setV05_codigo_T03_Perfil(codigoPerfil);
        participante.setV05_codigo_T04_Proposicao(codigoProposicao);
        daoParticipante.updateParticipante(participante);
    }

    public void excluirParticipante(int codigo) throws SQLException {
        daoParticipante.deleteParticipante(codigo);
    }
}
