package daoInterf;

import java.util.List;

import model.Usuario;

public interface DAOUsuarioInt {
	List<Usuario> getAll() throws Exception;
	void create(Usuario usuario) throws Exception;
	void read(Usuario usuario) throws Exception;
	void update(Usuario usuario) throws Exception;
	void delete(Usuario usuario) throws Exception;
}
