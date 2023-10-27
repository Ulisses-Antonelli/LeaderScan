package Pck_View;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Pck_Controller.ControllerPerfil;

import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ViewTelaDefinirPerfil extends JFrame implements ActionListener {

    private JLabel projectNameLabel;
    private JLabel perfilLabel;
    private JLabel colunaNome;
    private JLabel colunaCriador;
    private JLabel colunaAvaliador;
    private JLabel colunaPeso;
    private JLabel colunaDeletar;
    private JLabel colunaAtualizar;

    private JPanel tabelaPanel;
    private JPanel panel;

    private JButton priv_delete;
    private JButton priv_update;
    private JButton btnCriar;

    private ControllerPerfil controllerPerfil = new ControllerPerfil();

    public ViewTelaDefinirPerfil() {

        setTitle("Criação de Perfil - LeaderScan");
        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        projectNameLabel = new JLabel("LeaderScan");
        projectNameLabel.setBounds(10, 10, 100, 20);

        perfilLabel = new JLabel("Perfil");
        perfilLabel.setBounds(10, 40, 100, 20);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(10, 70, 700, 150);

        // Painel da tabela
        tabelaPanel = new JPanel();
        tabelaPanel.setBounds(10, 70, 700, 150);
        tabelaPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));  // colocando borda no painel que segura a tabela
        tabelaPanel.setLayout(null);

        // elementos do painel (dentro da borda)
        colunaNome = new JLabel("Nome do Perfil");
        colunaNome.setBounds(0, 0, 150, 25);
        colunaNome.setHorizontalAlignment(SwingConstants.CENTER);
        colunaNome.setForeground(Color.WHITE);
        colunaNome.setBackground(Color.DARK_GRAY);
        colunaNome.setOpaque(true);
        tabelaPanel.add(colunaNome);

        colunaCriador = new JLabel("Criar Proposição");
        colunaCriador.setBounds(150, 0, 150, 25);
        colunaCriador.setHorizontalAlignment(SwingConstants.CENTER);
        colunaCriador.setForeground(Color.WHITE);
        colunaCriador.setBackground(Color.DARK_GRAY);
        colunaCriador.setOpaque(true);
        tabelaPanel.add(colunaCriador);

        colunaAvaliador = new JLabel("Responder Proposição");
        colunaAvaliador.setBounds(300, 0, 150, 25);
        colunaAvaliador.setHorizontalAlignment(SwingConstants.CENTER);
        colunaAvaliador.setForeground(Color.WHITE);
        colunaAvaliador.setBackground(Color.DARK_GRAY);
        colunaAvaliador.setOpaque(true);
        tabelaPanel.add(colunaAvaliador);

        colunaPeso = new JLabel("Peso");
        colunaPeso.setBounds(450, 0, 150, 25);
        colunaPeso.setHorizontalAlignment(SwingConstants.CENTER);
        colunaPeso.setForeground(Color.WHITE);
        colunaPeso.setBackground(Color.DARK_GRAY);
        colunaPeso.setOpaque(true);
        tabelaPanel.add(colunaPeso);

        colunaDeletar = new JLabel("");
        colunaDeletar.setBounds(600, 0, 50, 25);
        colunaDeletar.setHorizontalAlignment(SwingConstants.CENTER);
        colunaDeletar.setForeground(Color.WHITE);
        colunaDeletar.setBackground(Color.DARK_GRAY);
        colunaDeletar.setOpaque(true);
        tabelaPanel.add(colunaDeletar);

        colunaAtualizar = new JLabel("");
        colunaAtualizar.setBounds(650, 0, 700, 25);
        colunaAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
        colunaAtualizar.setForeground(Color.WHITE);
        colunaAtualizar.setBackground(Color.DARK_GRAY);
        colunaAtualizar.setOpaque(true);
        tabelaPanel.add(colunaAtualizar);

        // carregando as linhas da tabela com base em cada perfil do banco
        // tambem aproveitamos pra colocar o comportamento de Rolagem no panel
        carregarListaPerfis();
        
        JScrollPane tabelaPanelComScroll = new JScrollPane(tabelaPanel, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(tabelaPanelComScroll, BorderLayout.CENTER);

        // input + label + botao de criar novo perfil
        JLabel criarPerfilLabel = new JLabel("Criar novo perfil");
        criarPerfilLabel.setBounds(10, 230, 100, 25);


        // novo painel pra criação de perfil
        JPanel novoPerfilPanel = new JPanel();
        novoPerfilPanel.setLayout(null);
        novoPerfilPanel.setBounds(10, 260, 698, 50);
        novoPerfilPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        // labels
            JLabel inputNomeLabel = new JLabel("Nome");
            inputNomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            inputNomeLabel.setBounds(0, 0, 150, 22);
            inputNomeLabel.setForeground(Color.WHITE);
            inputNomeLabel.setBackground(Color.DARK_GRAY);
            inputNomeLabel.setOpaque(true);
            novoPerfilPanel.add(inputNomeLabel);

            JLabel privCriarLabel = new JLabel("Criar Proposição");
            privCriarLabel.setHorizontalAlignment(SwingConstants.CENTER);
            privCriarLabel.setBounds(150, 0, 150, 22);
            privCriarLabel.setForeground(Color.WHITE);
            privCriarLabel.setBackground(Color.DARK_GRAY);
            privCriarLabel.setOpaque(true);
            novoPerfilPanel.add(privCriarLabel);

            JLabel privRespLabel = new JLabel("Responder Proposição");
            privRespLabel.setHorizontalAlignment(SwingConstants.CENTER);
            privRespLabel.setBounds(300, 0, 150, 22);
            privRespLabel.setForeground(Color.WHITE);
            privRespLabel.setBackground(Color.DARK_GRAY);
            privRespLabel.setOpaque(true);
            novoPerfilPanel.add(privRespLabel);

            JLabel inputPesoLabel = new JLabel("Peso");
            inputPesoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            inputPesoLabel.setBounds(450, 0, 150, 22);
            inputPesoLabel.setForeground(Color.WHITE);
            inputPesoLabel.setBackground(Color.DARK_GRAY);
            inputPesoLabel.setOpaque(true);
            novoPerfilPanel.add(inputPesoLabel);

            JLabel buttonLabel = new JLabel("");
            buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
            buttonLabel.setBounds(600, 0, 100, 22);
            buttonLabel.setForeground(Color.WHITE);
            buttonLabel.setBackground(Color.DARK_GRAY);
            buttonLabel.setOpaque(true);
            novoPerfilPanel.add(buttonLabel);
        
        // inputs
            JTextField inputNome = new JTextField();
            inputNome.setBounds(5, 25, 145, 22);
            novoPerfilPanel.add(inputNome);

            JCheckBox privCriarCheck = new JCheckBox();
            privCriarCheck.setBounds(150, 25, 150, 22);
            privCriarCheck.setHorizontalAlignment(SwingConstants.CENTER);
            novoPerfilPanel.add(privCriarCheck);

            JCheckBox privRespCheck = new JCheckBox();
            privRespCheck.setBounds(300, 25, 150, 22);
            privRespCheck.setHorizontalAlignment(SwingConstants.CENTER);
            novoPerfilPanel.add(privRespCheck);

            JTextField inputPeso = new JTextField();
            inputPeso.setBounds(455, 25, 145, 22);
            novoPerfilPanel.add(inputPeso);

            btnCriar = new JButton();
            btnCriar.setBounds(605, 22, 92, 27);
            btnCriar.setText("Criar");
            btnCriar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
            btnCriar.setBackground(Color.GREEN);
            novoPerfilPanel.add(btnCriar);
            btnCriar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Integer priv_criar_int = privCriarCheck.isSelected() ? 1 : 0;
                    Integer priv_resp_int = privRespCheck.isSelected() ? 1 : 0;

                    String nome = inputNome.getText().toUpperCase();
                    String priv_criar = Integer.toString(priv_criar_int);
                    String priv_resp = Integer.toString(priv_resp_int);
                    Integer peso = Integer.parseInt(inputPeso.getText());

                    try{
                        controllerPerfil.inserirPerfil(nome, priv_criar, priv_resp, peso);
                        inputNome.setText("");
                        privCriarCheck.setSelected(false);
                        privRespCheck.setSelected(false);
                        inputPeso.setText("");
                        recarregarFrame();
                    }catch(SQLException err){
                        System.err.println("Erro: "+err);
                        System.exit(1);
                    }
                }
            });

        // adicionando as coisas na tela
        getContentPane().setLayout(null);
        getContentPane().add(projectNameLabel);
        getContentPane().add(perfilLabel);
        getContentPane().add(panel);
        getContentPane().add(criarPerfilLabel);
        getContentPane().add(novoPerfilPanel);
    }

    public void carregarListaPerfis(){
        // criar linhas na tabela
        List<List<Object>> dados = selectPerfis();
        Integer idx = 25;
        Integer recuo_esq = 20;
        for (List<Object> list : dados) {
            Border borda_fina = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);

            JPanel linha = new JPanel();
            linha.setBounds(1, idx, 696, 25);
            linha.setBorder(borda_fina);
            linha.setLayout(null);

            JLabel priv_nome = new JLabel(list.get(1).toString());
            priv_nome.setBounds(0+recuo_esq, 0, 150, 25);
            priv_nome.setHorizontalAlignment(SwingConstants.LEFT);
            linha.add(priv_nome);
            
            JCheckBox priv_pms_1 = new JCheckBox();
            priv_pms_1.setBounds(150, 2, 150, 20);
            priv_pms_1.setHorizontalAlignment(SwingConstants.CENTER);
            priv_pms_1.setVerticalAlignment(SwingConstants.CENTER);
            priv_pms_1.setSelected((Boolean) list.get(2));
            priv_pms_1.setEnabled(false);
            linha.add(priv_pms_1);

            JCheckBox priv_pms_2 = new JCheckBox();
            priv_pms_2.setBounds(300, 2, 150, 20);
            priv_pms_2.setHorizontalAlignment(SwingConstants.CENTER);
            priv_pms_1.setVerticalAlignment(SwingConstants.CENTER);
            priv_pms_2.setSelected((Boolean) list.get(3));
            priv_pms_2.setEnabled(false);
            linha.add(priv_pms_2);

            JLabel priv_peso = new JLabel(list.get(4)+"");
            priv_peso.setBounds(450, 0, 150, 25);
            priv_peso.setHorizontalAlignment(SwingConstants.CENTER);
            linha.add(priv_peso);


            
            priv_delete = new JButton();
            priv_delete.setText("✖");
            priv_delete.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
            priv_delete.setBounds(600, 0, 50, 25);
            priv_delete.setBackground(Color.RED);
            priv_delete.setForeground(Color.WHITE);
            linha.add(priv_delete);
            priv_delete.addActionListener(new ActionListener() {
                Integer codigo = Integer.parseInt(list.get(0).toString());

                public void actionPerformed(ActionEvent e){
                    try{
                        controllerPerfil.excluirPerfil(codigo);
                        //linha.setVisible(false);
                        recarregarFrame();
                    } catch(SQLException err){
                        System.err.println("Erro: "+err);
                        System.exit(1);
                    }
                }
            });

            priv_update = new JButton();
            priv_update.setText("✱");
            priv_update.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
            priv_update.setBackground(Color.WHITE);
            priv_update.setBounds(650, 0, 46, 25);
            linha.add(priv_update);
            priv_update.addActionListener(new ActionListener() {
                Integer codigo = Integer.parseInt(list.get(0).toString());

                public void actionPerformed(ActionEvent e){
                    System.out.println(codigo);
                }
            });

            idx += 25;
            
            tabelaPanel.add(linha);
        }

    }

    public List<List<Object>> selectPerfis(){
        try{
            return controllerPerfil.selectPerfis();
        }catch(SQLException e){
            System.out.println("erro"+e);
            System.exit(1);
            return Collections.emptyList();
        }
    }

    public void recarregarFrame(){
        tabelaPanel.removeAll();
        carregarListaPerfis();
        this.dispose();
        this.revalidate();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == priv_delete) {
            JButton botao = (JButton) e.getSource();
            Integer actionCommand = Integer.parseInt(botao.getActionCommand());
            System.out.println(actionCommand);
        }
    }
}