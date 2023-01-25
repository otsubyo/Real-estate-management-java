package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.CompteurGeneral;
import modele.dao.requetes.Requete;

public class RequeteSelectCompteurGeneral implements Requete<CompteurGeneral>{

	@Override
	public String requete() {
		return "SELECT * FROM NRM4206A.COMPTEUR_GENERAL";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametres(PreparedStatement prSt, CompteurGeneral data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
