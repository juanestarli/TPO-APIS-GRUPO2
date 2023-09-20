package daoInterf;

import java.util.List;

import model.RespuestaReclamo;

public interface DAORespuestaReclamoInt {
	List<RespuestaReclamo> getAll() throws Exception;
	void create(RespuestaReclamo respuestaReclamo) throws Exception;
	void read(RespuestaReclamo respuestaReclamo) throws Exception;
	void update(RespuestaReclamo respuestaReclamo) throws Exception;
	void delete(RespuestaReclamo respuestaReclamo) throws Exception;
}
