package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Usuario")
@Component
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	private String nombre;
	private String apellido;
	private String dni;
	private String contrasena;
	
	@ManyToOne
	@JoinColumn(name = "departamento")
	@Autowired
	private Departamento vivienda;
	
	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	@Autowired
	private List<Departamento> propiedades = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@Autowired
	private List<Reclamo> reclamos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "edificio")
	@Autowired
	private Edificio edificio;
	


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public List<Departamento> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Departamento> propiedades) {
		this.propiedades = propiedades;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

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



	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [nombre = " + nombre + ", apellido = " + apellido + ", dni = " + dni + ", contrasena = " + contrasena + "]";
	}
	
	public int getId() {
		return idUsuario;
	}

	public Departamento getVivienda() {
		return vivienda;
	}

	public void setVivienda(Departamento vivienda) {
		this.vivienda = vivienda;
	}

	public void agregarPropiedad(Departamento dept) {
		propiedades.add(dept);
	}
	

	

}
