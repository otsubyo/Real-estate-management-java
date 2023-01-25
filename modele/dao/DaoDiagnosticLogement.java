package modele.dao;

import modele.DiagnosticLogement;
import modele.dao.requetes.select.RequeteDiagnosticLogement;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutDiaognostic;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import controlleur.CictOracleDataSource;

public class DaoDiagnosticLogement extends DaoModele<DiagnosticLogement> implements Dao<DiagnosticLogement> {

    @Override
    public void create(DiagnosticLogement data) throws SQLException {
    	SousProgramme<DiagnosticLogement> sp = new SpAjoutDiaognostic();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
    }

    @Override
    public void update(DiagnosticLogement data) throws SQLException {
        miseAJour(new RequeteDiagnosticLogement(), data);
    }

    @Override
    public void delete(DiagnosticLogement data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public DiagnosticLogement findById(String... id) throws SQLException {
        List<DiagnosticLogement> diagnosticLogement = null;
        diagnosticLogement = find(new RequeteDiagnosticLogement(), id);
        if (diagnosticLogement.isEmpty()) {
            return null;
        }
        return diagnosticLogement.get(0);
    }

    @Override
    public List<DiagnosticLogement> findAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    protected DiagnosticLogement createInstance(ResultSet cursor) throws SQLException {
        DiagnosticLogement diagnosticLogement = null;
        try{
            diagnosticLogement = new DiagnosticLogement(
                    cursor.getString("IDIM"),
                    cursor.getString("IDLOG"),
                    cursor.getString("DATE_RENOUVELLEMENT"),
                    cursor.getString("REALISATION"),
                    cursor.getString("LIEN_DIAGNOSTIC"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diagnosticLogement;
    }
}
