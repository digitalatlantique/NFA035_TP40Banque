package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DebitCellRenderer extends DefaultTableCellRenderer {
	
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        DefaultTableCellRenderer centrer = new DefaultTableCellRenderer();
        
        
        Double valeur = (Double) value;
 
        if(valeur <= 0){
        	setBackground(new Color(255, 200, 200));        	
        } 
        else {
        	setBackground(new Color(200, 200, 255));
        }
 
        return this;
    }


}
