package modele.dao.requetes.select;

import modele.Assurance;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectAssuranceById implements Requete<Assurance> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.ASSURANCE WHERE idbien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Assurance data) throws SQLException {
        prSt.setString(1, data.getIdAssurance());
    }

}
