package modele.dao.requetes.select;

import modele.CompteurLogement;
import modele.dao.requetes.Requete;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectCompteurLogementByIdTypec implements Requete<CompteurLogement> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.COMPTEUR WHERE idbien = ? AND idlog = ? AND typec = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
        prSt.setString(3, id[2]);
    }

    @Override
    public void parametres(PreparedStatement prSt, CompteurLogement data) throws SQLException {
        prSt.setString(1, data.getIdbien());
        prSt.setString(2, data.getIdLog());
        prSt.setString(3, data.getTypeCompteur());
    }
}
