package daoInterf;

import java.util.List;

import model.Departamento;

public interface DAODepartamentoInt {
	List<Departamento> getAll() throws Exception;
	void create(Departamento departamento) throws Exception;
	void read(Departamento departamento) throws Exception;
	void update(Departamento departamento) throws Exception;
	void delete(Departamento departamento) throws Exception;
	
}
