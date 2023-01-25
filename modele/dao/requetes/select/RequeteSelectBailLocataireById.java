package modele.dao.requetes.select;

import modele.BailLocataire;
import modele.dao.requetes.Requete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectBailLocataireById implements Requete<BailLocataire> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.BAIL_LOCATAIRE WHERE date_signature = ? AND idloc = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setDate(1, Date.valueOf(id[0]));
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, BailLocataire data) throws SQLException {
        prSt.setDate(2, Date.valueOf(data.getDateSignature()));
        prSt.setString(1, data.getIdloc());

    }
}
