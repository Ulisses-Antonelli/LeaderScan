package Pck_View;

import java.awt.event.ActionListener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonCell extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JTable table;
    private JButton renderButton;
    private JButton editButton;
    private Object editorValue;

    public ButtonCell(JTable table) {
        this.table = table;
        this.renderButton = new JButton("Remover");
        this.editButton = new JButton("Modificar");
        this.editButton.addActionListener(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editorValue = value;
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getEditingRow();
        if (e.getSource() == editButton) {
            
        } else if (e.getSource() == renderButton) {
            
        }
        stopCellEditing();
    }
}

