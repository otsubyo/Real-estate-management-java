package modele.dao.requetes.select;

import modele.DiagnosticLogement;
import modele.dao.requetes.Requete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectDiagnosticLogement implements Requete<DiagnosticLogement> {

    @Override
    public String requete() {
        return "SELECT * FROM NRM4206A.DIAGNOSTIC_LOGEMENT WHERE IDIM = ? AND IDLOG = ? AND DATE_RENOUVELLEMENT = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
        prSt.setDate(3, Date.valueOf(id[2]));
    }

    @Override
    public void parametres(PreparedStatement prSt, DiagnosticLogement data) throws SQLException {
        prSt.setString(1, data.getIdBien());
        prSt.setString(1, data.getIdLog());
        prSt.setDate(1, Date.valueOf(data.getDateRenouvellement()));
    }
}
