package model;

public class livre {

    private String ISBN;
    private String titre;
    private int prix;
    private auteur Auteur;
    private adherent Emprunteur;

    public livre(String iSBN, String titre, int prix , auteur auteur, adherent emprunteur) {
        super();
        ISBN = iSBN;
        this.titre = titre;
        this.prix = prix;
      
        Auteur = auteur;
        Emprunteur = emprunteur;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public auteur getAuteur() {
        return Auteur;
    }

    public void setAuteur(auteur auteur) {
        Auteur = auteur;
    }

    public adherent getEmprunteur() {
        return Emprunteur;
    }

    public void setEmprunteur(adherent emprunteur) {
        Emprunteur = emprunteur;
    }


    public String LigneInfo() {
        String ligne;
        ligne = ISBN + " : " + titre;
        if (Auteur == null) {
            ligne = ligne + "(Auteur : inconnu)";
        } else {
            ligne = ligne + " ( Auteur : " + Auteur.getNom() + " " + Auteur.getPrenom() + " ";
        }
        if (Emprunteur == null) {
            ligne += " dispo";
        } else {
            ligne += " emprunté";
        }
		return ligne;
    }
}
