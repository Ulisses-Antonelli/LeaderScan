package Pck_Controller;

import java.sql.SQLException;

import Pck_Dao.DaoEmpresa;
import Pck_Model.ModelEmpresa;

public class ControllerEmpresa {

    private DaoEmpresa daoEmpresa;

    public ControllerEmpresa() {
        this.daoEmpresa = new DaoEmpresa();
    }

    public void inserirEmpresa(String nome) throws SQLException {
        ModelEmpresa empresa = new ModelEmpresa();
        empresa.setV01_nome(nome);
        daoEmpresa.insertEmpresa(empresa);
    }

    public void atualizarEmpresa(String nome) throws SQLException {
        ModelEmpresa empresa = new ModelEmpresa();
        empresa.setV01_nome(nome);
        daoEmpresa.updateEmpresa(empresa);
    }

    public void excluirEmpresa(int codigo) throws SQLException {
        daoEmpresa.deleteEmpresa(codigo);
    }  
}
