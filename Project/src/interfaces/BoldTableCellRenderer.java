/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author Pepito
 */
public class BoldTableCellRenderer extends MultiLineTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        return cell;
    }
}
