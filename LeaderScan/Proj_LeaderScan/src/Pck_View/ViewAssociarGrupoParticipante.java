package Pck_View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewAssociarGrupoParticipante extends JFrame implements ActionListener{
    private DefaultTableModel tableModel;
    private JTable table;

    private JButton saveButton;
    private JButton newButton;

    public ViewAssociarGrupoParticipante() {
        setTitle("Criação de grupo para associação de participantes - LeaderScan");
        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newButton = new JButton("New");
        newButton.setBounds(570, 300, 90, 30);
        newButton.addActionListener(this);

        saveButton = new JButton("Save");
        saveButton.setBounds(680, 300, 90, 30);
        saveButton.addActionListener(this);

        String[] columnNames = { "Remover", "Modificar", "Grupo" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        table = new JTable(tableModel);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 750, 250);
        panel.add(scrollPane);

        panel.add(newButton);
        panel.add(saveButton);

        // Adicione um botão personalizado como editor de célula para as colunas "Remover" e "Modificar"
        ButtonCell buttonCell = new ButtonCell(table);
        table.getColumnModel().getColumn(0).setCellRenderer(buttonCell);
        table.getColumnModel().getColumn(1).setCellRenderer(buttonCell);
        table.getColumnModel().getColumn(0).setCellEditor(buttonCell);
        table.getColumnModel().getColumn(1).setCellEditor(buttonCell);

        // Defina a largura das colunas "Remover" e "Modificar" para o tamanho desejado
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(75); // Ajuste o tamanho conforme necessário
        column = table.getColumnModel().getColumn(1);
        column.setPreferredWidth(75); // Ajuste o tamanho conforme necessário

        getContentPane().add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            tableModel.addRow(new Object[]{"Remover", "Modificar", ""});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewAssociarGrupoParticipante grupoView = new ViewAssociarGrupoParticipante();
            grupoView.setVisible(true);
        });
    }
    
}

