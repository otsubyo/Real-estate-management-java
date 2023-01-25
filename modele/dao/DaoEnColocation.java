package modele.dao;

import modele.EnColocation;
import modele.dao.requetes.select.RequeteSelectEnColocation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class DaoEnColocation extends DaoModele<EnColocation> implements Dao<EnColocation> {
    @Override
    public void create(EnColocation data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void update(EnColocation data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public void delete(EnColocation data) throws SQLException {
      // TODO document why this method is empty
    }

    @Override
    public EnColocation findById(String... id) throws SQLException {
        List<EnColocation> list = find(new RequeteSelectEnColocation(), id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<EnColocation> findAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    protected EnColocation createInstance(ResultSet cursor) throws SQLException {
        return null;
    }
}
