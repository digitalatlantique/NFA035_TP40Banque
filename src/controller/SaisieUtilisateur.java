package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 
 */
public class SaisieUtilisateur {

    /**
     * Default constructor
     */
    public SaisieUtilisateur() {
    }


    /**
     * Pour testé la saisie du menu 0 à 4
     */
    public boolean CheckInt(String var) {			
 
		Pattern pattern = Pattern.compile("[0-4]");
		Matcher matcher = pattern.matcher(var);
		boolean resultat = matcher.matches();
		return resultat;    	
    }

    /**
     * Pour testé la saisie de caractère non accentué
     */
    public boolean CheckString(String var) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(var);
		boolean resultat = matcher.matches();
		return resultat;
    }

}