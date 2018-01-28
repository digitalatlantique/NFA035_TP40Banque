package model;

import java.util.Comparator;

/**
 * To compare the accounts with the balance
 * @author Win7
 *
 */
public class CompareSolde implements Comparator<Compte> {

	/**
	 * Compares its two balance for order.
	 * @param cpt1 is the first object to be compared.
	 * @param cpt2 is the second object to be compared.
	 * @return	a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
	 */
	@Override
	public int compare(Compte cpt1, Compte cpt2) {		
		return cpt1.getSolde().compareTo(cpt2.getSolde());
	}

}
