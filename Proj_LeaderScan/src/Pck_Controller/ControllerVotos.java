package Pck_Controller;

import java.sql.SQLException;

import Pck_Dao.DaoVotos;
import Pck_Model.ModelVotos;

public class ControllerVotos {

    private DaoVotos daoVotos;

    public ControllerVotos() {
        this.daoVotos = new DaoVotos();
    }

    public void inserirVotos(float gci, float gii, int cT05P, int cT06C, int cT07A) throws SQLException {
        ModelVotos modelVotos = new ModelVotos();
        modelVotos.setV08_grau_certeza_individual(gci);
        modelVotos.setV08_grau_incerteza_individual(gii);
        modelVotos.setV08_codigo_T05_Participante(cT05P);
        modelVotos.setV08_codigo_T06_Criterio(cT06C);
        modelVotos.setV08_codigo_T07_Avaliado(cT07A);

        daoVotos.insertVotos(modelVotos);
    }

    public void atualizarVotos(float gci, float gii, int cT05P, int cT06C, int cT07A) throws SQLException {
        ModelVotos modelVotos = new ModelVotos();
        modelVotos.setV08_grau_certeza_individual(gci);
        modelVotos.setV08_grau_incerteza_individual(gii);
        modelVotos.setV08_codigo_T05_Participante(cT05P);
        modelVotos.setV08_codigo_T06_Criterio(cT06C);
        modelVotos.setV08_codigo_T07_Avaliado(cT07A);

        daoVotos.updateVotos(modelVotos);
    }

    public void excluirVotos(int codigo) throws SQLException {
        daoVotos.deleteVotos(codigo);
    }
}
