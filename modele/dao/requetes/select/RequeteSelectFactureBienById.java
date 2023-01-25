package modele.dao.requetes.select;

import modele.FactureBien;
import modele.dao.requetes.Requete;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectFactureBienById implements Requete<FactureBien> {

    @Override
    public String requete() {
        return "SELECT * FROM facture_bien WHERE numfac = ? AND idbien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);

    }

    @Override
    public void parametres(PreparedStatement prSt, FactureBien data) throws SQLException {
        prSt.setString(1, data.getNumFac());
        prSt.setString(2, data.getIdbien());
    }
}
