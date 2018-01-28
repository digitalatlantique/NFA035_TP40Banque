package view;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import model.Client;

public class ModeleTableClient extends AbstractTableModel {
	
	Vector<Client> liste = null;
	String[] entete = {"ID", "Prénom", "Genre", "Age", "Gestionnaire", "Solde"};
	
	public ModeleTableClient(Vector<Client> liste) {
		
		super();
		this.liste = liste;
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
			case 0 : {return liste.get(arg0).getIdClient();}
			case 1 : {return liste.get(arg0).getPrenom();}
			case 2 : {return liste.get(arg0).getGenre();}
			case 3 : {return liste.get(arg0).getAge();}
			case 4 : {return liste.get(arg0).getGestionnaire().getPrenom();}
			case 5 : {return liste.get(arg0).getTresorerie();}
			default : return null;
		}
	}

}
