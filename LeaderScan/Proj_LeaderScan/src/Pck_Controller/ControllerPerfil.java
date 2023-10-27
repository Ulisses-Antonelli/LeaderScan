package Pck_Controller;

import java.sql.SQLException;
import java.util.List;

import Pck_Dao.DaoPerfil;
import Pck_Model.ModelPerfil;

public class ControllerPerfil {

    private DaoPerfil daoPerfil;

    public ControllerPerfil() {
        this.daoPerfil = new DaoPerfil();
    }

    public List<List<Object>> selectPerfis() throws SQLException{
        return daoPerfil.selectPerfis();
    }

    public void inserirPerfil(String privilegio, String permissao_prop, String criacao_prop, int peso_perfil)
            throws SQLException {
        ModelPerfil perfil = new ModelPerfil();
        perfil.setV03_privilegio(privilegio);
        perfil.setV03_permissao_prop(permissao_prop);
        perfil.setV03_criacao_prop(criacao_prop);
        perfil.setV03_peso_perfil(peso_perfil);

        daoPerfil.insertPerfil(perfil);
    }

    public void atualizarPerfil(String privilegio, String permissao_prop, String criacao_prop, int peso_perfil)
            throws SQLException {
        ModelPerfil perfil = new ModelPerfil();
        perfil.setV03_privilegio(privilegio);
        perfil.setV03_permissao_prop(permissao_prop);
        perfil.setV03_criacao_prop(criacao_prop);
        perfil.setV03_peso_perfil(peso_perfil);

        daoPerfil.updatePerfil(perfil);
    }

    public void excluirPerfil(int codigo) throws SQLException {
        daoPerfil.deletePerfil(codigo);
    }
}
