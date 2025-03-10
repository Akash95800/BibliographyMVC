package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class model {

    private Connection con;
    private ArrayList<livre> ListLivre;
    private ArrayList<auteur> ListAuteur;
    private ArrayList<adherent> ListAdherent;

    public model() throws ClassNotFoundException, SQLException {
        ListLivre = new ArrayList<>();
        ListAuteur = new ArrayList<>();
        ListAdherent = new ArrayList<>();

        String BDD = "AP2";
        String url = "jdbc:mysql://localhost:8889/" + BDD;
        String user = "root";
        String passwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(url, user, passwd);
        System.out.println("Connection ok");
    }

    public ArrayList<livre> getListLivre() {
        return ListLivre;
    }

    public void setListLivre(ArrayList<livre> listLivre) {
        ListLivre = listLivre;
    }

    public ArrayList<auteur> getListAuteur() {
        return ListAuteur;
    }

    public void setListAuteur(ArrayList<auteur> listAuteur) {
        ListAuteur = listAuteur;
    }

    public ArrayList<adherent> getListAdherent() {
        return ListAdherent;
    }

    public void setListAdherent(ArrayList<adherent> listAdherent) {
        ListAdherent = listAdherent;
    }

    public void getAll() throws SQLException {
        ListAdherent.clear();
        ListAuteur.clear();
        ListLivre.clear();

        ResultSet resultats;
        String requete;
        Statement stmt = con.createStatement();

        // Récupérer les adhérents
        requete = "SELECT * FROM adherent";
        resultats = stmt.executeQuery(requete);
        while (resultats.next()) {
            adherent ad = new adherent(resultats.getString(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), new ArrayList<livre>());
            ListAdherent.add(ad);
        }

        // Récupérer les livres
        requete = "SELECT * FROM livre";
        resultats = stmt.executeQuery(requete);
        while (resultats.next()) {
            livre l = new livre(resultats.getString(1), resultats.getString(2), resultats.getInt(3), null, null);
            ListLivre.add(l);
        }

        // Récupérer les auteurs
        requete = "SELECT * FROM auteur";
        resultats = stmt.executeQuery(requete);
        while (resultats.next()) {
            auteur a = new auteur(resultats.getString(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), resultats.getString(5));
            ListAuteur.add(a);
        }

        // Associer les livres aux adhérents
        requete = "SELECT ISBN, adherent FROM livre, adherent WHERE livre.adherent = adherent.num";
        resultats = stmt.executeQuery(requete);
        while (resultats.next()) {
            String ISBN = resultats.getString(1);
            String numadherent = resultats.getString(2);
            findlivre(ISBN).setEmprunteur(findadherent(numadherent));
            findadherent(numadherent).ajouterLivre(findlivre(ISBN));
        }

        // Associer les livres aux auteurs
        requete = "SELECT ISBN, auteur FROM livre, auteur WHERE livre.auteur = auteur.num";
        resultats = stmt.executeQuery(requete);
        while (resultats.next()) {
            String ISBN = resultats.getString(1);
            String numauteur = resultats.getString(2);
            findlivre(ISBN).setAuteur(findauteur(numauteur));
        }
    }

    public auteur findauteur(String num) {
        for (auteur a : ListAuteur) {
            if (a.getNum().equals(num)) {
                return a;
            }
        }
        return null;
    }

    public livre findlivre(String ISBN) {
        for (livre l : ListLivre) {
            if (l.getISBN().equals(ISBN)) {
                return l;
            }
        }
        return null;
    }

    public adherent findadherent(String num) {
        for (adherent a : ListAdherent) {
            if (a.getNum().equals(num)) {
                return a;
            }
        }
        return null;
    }
    
    
	public void MAJ_ad(String nom,String prenom,String email,String num) throws SQLException
	{
		String req;
		req = "UPDATE `adherent` SET  `nom` = '"+nom+"', `prenom` = '"+prenom+"', `email` = '"+email+"' WHERE `adherent`.`num` = '"+num+"';";
		Statement stmt = con.createStatement();
		int maj = stmt.executeUpdate(req);
		System.out.println(maj);
		System.out.println(req);
		
	}
	
	public void emprunterlivre(String num,String ISBN) throws SQLException
	{
		String req;
		req = "UPDATE `livre` SET `adherent` = '"+num+"' WHERE `livre`.`ISBN` = '"+ISBN+"'";
		Statement stmt = con.createStatement();
		int maj = stmt.executeUpdate(req);
	}
	
	public void retourLivre(String ISBN) throws SQLException
	{
		String req;
		req = "UPDATE `livre` SET `adherent` = NULL WHERE `livre`.`ISBN` = '"+ISBN+"'";
		Statement stmt = con.createStatement();
		int maj = stmt.executeUpdate(req);	
	}
}
