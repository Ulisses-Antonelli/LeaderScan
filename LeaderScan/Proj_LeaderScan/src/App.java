import javax.swing.SwingUtilities;

import Pck_View.ViewAssociarGrupoParticipante;
import Pck_View.ViewTelaDefinirPerfil;
import Pck_View.ViewTelaInseriProposicao;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            
            ViewAssociarGrupoParticipante participanteView = new ViewAssociarGrupoParticipante();
            participanteView.setVisible(true);

            ViewTelaInseriProposicao proposicaoView = new ViewTelaInseriProposicao();
            proposicaoView.setVisible(true);
        
            ViewTelaDefinirPerfil perfilView = new ViewTelaDefinirPerfil();
            perfilView.setVisible(true);
        });
    }
}
