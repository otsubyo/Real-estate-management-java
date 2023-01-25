package modele.dao;

import modele.FactureTravauxLogement;
import modele.dao.requetes.select.RequeteSelectFactureTravauxLogement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class DaoFactureTravauxLogement extends DaoModele<FactureTravauxLogement> implements Dao<FactureTravauxLogement> {

    @Override
    public void create(FactureTravauxLogement data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void update(FactureTravauxLogement data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void delete(FactureTravauxLogement data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public FactureTravauxLogement findById(String... id) throws SQLException {
        List<FactureTravauxLogement> factureTravauxLogements = find(new RequeteSelectFactureTravauxLogement(), id);
        if (factureTravauxLogements.isEmpty()) {
            return null;
        }
        return factureTravauxLogements.get(0);
    }

    @Override
    public List<FactureTravauxLogement> findAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    protected FactureTravauxLogement createInstance(ResultSet cursor) throws SQLException {
        FactureTravauxLogement factureTravauxLogement = null;
        try{
            factureTravauxLogement = new FactureTravauxLogement(
                    cursor.getString("numfac"),
                    cursor.getString("numero_siret"),
                    cursor.getString("datefacture"),
                    cursor.getString("nature"),
                    cursor.getFloat("montant"),
                    cursor.getFloat("montant_non-deductible"),
                    cursor.getFloat("reduction"),
                    cursor.getString("idbienlogement"),
                    cursor.getString("idlogement")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factureTravauxLogement;
    }
}
