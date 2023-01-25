package modele.dao.requetes.select;

import modele.dao.requetes.Requete;
import modele.Garage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectGarageById implements Requete<Garage> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.GARAGE WHERE ID_GARAGE = ? AND IDIM_N = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Garage data) throws SQLException {
        prSt.setString(1, data.getIdGarage());
        prSt.setString(2, data.getIdbien());
    }
}
