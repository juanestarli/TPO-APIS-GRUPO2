package daoInterf;

import java.util.List;

import model.Reclamo;

public interface DAOReclamoInt {
	List<Reclamo> getAll() throws Exception;
	void create(Reclamo reclamo) throws Exception;
	void read(Reclamo reclamo) throws Exception;
	void update(Reclamo reclamo) throws Exception;
	void delete(Reclamo reclamo) throws Exception;

}
