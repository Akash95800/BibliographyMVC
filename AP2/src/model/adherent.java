package model;

import java.util.ArrayList;

public class adherent {
    private String num;
    private String nom;
    private String prenom;
    private String email;
    private ArrayList<livre> ListLivre; //Pour la vue utilisateur 

    public adherent(String num, String nom, String prenom, String email,ArrayList<livre> listLivre ) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        ListLivre = listLivre;
    }

    
    public void ajouterLivre(livre l)
	{	
		ListLivre.add(l);
	}
	


	public ArrayList<livre> getListLivre() {
		return ListLivre;
	}



	public void setListLivre(ArrayList<livre> listLivre) {
		ListLivre = listLivre;
	}



	public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
       
    }
    



}


