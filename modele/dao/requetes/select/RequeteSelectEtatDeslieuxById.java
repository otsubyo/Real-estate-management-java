package modele.dao.requetes.select;

import modele.EtatDesLieux;
import modele.dao.requetes.Requete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEtatDeslieuxById implements Requete<EtatDesLieux> {
    @Override
    public String requete() {
        return "SELECT * FROM ETAT_DES_LIEUX " +
                "WHERE IDBIEN = ? " +
                "IDLOG = ? " +
                "IDLOC = ? " +
                "DATE_ANALYSE = ? " +
                "ELEMENT_OBS = ? " +
                "ETAT_GENERAL = ? " +
                "OBSERVATION = ? " +
                "LIEN_FICHIER = ? ";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
        prSt.setString(3, id[2]);
        prSt.setDate(4, Date.valueOf(id[3]));
        prSt.setString(5, id[4]);
        prSt.setString(6, id[5]);
        prSt.setString(7, id[6]);
        prSt.setString(8, id[7]);

    }

    @Override
    public void parametres(PreparedStatement prSt, EtatDesLieux data) throws SQLException {
        prSt.setString(1, data.getIdBien());
        prSt.setString(2, data.getIdLog());
        prSt.setString(3, data.getIdLoc());
        prSt.setDate(4, Date.valueOf(data.getDateAnalyse()));
        prSt.setString(5, data.getElementsObserve());
        prSt.setString(6, data.getEtatGeneral());
        prSt.setString(7, data.getObservations());
        prSt.setString(8, data.getLienFichier());

    }
}
