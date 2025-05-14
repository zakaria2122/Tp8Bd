import java.sql.*;
import java.util.ArrayList;
import java.util.AbstractMap;
import java.util.Map;

public class JoueurBD {
	ConnexionMySQL laConnexion;
	Statement st;
	JoueurBD(ConnexionMySQL laConnexion){
		this.laConnexion=laConnexion;
	}
int maxNumJoueur() throws SQLException{
        st=laConnexion.createStatement(); // exécution requete 

        ResultSet rs = st.executeQuery("SELECT IFNULL(max(numJoueur),0) leMax from JOUEUR"); // chargement de la premiere ligne du resultat

        rs.next(); //consultation de cette ligne 

        int res = rs.getInt(1); // recupere la premiere ligne

        rs.close();

        return res;
    }


    int insererJoueur( Joueur j) throws  SQLException{
        PreparedStatement ps = laConnexion.prepareStatement("insert into JOUEUR(numJoueur, pseudo, motdepasse, main, abonne, niveau)"+ "VALUES (?,?,?,?,?,?);");

        int nouvNum = maxNumJoueur()+1;
        ps.setInt(1, nouvNum);
        ps.setString(2, j.getPseudo());
        ps.setString(3, j.getMotdepasse());
        ps.setString(4, ""+j.getMain());
        String abo;

        if (j.isAbonne()) { abo = "O";}

        else{abo = "N";}

        ps.setString(5, abo);
        ps.setInt(6, j.getNiveau());
        ps.executeUpdate();

        return nouvNum;
    }


	void effacerJoueur(int num) throws SQLException {
		throw new SQLException("méthode effacerJoueur à implémenter");
	}

    void majJoueur(Joueur j)throws SQLException{
		throw new SQLException("méthode majJoueur à implémenter");
    }

    Joueur rechercherJoueurParNum(int num)throws SQLException{
    	throw new SQLException("méthode rechercherJoueurParNum à implémenter");
    }

	ArrayList<Joueur> listeDesJoueurs() throws SQLException{
		throw new SQLException("méthode listeDesJoueurs à implémenter");
	}
	
	String rapportMessage() throws SQLException{
		return "rapportMessage A faire";
	}
	
	String rapportMessageComplet() throws SQLException{
		return "rapportMessageComplet A faire";	
	}

	ArrayList<Map.Entry<String, Integer>> nbMsgParJour() throws SQLException{
		// Pour créer une valeur pouvant être ajoutée à l'ArrayList<Map.Entry<String, Integer>>
		// faire un new AbstractMap.SimpleEntry<>("coucou",45)
		throw new SQLException("méthode nbMsgParJour à implémenter");
	}
	ArrayList<Map.Entry<String, Integer>> nbMain() throws SQLException{
		// Pour créer une valeur pouvant être ajoutée à l'ArrayList<Map.Entry<String, Integer>>
		// faire un new AbstractMap.SimpleEntry<>("coucou",45)
		throw new SQLException("méthode nbMain à implémenter");
	}	
}
