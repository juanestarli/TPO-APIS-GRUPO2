package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import daoInterf.DAOEdificioInt;
import model.Edificio;

public class DAOEdificio extends Conexion implements DAOEdificioInt{
	
	@Override
	public List<Edificio> getAll() throws Exception {
	    List<Edificio> edificios = null;
	    try {
	        String getQuery = "SELECT * FROM edificio";
	        PreparedStatement statement = this.conexion.prepareStatement(getQuery);
	        edificios = new ArrayList<>();
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            Edificio edificio = new Edificio( rs.getString("calle"), rs.getInt("altura"));
	            edificio.setIdEdificio(rs.getInt("idEdificio"));
	            edificios.add(edificio);
	        }
	        rs.close();
	        statement.close();
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
	    return edificios;
	}

	@Override
	public void create(Edificio edificio) throws Exception {
	    try {
	        this.conectar();
	        String insertQuery = "INSERT INTO edificio(idEdificio, altura, calle) VALUES (?, ?, ?)";
	        PreparedStatement statement = this.conexion.prepareStatement(insertQuery);

	        // Establecer los valores en la query
	        statement.setInt(1, edificio.getIdEdificio());
	        statement.setInt(2, edificio.getAltura());
	        statement.setString(3, edificio.getCalle());

	        // Ejecutar la inserción en la base de datos
	        statement.executeUpdate();
	        System.out.println("Edificio con ID " + edificio.getIdEdificio() + " persistido en la base de datos.");

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
	}

	@Override
	public void read(Edificio edi) throws Exception {
	    int id = edi.getIdEdificio();
	    Edificio edificio = null;
	    try {
	        String getQuery = "SELECT * FROM edificio WHERE idEdificio=?";
	        PreparedStatement statement = this.conexion.prepareStatement(getQuery);
	        statement.setInt(1, id);
	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            edificio = new Edificio(rs.getString("calle"), rs.getInt("altura"));
	            edificio.setIdEdificio(rs.getInt("idEdificio"));
	            System.out.println("Info del Edificio:");
	            System.out.println("ID del Edificio: " + edificio.getIdEdificio());
	            System.out.println("Altura: " + edificio.getAltura());
	            System.out.println("Calle: " + edificio.getCalle());
	        } else {
	            System.out.println("No se encontró un edificio con ID " + id);
	        }

	        rs.close();
	        statement.close();
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
	}

	@Override
	public void update(Edificio edificio) throws Exception {
	    try {
	        this.conectar();
	        String updateQuery = "UPDATE edificio SET altura=?, calle=? WHERE idEdificio=?";
	        PreparedStatement statement = this.conexion.prepareStatement(updateQuery);

	        // Establecer los valores en la query
	        statement.setInt(1, edificio.getAltura());
	        statement.setString(2, edificio.getCalle());
	        statement.setInt(3, edificio.getIdEdificio());

	        // Ejecutar la actualización en la base de datos
	        int filasActualizadas = statement.executeUpdate();

	        if (filasActualizadas > 0) {
	            System.out.println("Edificio con ID " + edificio.getIdEdificio() + " actualizado en la base de datos.");
	        } else {
	            System.out.println("No se pudo actualizar el edificio con ID " + edificio.getIdEdificio());
	        }

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
	}

	@Override
	public void delete(Edificio edificio) throws Exception {
	    try {
	        this.conectar();
	        String deleteQuery = "DELETE FROM edificio WHERE idEdificio=?";
	        PreparedStatement statement = this.conexion.prepareStatement(deleteQuery);

	        // Establecer los valores en la query
	        statement.setInt(1, edificio.getIdEdificio());

	        // Ejecutar la eliminación en la base de datos
	        int filasEliminadas = statement.executeUpdate();

	        if (filasEliminadas > 0) {
	            System.out.println("Edificio con ID " + edificio.getIdEdificio() + " eliminado de la base de datos.");
	        } else {
	            System.out.println("No se pudo eliminar el edificio con ID " + edificio.getIdEdificio());
	        }

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.desconectar();
	    }
	}


}
