package modele.dao.requetes.select;

import modele.FactureTravauxLogement;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectFactureTravauxLogement implements Requete<FactureTravauxLogement> {
    @Override
    public String requete() {
        return "SELECT * FROM facture_travaux WHERE numfac = ? OR (idlogement = ? AND idbienlogement = ?)";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
        prSt.setString(3, id[2]);
    }

    @Override
    public void parametres(PreparedStatement prSt, FactureTravauxLogement data) throws SQLException {
        prSt.setString(1, data.getNumFac());
        prSt.setString(2, data.getIdLog());
        prSt.setString(3, data.getIdBienLog());
    }
}
