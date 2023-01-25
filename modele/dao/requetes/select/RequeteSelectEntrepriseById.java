package modele.dao.requetes.select;

import modele.Entreprise;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEntrepriseById implements Requete<Entreprise> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.ENTREPRISE WHERE NUM_SIRET = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Entreprise data) throws SQLException {
        prSt.setString(1, data.getNumeroSiret());
    }
}
