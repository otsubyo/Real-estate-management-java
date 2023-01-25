package modele.dao.requetes.select;

import modele.Bien;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectBien implements Requete<Bien> {
    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.BIEN ORDER BY IDIM";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {}
    @Override
    public void parametres(PreparedStatement prSt, Bien data) throws SQLException {}
}
