package Pck_View;

import Pck_Controller.ControllerProposicao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

public class ViewTelaInseriProposicao extends JFrame implements ActionListener {

    private JLabel projectNameLabel;
    private JLabel proposicaoLabel;
    private JLabel tituloLabel;
    private JLabel descricaoLabel;
    private JLabel dataCriacaoLabel;

    private JTextField tituloTextField;
    private JTextArea descricaoTextArea;
    private JTextField dataCriacaoTextField;

    private JButton saveButton;

    private ControllerProposicao controllerProposicao = new ControllerProposicao();

    public ViewTelaInseriProposicao() {

        setTitle("Criação de Proposição - LeaderScan");
        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        projectNameLabel = new JLabel("LeaderScan");
        projectNameLabel.setBounds(10, 10, 100, 20);

        proposicaoLabel = new JLabel("Proposição");
        proposicaoLabel.setBounds(10, 40, 100, 20);

        tituloLabel = new JLabel("Título da Proposição");
        tituloLabel.setBounds(10, 70, 150, 20);

        tituloTextField = new JTextField();
        tituloTextField.setBounds(170, 70, 600, 20);

        descricaoLabel = new JLabel("Descrição da Proposição");
        descricaoLabel.setBounds(10, 100, 150, 20);

        descricaoTextArea = new JTextArea();
        descricaoTextArea.setBounds(170, 100, 600, 75);

        dataCriacaoLabel = new JLabel("Data de Criação");
        dataCriacaoLabel.setBounds(10, 220, 150, 20);

        dataCriacaoTextField = new JTextField();
        dataCriacaoTextField.setBounds(170, 220, 600, 20);

        saveButton = new JButton("Save");
        saveButton.setBounds(680, 300, 90, 30);
        saveButton.addActionListener(this);

        getContentPane().setLayout(null);
        getContentPane().add(projectNameLabel);
        getContentPane().add(proposicaoLabel);
        getContentPane().add(tituloLabel);
        getContentPane().add(tituloTextField);
        getContentPane().add(descricaoLabel);
        getContentPane().add(descricaoTextArea);
        getContentPane().add(dataCriacaoLabel);
        getContentPane().add(dataCriacaoTextField);
        getContentPane().add(saveButton);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String titulo = tituloTextField.getText();
            String descricao = descricaoTextArea.getText();
            String dataCriacao = dataCriacaoTextField.getText();

            try {
                controllerProposicao.inserirProposicao(titulo, descricao, dataCriacao);
                // Inserir a lógica para ir para a próxima tela aqui
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewTelaInseriProposicao proposicaoView = new ViewTelaInseriProposicao();
            proposicaoView.setVisible(true);
        });
    }
}
