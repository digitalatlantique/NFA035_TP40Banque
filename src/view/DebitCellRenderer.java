package view;

import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * This is the renderer of the column of balance
 * @author Workstation
 *
 */
public class DebitCellRenderer extends DefaultTableCellRenderer {
	
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        DefaultTableCellRenderer centrer = new DefaultTableCellRenderer();
        
        
        Double valeur = (Double) value;
        setHorizontalAlignment(SwingConstants.RIGHT);
        setText(new DecimalFormat("0.00 E").format(valeur));        
 
        if(valeur <= 0){
        	setBackground(new Color(255, 200, 200));        	
        } 
        else {
        	setBackground(new Color(200, 200, 255));
        }
 
        return this;
    }


}
