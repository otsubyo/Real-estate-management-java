package modele.dao;

import modele.FactureTravauxBien;
import modele.dao.requetes.select.RequeteSelectFactureTravauxBien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class DaoFactureTravauxBien extends DaoModele<FactureTravauxBien> implements Dao<FactureTravauxBien> {

    @Override
    public void create(FactureTravauxBien data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void update(FactureTravauxBien data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void delete(FactureTravauxBien data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public FactureTravauxBien findById(String... id) throws SQLException {
        List<FactureTravauxBien> factureTravauxBiens = find(new RequeteSelectFactureTravauxBien(), id);
        if (factureTravauxBiens.isEmpty()) {
            return null;
        }
        return factureTravauxBiens.get(0);
    }

    @Override
    public List<FactureTravauxBien> findAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    protected FactureTravauxBien createInstance(ResultSet cursor) throws SQLException {
        FactureTravauxBien factureTravauxBien = null;
        try{
            factureTravauxBien = new FactureTravauxBien(
                    cursor.getString("numfac"),
                    cursor.getString("numero_siret"),
                    cursor.getString("datefacture"),
                    cursor.getString("nature"),
                    cursor.getFloat("montant"),
                    cursor.getFloat("montant_non-deductible"),
                    cursor.getFloat("reduction"),
                    cursor.getString("idbien")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factureTravauxBien;
    }
}
