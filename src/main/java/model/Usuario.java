package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUsuario;
	private String nombre;
	private String apellido;
	private String dni;
	private String contraseña;
	private ArrayList<Unidad> propiedades;
	private Unidad vivienda;


	public Usuario(String nombre, String apellido, String dni, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.contraseña = contraseña;
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

	public int getUsuario() {
		return IdUsuario;
	}


	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", usuario=" + IdUsuario
				+ ", contraseña=" + contraseña + "]";
	}

	public Unidad getVivienda() {
		return vivienda;
	}

	public void setVivienda(Unidad vivienda) {
		this.vivienda = vivienda;
	}

	public ArrayList<Unidad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<Unidad> propiedades) {
		this.propiedades = propiedades;
	}

}
