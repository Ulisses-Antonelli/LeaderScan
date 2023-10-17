import javax.swing.SwingUtilities;

import Pck_View.ViewTelaInseriProposicao;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            ViewTelaInseriProposicao proposicaoView = new ViewTelaInseriProposicao();
            proposicaoView.setVisible(true);
        });
    }
}
