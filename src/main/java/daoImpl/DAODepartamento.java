package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.Session;

import model.*;
import daoInterf.DAODepartamentoInt;


public class DAODepartamento extends Conexion implements DAODepartamentoInt{

	@Override
	public List<Departamento> getAll() throws Exception {
		List<Departamento> departamentos = null;
		try {
			

			String getQuery = "SELECT * FROM departamento";
			PreparedStatement statement = this.conexion.prepareStatement(getQuery);
			departamentos = new ArrayList<>();
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Departamento d = new Departamento(rs.getInt("piso"), rs.getString("unidad"), (Usuario) rs.getObject("usuario"), rs.getBoolean("alquiler"));
				departamentos.add(d);
			}
			rs.close();			
			statement.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
		return departamentos;
	}
	

	@Override
	public void create(Departamento departamento) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.conectar();

			String insertQuery = "INSERT INTO departamento(idDepartamento, alquiler, piso, unidad, edificio, usuario) VALUES (?, ?, ?, ?, ?,?)";
			PreparedStatement statement = this.conexion.prepareStatement(insertQuery);

			// Establecer los valores en la query
			statement.setInt(1, departamento.getId());
			statement.setBoolean(2, departamento.isAlquiler());
			statement.setInt(3, departamento.getPiso());
			statement.setString(4, departamento.getUnidad());
			statement.setInt(5, departamento.getEdificio());
			statement.setInt(6, departamento.getPropietario());

			// Ejecutar la inserción en la base de datos
			statement.executeUpdate();
			System.out.println("Departamento '" + departamento.getId() + "' persistido en la base de datos.");

		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}
		
	

	@Override
	public void read(Departamento departamento) throws Exception {
		int id = departamento.getId();
		Departamento d = null;
		try {
			String getQuery = "SELECT * FROM departamento where idDepartamento ={id}";
			PreparedStatement statement = this.conexion.prepareStatement(getQuery);
			ResultSet rs = statement.executeQuery();
			
			d = new Departamento(rs.getInt("piso"), rs.getString("unidad"), (Usuario) rs.getObject("usuario"), rs.getBoolean("alquiler")); 
			d.setIdDepartamento(rs.getInt("idDepartamento"));
			d.setEdificio((Edificio) rs.getObject("edificio"));
			System.out.println("Info del Departamento:");
			System.out.println("Piso: " + d.getPiso());
			System.out.println("Unidad: " + d.getUnidad());
			System.out.println("Usuario: " + d.getPropietario()); // Suponiendo que Usuario tiene un atributo 'nombre'
			System.out.println("Alquiler: " + d.isAlquiler());
			System.out.println("ID del Departamento: " + d.getId());
			System.out.println("Edificio: " + d.getEdificio());
			rs.close();			
			statement.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
		
		
	}

	@Override
	public void update(Departamento departamento) throws Exception {
		try {
			this.conectar();

			String updateQuery = "UPDATE departamento SET alquiler=?, piso=?, unidad=?, edificio=?, usuario=? WHERE idDepartamento=?";
			PreparedStatement statement = this.conexion.prepareStatement(updateQuery);

			// Establecer los valores en la query
			statement.setBoolean(1, departamento.isAlquiler());
			statement.setInt(2, departamento.getPiso());
			statement.setString(3, departamento.getUnidad());
			statement.setObject(4, departamento.getEdificio()); 
			statement.setObject(5, departamento.getPropietario());   
			statement.setInt(6, departamento.getId());

			// Ejecutar la inserción en la base de datos
			int filasActualizadas = statement.executeUpdate();

			if (filasActualizadas > 0) {
			    System.out.println("Departamento con ID " + departamento.getId() + " actualizado en la base de datos.");
			} else {
			    System.out.println("No se pudo actualizar el departamento con ID " + departamento.getId());
			}

		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
		
	}

	@Override
	public void delete(Departamento departamento) throws Exception {
		try {
			this.conectar();

			String deleteQuery = "DELETE FROM departamento WHERE idDepartamento=?";
			PreparedStatement statement = this.conexion.prepareStatement(deleteQuery);

			// Establecer los valores en la query
			statement.setInt(1, departamento.getId());

			// Ejecutar la eliminaci�n en la base de datos
			int filasEliminadas = statement.executeUpdate();

			if (filasEliminadas > 0) {
			    System.out.println("Departamento con ID " + departamento.getId() + " eliminado de la base de datos.");
			} else {
			    System.out.println("No se pudo eliminar el departamento con ID " + departamento.getId());
			}

		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
		
	}

}
