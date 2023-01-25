package modele.dao.requetes.select;

import modele.FactureTravauxBien;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectFactureTravauxBien implements Requete<FactureTravauxBien> {
    @Override
    public String requete() {
        return "SELECT * FROM facture_travaux WHERE numfac = ? OR idbien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, FactureTravauxBien data) throws SQLException {
        prSt.setString(1, data.getNumFac());
        prSt.setString(2, data.getIdBien());
    }
}
