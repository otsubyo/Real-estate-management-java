package modele.dao.requetes.select;

import modele.Garage;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectGarage implements Requete<Garage> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.GARAGE";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {}

	@Override
	public void parametres(PreparedStatement prSt, Garage data) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
