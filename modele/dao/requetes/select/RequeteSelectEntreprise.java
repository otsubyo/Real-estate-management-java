package modele.dao.requetes.select;

import modele.Entreprise;
import modele.dao.requetes.Requete;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEntreprise implements Requete<Entreprise> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.ENTREPRISE";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {}

    @Override
    public void parametres(PreparedStatement prSt, Entreprise data) throws SQLException {}
}
