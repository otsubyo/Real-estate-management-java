package modele.dao.requetes.select;

import modele.DiagnosticLogement;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectDiagnosticLogementById implements Requete<DiagnosticLogement> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.DIAGNOSTIC_LOGEMENT WHERE IDIM = ? AND IDLOG = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, DiagnosticLogement data) throws SQLException {
        prSt.setString(1, data.getIdBien());
        prSt.setString(2, data.getIdLog());
    }
}
