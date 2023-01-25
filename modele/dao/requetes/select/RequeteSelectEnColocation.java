package modele.dao.requetes.select;

import modele.EnColocation;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEnColocation implements Requete<EnColocation> {

    @Override
    public String requete() {
        return "SELECT * FROM WHERE IDLOC = ? AND IDLOC_N = ?";
    }
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, EnColocation data) throws SQLException {
        prSt.setString(1, data.getIdLoc1());
        prSt.setString(2, data.getIdLoc2());
    }
}
