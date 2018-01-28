package model;

import java.util.Comparator;

public class ComparePrenom implements Comparator<Compte> {

	@Override
	public int compare(Compte cpt1, Compte cpt2) {
		return cpt1.getPrenom().compareTo(cpt2.getPrenom());
	}

}
