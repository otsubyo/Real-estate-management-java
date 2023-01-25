package modele.dao;

import modele.Assurance;
import modele.dao.requetes.select.RequeteSelectAssuranceById;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoAssurance extends DaoModele<Assurance> implements Dao<Assurance>{

    @Override
    public void create(Assurance data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void update(Assurance data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void delete(Assurance data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public Assurance findById(String... id) throws SQLException {
        List<Assurance> assurances = find(new RequeteSelectAssuranceById(), id);
        if (assurances.isEmpty()) {
            return null;
        }
        return assurances.get(0);
    }

    @Override
    public List<Assurance> findAll() throws SQLException {
        return find(new RequeteSelectAssuranceById());
    }

    @Override
    protected Assurance createInstance(ResultSet cursor) throws SQLException {
        Assurance assurance = null;
        try {
            assurance = new Assurance(
                    cursor.getString("IDASSURANCE"),
                    cursor.getString("LIBELLE_ASSUREUR")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return assurance;
    }
}
