package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurer;
import modele.dao.requetes.Requete;

public class RequeteSelectAssurerByIdBien implements Requete<Assurer>{

	@Override
	public String requete() {
		return "select * from NRM4206A.ASSURER where IDBIEN = ? ORDER BY DATE_DEBUT";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		
	}

	@Override
	public void parametres(PreparedStatement prSt, Assurer data) throws SQLException {
		prSt.setString(1, data.getIdBien());
	}

}
