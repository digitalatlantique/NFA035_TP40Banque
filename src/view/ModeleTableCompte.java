package view;

import java.util.ArrayList;
import java.util.List;

import model.Compte;

import javax.swing.table.AbstractTableModel;

/**
 * This is the model for accounts
 * @author Workstation
 *
 */
public class ModeleTableCompte extends AbstractTableModel {
	
	private ArrayList<Compte> liste = null;
	private String[] entete = {"Numéro Compte", "Prénom", "Type", "Solde"};
	
	public ModeleTableCompte(ArrayList<Compte> compte) {
		
		super();
		this.liste = compte;
		
	}
	
    public String getColumnName(int columnIndex) {
        return entete[columnIndex];
    }
	
	@Override
	public int getRowCount() {		
		return liste.size();
	}
	@Override
	public int getColumnCount() {		
		return entete.length;
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		switch(arg1) {
			case 0 : {return liste.get(arg0).getNumCpte();}
			case 1 : {return liste.get(arg0).getPrenom();}
			case 2 : {return liste.get(arg0).getType();}
			case 3 : {return liste.get(arg0).getSolde();}
			default : return null;
		}
		
	}

}
