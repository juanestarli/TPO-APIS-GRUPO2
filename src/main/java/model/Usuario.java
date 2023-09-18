package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUsuario;
	private String nombre;
	private String apellido;
	private String dni;
	private String contrasena;
	private Departamento vivienda;
	@OneToMany(mappedBy = "IdUsuario", cascade = CascadeType.ALL)
	private List<Departamento> propiedades = new ArrayList<>();
	@OneToMany(mappedBy = "IdUsuario", cascade = CascadeType.ALL)
	private List<Reclamo> reclamos = new ArrayList<>();
	
	


	public Usuario(String nombre, String apellido, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.contrasena = contrasena;
		this.vivienda=null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getContraseña() {
		return contrasena;
	}

	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", contrasena=" + contrasena + "]";
	}
	
	public int getId() {
		return IdUsuario;
	}

	public Departamento getVivienda() {
		return vivienda;
	}

	public void setVivienda(Departamento vivienda) {
		this.vivienda = vivienda;
	}
	

	

}
