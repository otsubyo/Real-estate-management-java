package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.CompteurLogement;
import modele.dao.requetes.Requete;

public class RequeteSelectCompteurLogement implements Requete<CompteurLogement>{

	@Override
	public String requete() {
		return "SELECT * FROM NRM4206A.COMPTEUR_LOGEMENT";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametres(PreparedStatement prSt, CompteurLogement data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
