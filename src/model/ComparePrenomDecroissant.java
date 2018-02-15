package model;

import java.util.Comparator;

public class ComparePrenomDecroissant implements Comparator<Compte>{

	@Override
	public int compare(Compte cpt1, Compte cpt2) {
		return cpt2.getPrenom().compareTo(cpt1.getPrenom());
	}

}
