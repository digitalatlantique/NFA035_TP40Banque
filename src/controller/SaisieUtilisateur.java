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
     * Pour test� la saisie du menu 0 � 4
     */
    public boolean CheckInt(String var) {			
 
		Pattern pattern = Pattern.compile("[0-4]");
		Matcher matcher = pattern.matcher(var);
		boolean resultat = matcher.matches();
		return resultat;    	
    }

    /**
     * Pour test� la saisie de caract�re non accentu�
     */
    public boolean CheckString(String var) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(var);
		boolean resultat = matcher.matches();
		return resultat;
    }

}