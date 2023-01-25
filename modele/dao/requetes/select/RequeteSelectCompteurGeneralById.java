package modele.dao.requetes.select;

import modele.CompteurGeneral;
import modele.dao.requetes.Requete;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectCompteurGeneralById implements Requete<CompteurGeneral> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.COMPTEUR_GENERAL WHERE matricule = ? AND idbien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, CompteurGeneral data) throws SQLException {
    	prSt.setString(1, data.getMatricule());
        prSt.setString(2, data.getIdbien());
    }
}
