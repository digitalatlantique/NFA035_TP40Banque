package model;

import java.util.Comparator;

public class CompareSolde implements Comparator<Compte> {

	@Override
	public int compare(Compte cpt1, Compte cpt2) {		
		return cpt1.getSolde().compareTo(cpt2.getSolde());
	}

}
