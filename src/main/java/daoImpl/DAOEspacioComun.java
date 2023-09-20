package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import daoInterf.DAOEspacioComunInt;
import model.Edificio;
import model.EspacioComun;

public class DAOEspacioComun extends Conexion implements DAOEspacioComunInt{

	@Override
	public List<EspacioComun> getAll() throws Exception {
		List<EspacioComun> espaciosComunes = null;
	    try {
	        String getQuery = "SELECT * FROM espaciocomun";
	        PreparedStatement statement = this.conexion.prepareStatement(getQuery);
	        espaciosComunes = new ArrayList<>();
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            EspacioComun espacioComun = new EspacioComun(
	                rs.getInt("idEspacioComun"),
	                rs.getString("descripcion"),
	                rs.getString("nombre"),
	                rs.getInt("piso"),
	                (Edificio)rs.getObject("edificio"));
	            espaciosComunes.add(espacioComun);
	        }
	        rs.close();
	        statement.close();
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
	    return espaciosComunes;
	}

	@Override
	public void create(EspacioComun espacioComun) throws Exception {
		try {
	        this.conectar();
	        String insertQuery = "INSERT INTO espaciocomun(idEspacioComun, descripcion, nombre, piso, edificio) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement statement = this.conexion.prepareStatement(insertQuery);

	        // Establecer los valores en la query
	        statement.setInt(1, espacioComun.getId());
	        statement.setString(2, espacioComun.getDescripcion());
	        statement.setString(3, espacioComun.getNombre());
	        statement.setInt(4, espacioComun.getPiso());
	        statement.setObject(5, espacioComun.getEdificio());

	        // Ejecutar la inserción en la base de datos
	        statement.executeUpdate();
	        System.out.println("Espacio Común con ID " + espacioComun.getId() + " persistido en la base de datos.");

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
		
	}

	@Override
	public void read(EspacioComun espacioComun) throws Exception {
		    int id = espacioComun.getId();
		    EspacioComun e = null;
		    try {
		        String getQuery = "SELECT * FROM espaciocomun WHERE idEspacioComun=?";
		        PreparedStatement statement = this.conexion.prepareStatement(getQuery);
		        statement.setInt(1, id);
		        ResultSet rs = statement.executeQuery();

		        if (rs.next()) {
		            e = new EspacioComun(
		                rs.getInt("idEspacioComun"),
		                rs.getString("descripcion"),
		                rs.getString("nombre"),
		                rs.getInt("piso"),
		                (Edificio) rs.getObject("edificio")
		            );
		            System.out.println("Info del Espacio Común:");
		            System.out.println("ID del Espacio Común: " + e.getId());
		            System.out.println("Descripción: " + e.getDescripcion());
		            System.out.println("Nombre: " + e.getNombre());
		            System.out.println("Piso: " + e.getPiso());
		            System.out.println("Edificio: " + e.getEdificio());
		        } else {
		            System.out.println("No se encontró un Espacio Común con ID " + id);
		        }

		        rs.close();
		        statement.close();
		    } catch (Exception excep) {
		        throw excep;
		    } finally {
		        this.desconectar();
		    }
		
	}

	@Override
	public void update(EspacioComun espacioComun) throws Exception {
		try {
	        this.conectar();
	        String updateQuery = "UPDATE espaciocomun SET descripcion=?, nombre=?, piso=?, edificio=? WHERE idEspacioComun=?";
	        PreparedStatement statement = this.conexion.prepareStatement(updateQuery);

	        // Establecer los valores en la query
	        statement.setString(1, espacioComun.getDescripcion());
	        statement.setString(2, espacioComun.getNombre());
	        statement.setInt(3, espacioComun.getPiso());
	        statement.setObject(4, espacioComun.getEdificio());
	        statement.setInt(5, espacioComun.getId());

	        // Ejecutar la actualización en la base de datos
	        int filasActualizadas = statement.executeUpdate();

	        if (filasActualizadas > 0) {
	            System.out.println("Espacio Común con ID " + espacioComun.getId() + " actualizado en la base de datos.");
	        } else {
	            System.out.println("No se pudo actualizar el Espacio Común con ID " + espacioComun.getId());
	        }

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
		
	}

	@Override
	public void delete(EspacioComun espacioComun) throws Exception {
		try {
	        this.conectar();
	        String deleteQuery = "DELETE FROM espaciocomun WHERE idEspacioComun=?";
	        PreparedStatement statement = this.conexion.prepareStatement(deleteQuery);

	        // Establecer los valores en la query
	        statement.setInt(1, espacioComun.getId());

	        // Ejecutar la eliminación en la base de datos
	        int filasEliminadas = statement.executeUpdate();

	        if (filasEliminadas > 0) {
	            System.out.println("Espacio Común con ID " + espacioComun.getId() + " eliminado de la base de datos.");
	        } else {
	            System.out.println("No se pudo eliminar el Espacio Común con ID " + espacioComun.getId());
	        }

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
		
	}

}
