package model;

import java.util.Comparator;

/**
 * To compare the accounts with the first name
 * @author Win7
 *
 */
public class ComparePrenom implements Comparator<Compte> {

	/**
	 * Compares its two first name for order.
	 * @param cpt1 is  the first object to be compared.
	 * @param cpt2 is  the second object to be compared.
	 * @return	a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
	 */
	@Override
	public int compare(Compte cpt1, Compte cpt2) {
		return cpt1.getPrenom().compareTo(cpt2.getPrenom());
	}

}
