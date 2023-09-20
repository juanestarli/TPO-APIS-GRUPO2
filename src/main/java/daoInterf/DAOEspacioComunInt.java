package daoInterf;

import java.util.List;

import model.EspacioComun;

public interface DAOEspacioComunInt {
	List<EspacioComun> getAll() throws Exception;
	void create(EspacioComun espacioComun) throws Exception;
	void read(EspacioComun espacioComun) throws Exception;
	void update(EspacioComun espacioComun) throws Exception;
	void delete(EspacioComun espacioComun) throws Exception;
}
