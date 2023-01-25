package modele.dao;

import modele.Entreprise;
import modele.dao.requetes.select.RequeteSelectEntreprise;
import modele.dao.requetes.select.RequeteSelectEntrepriseById;
import modele.dao.requetes.update.RequeteUpdateEntreprise;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise> {

    @Override
    public void create(Entreprise data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void update(Entreprise data) throws SQLException {
        miseAJour(new RequeteUpdateEntreprise(), data);
    }

    @Override
    public void delete(Entreprise data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public Entreprise findById(String... id) throws SQLException {
        List<Entreprise> entreprises = find(new RequeteSelectEntrepriseById(), id);
        if (entreprises.isEmpty()) {
            return null;
        }
        return entreprises.get(0);
    }

    @Override
    public List<Entreprise> findAll() throws SQLException {
        return find(new RequeteSelectEntreprise());
    }

    @Override
    protected Entreprise createInstance(ResultSet cursor) throws SQLException {
        Entreprise entreprise = null;
        try {
            entreprise = new Entreprise(
                    cursor.getString("NUM_SIRET"),
                    cursor.getString("NOM"),
                    cursor.getString("EMAIL"),
                    cursor.getString("NUMTEL"),
                    cursor.getString("ADRESSE"),
                    cursor.getString("CODE_POSTAL"),
                    cursor.getString("VILLE")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entreprise;
    }
}
