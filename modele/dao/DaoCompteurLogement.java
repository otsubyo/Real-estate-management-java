package modele.dao;

import modele.CompteurLogement;
import modele.dao.requetes.select.RequeteSelectCompteurLogement;
import modele.dao.requetes.select.RequeteSelectCompteurLogementById;
import modele.dao.requetes.select.RequeteSelectCompteurLogementByIdTypec;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutCompteurLogement;
import modele.dao.requetes.update.RequeteUpdateCompteurLog;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controlleur.CictOracleDataSource;

public class DaoCompteurLogement extends DaoModele<CompteurLogement> implements Dao<CompteurLogement>{

    @Override
    public void create(CompteurLogement data) throws SQLException {
    	SousProgramme<CompteurLogement> sp = new SpAjoutCompteurLogement();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
    }

    @Override
    public void update(CompteurLogement data) throws SQLException {
        miseAJour(new RequeteUpdateCompteurLog(), data);
    }

    @Override
    public void delete(CompteurLogement data) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public CompteurLogement findById(String... id) throws SQLException {
        List<CompteurLogement> compteurLogements = find(new RequeteSelectCompteurLogementById());
        if (compteurLogements.isEmpty()) {
            return null;
        }
        return compteurLogements.get(0);
    }

    public CompteurLogement findByIdTypec(String typec) throws SQLException {
        List<CompteurLogement> compteurLogements = find(new RequeteSelectCompteurLogementByIdTypec(), typec);
        if (compteurLogements.isEmpty()) {
            return null;
        }
        return compteurLogements.get(0);
    }

    @Override
    public List<CompteurLogement> findAll() throws SQLException {
        return find(new RequeteSelectCompteurLogement());
    }

    @Override
    protected CompteurLogement createInstance(ResultSet cursor) throws SQLException {
        CompteurLogement compteurLogement = null;
        try {
            compteurLogement = new CompteurLogement(
                    cursor.getString("MATRICULE"),
                    cursor.getString("IDBIEN"),
                    cursor.getString("IDLOG"),
                    cursor.getString("ANCIEN_INDICE"),
                    cursor.getString("NOUVEL_INDICE"),
                    cursor.getString("TYPEC")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return compteurLogement;
    }
}
