package daoInterf;

import java.util.List;

import model.Edificio;

public interface DAOEdificioInt {
	List<Edificio> getAll() throws Exception;
	void create(Edificio edificio) throws Exception;
	void read(Edificio edificio) throws Exception;
	void update(Edificio edificio) throws Exception;
	void delete(Edificio edificio) throws Exception;
}
