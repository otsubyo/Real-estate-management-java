package modele.dao;

import modele.EtatDesLieux;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutEtatDesLieux;
import modele.dao.requetes.update.RequeteUpdateEtatDeslieux;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import controlleur.CictOracleDataSource;

public class DaoEtatDesLieux extends DaoModele<EtatDesLieux> implements  Dao<EtatDesLieux> {

    @Override
    public void create(EtatDesLieux data) throws SQLException {
    	SousProgramme<EtatDesLieux> sp = new SpAjoutEtatDesLieux();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
    }

    @Override
    public void update(EtatDesLieux data) throws SQLException {
        miseAJour(new RequeteUpdateEtatDeslieux(), data);
    }

    @Override
    public void delete(EtatDesLieux data) throws SQLException {
      // TODO unused
    }

    @Override
    public EtatDesLieux findById(String... id) throws SQLException {
        List<EtatDesLieux> liste = find(new RequeteUpdateEtatDeslieux(), id);
        if (!liste.isEmpty()) {
            return liste.get(0);
        }
        return null;
    }

    @Override
    public List<EtatDesLieux> findAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    protected EtatDesLieux createInstance(ResultSet cursor) throws SQLException {
        EtatDesLieux etatDesLieux = null;
        try{
            etatDesLieux = new EtatDesLieux(
                    cursor.getString("IDBIEN"),
                    cursor.getString("IDLOG"),
                    cursor.getString("IDLOC"),
                    cursor.getString("ELEMENT_OBS"),
                    cursor.getString("ETAT_GENERAL"),
                    cursor.getString("OBSERVATION"),
                    cursor.getString("LIEN_FICHIER"),
                    cursor.getDate("DATE_ANALYSE").toString()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etatDesLieux;
    }
}
