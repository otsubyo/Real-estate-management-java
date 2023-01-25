package modele.dao;

import modele.FactureBien;
import modele.dao.requetes.update.RequeteUpdateFactureBien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class DaoFactureBien extends DaoModele<FactureBien> implements Dao<FactureBien> {
    @Override
    public void create(FactureBien data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void update(FactureBien data) throws SQLException {
        miseAJour(new RequeteUpdateFactureBien(), data);
    }

    @Override
    public void delete(FactureBien data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public FactureBien findById(String... id) throws SQLException {
        List<FactureBien> factureBiens = find(new RequeteUpdateFactureBien(), id);
        if (factureBiens.isEmpty()) {
            return null;
        }
        return factureBiens.get(0);
    }

    @Override
    public List<FactureBien> findAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    protected FactureBien createInstance(ResultSet cursor) throws SQLException {
        FactureBien factureBien = null;
        try{
            factureBien = new FactureBien(
                    cursor.getString("numfac"),
                    cursor.getString("idBien"),
                    cursor.getString("typefac"),
                    cursor.getString("date_emission"),
                    cursor.getString("date_paiement"),
                    cursor.getString("mode_paiement"),
                    cursor.getString("numero_cheque"),
                    cursor.getFloat("montant")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return factureBien;
    }
}

