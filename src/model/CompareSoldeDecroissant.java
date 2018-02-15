package model;

import java.util.Comparator;

public class CompareSoldeDecroissant implements Comparator<Compte> {

	@Override
	public int compare(Compte cpt1, Compte cpt2) {
		return cpt2.getSolde().compareTo(cpt1.getSolde());
	}

}
