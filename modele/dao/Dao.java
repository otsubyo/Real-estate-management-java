package modele.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	public void create(T data) throws SQLException;
	public void update(T data) throws SQLException;
	public void delete(T data) throws SQLException;
	public T findById(String... id) throws SQLException;
	public List<T> findAll() throws SQLException;
	
}
