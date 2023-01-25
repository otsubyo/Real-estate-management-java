package modele.dao;

import modele.BailLocataire;
import modele.dao.requetes.select.RequeteSelectBailLocataireById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutBail;
import modele.dao.requetes.update.RequeteUpdateBailLocataire;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import controlleur.CictOracleDataSource;

public class DaoBailLocataire extends DaoModele<BailLocataire> implements Dao<BailLocataire> {


    @Override
    public void create(BailLocataire data) throws SQLException {
    	SousProgramme<BailLocataire> sp = new SpAjoutBail();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
    }

    @Override
    public void update(BailLocataire data) throws SQLException {
        miseAJour(new RequeteUpdateBailLocataire(), data);
    }

    @Override
    public void delete(BailLocataire data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public BailLocataire findById(String... id) throws SQLException {
        List<BailLocataire> bail = find(new RequeteSelectBailLocataireById(), id);
        if (bail.isEmpty()) {
            return null;
        }
        return bail.get(0);
    }

    @Override
    public List<BailLocataire> findAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    protected BailLocataire createInstance(ResultSet cursor) throws SQLException {
        BailLocataire bail = null;
        try {
            bail = new BailLocataire(
                    cursor.getString("DATE_SIGNATURE"),
                    cursor.getString("IDLOC"),
                    cursor.getString("DATE_EFFET"),
                    cursor.getString("DATE_FIN"),
                    cursor.getFloat("CAUTION"),
                    cursor.getString("LIEN_FICHIER")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bail;
    }
}
