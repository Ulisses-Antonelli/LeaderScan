
package Pck_View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Pck_Controller.ControllerParticipante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ViewAssociarGrupoParticirrpante extends JFrame implements ActionListener {

    private DefaultTableModel tableModel;
    private JTable table;

    private JButton saveButton;
    private JButton newButton;

    ControllerParticipante controllerParticipante = new ControllerParticipante();

    public ViewAssociarGrupoParticirrpante() {

        setTitle("Criação de grupo para associação de participantes - LeaderScan");
        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonCell buttonCell = new ButtonCell(table);
        table.getColumnModel().getColumn(0).setCellRenderer(buttonCell);
        table.getColumnModel().getColumn(1).setCellRenderer(buttonCell);
        table.getColumnModel().getColumn(0).setCellEditor(buttonCell);
        table.getColumnModel().getColumn(1).setCellEditor(buttonCell);

        
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(75); 
        column = table.getColumnModel().getColumn(1);
        column.setPreferredWidth(75); 

        newButton = new JButton("New");
        newButton.setBounds(570, 300, 90, 30);
        newButton.addActionListener(this);

        saveButton = new JButton("Save");
        saveButton.setBounds(680, 300, 90, 30);
        saveButton.addActionListener(this);

        String[] columnNames = { "Remover", "Modificar", "Grupo" };
        tableModel = new DefaultTableModel(columnNames, 0) {

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

        getContentPane().add(panel);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == newButton) {
        tableModel.addRow(new Object[] { "Remover", "Modificar", "" });
    } else if (e.getSource() == saveButton) {
        int selectedRow = table.getSelectedRow();
        System.out.println(selectedRow);
        
        if (selectedRow != -1) { 
            Object grupoObject = tableModel.getValueAt(selectedRow, 2);
            
            if (grupoObject != null) {
                String grupo = grupoObject.toString();
                System.out.println(grupo);
                if (!grupo.isEmpty()) {
                    try {
                        controllerParticipante.inserirGrupoParticipante(grupo);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                System.out.println("A célula está vazia.");
            }
        } else {
            System.out.println("Nenhuma linha selecionada.");
        }
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewAssociarGrupoParticipante grupoView = new ViewAssociarGrupoParticipante();
            grupoView.setVisible(true);
        });
    }
}
