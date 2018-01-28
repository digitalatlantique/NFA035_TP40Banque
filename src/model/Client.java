package model;


import java.util.ArrayList;

import main.DemoApli;

/**
 * 
 */
public class Client extends Personne {

    /**
     * Default constructor
     */
    public Client() {
    }
    /**
     * Constructor
     */
    public Client(String prenom,int age, Genre genre, Gestionnaire gest) {
    	super(prenom);
    	this.age = age;
    	this.genre = genre;
    	this.gestionnaire = gest;
    	this.tresorerie = 0.0;
    	this.idClient = DemoApli.genererIdClient(prenom);
    	super.setProfil("Client");
    	mesComptes = new ArrayList<Compte>(); 
    }

    /**
     * 
     */
    private String idClient;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Genre genre;

    /**
     * 
     */
    private Gestionnaire gestionnaire;

    /**
     * 
     */
    private Double cagnote;

    /**
     * 
     */
    private Double tresorerie;

    /**
     * Pour stoker tous les comptes du client
     */
    private ArrayList<Compte> mesComptes;
    
    /**
     * Pour créer un compte client
     */    
    public void creerCompte(TypeCompte type, Double solde) {
    	Compte cpt = new Compte(this.getPrenom(), type, solde);
    	mesComptes.add(cpt);    	
    }
    
    /**
     * Retourne la liste des comptes client
     * @param 
     */
    public ArrayList<Compte> listerCompte() {    	
        return this.mesComptes;
    }
    
    /**
     * Retourne la liste d'un type de compte client
     * @param TypeCompte
     */
    public ArrayList<Compte> listerCompte(TypeCompte type) {
    	
    	ArrayList<Compte> listeType = new ArrayList<Compte>();
    	for(int i=0; i<mesComptes.size(); i++) {
    		if(mesComptes.get(i).getType() == type) {
    			listeType.add(mesComptes.get(i));
    		}
    	}
        return listeType;
    }
    	
    
    /**
     * 
     */
    public void crediter() {
        // TODO implement here
    }

    /**
     * 
     */
    public void debiter() {
        // TODO implement here
    }

    /**
     * 
     */
    public void transferer() {
        // TODO implement here
    }
    
    /**
     * Pour connaitre le solde cumulé de tout les comptes
     */
    public Double consulterTresorerie() {
    	// TODO a comment
    	Double resultat = 0.0;
    	
    	for(int i=0; i<mesComptes.size(); i++) {
    		resultat += mesComptes.get(i).getSolde();
    	}
    	this.tresorerie = (Math.floor(resultat*100))/100;;
    	return resultat;        
    }
    
    /**
     * 
     */
	public String toString() {
		this.consulterTresorerie();
		String str = 	"------------------------------------------------\n"
						+ super.toString() + "\n"
						+ "Identifiant : " + this.idClient +"\n"						
						+ "Age : " + this.age + " ans\n"
						+ "Genre : " + this.genre +"\n"
						+ "Gestionnaire : " + gestionnaire.getPrenom() +"\n"
						+ "Trésorerie : " + this.tresorerie + "Euro(s)\n"
						+"------------------------------------------------\n";
		return str;						 
	}    
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}
	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	public Double getCagnote() {
		return cagnote;
	}
	public void setCagnote(Double cagnote) {
		this.cagnote = cagnote;
	}
	public Double getTresorerie() {
		this.consulterTresorerie();
		return tresorerie;
	}
	public void setTresorerie(Double tresorerie) {
		this.tresorerie = tresorerie;
	}
}