package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Departamento{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDepartamento;
	private int piso;
	private char unidad;
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario propietario;
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Usuario> inquilinos =  new ArrayList<Usuario>();
	@Column(name = "alquiler")
	private boolean alquiler;
	
	
	public Departamento(int Piso, char unidad, Usuario propietario, boolean alquiler) {
		this.setPiso(Piso);
		this.setUnidad(unidad);
		this.propietario= propietario;
		this.alquiler = alquiler;
	}
	
	public void AgregarInquilino(Usuario inquilino) {
		inquilinos.add(inquilino);
	}
	
	public void EliminarInquilino(Usuario inquilino) {
		inquilinos.remove(inquilino);
	}
	
	public Usuario getPropietario() {
		return propietario;
	}
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	public List<Usuario> getInqulinos() {
		return inquilinos;
	}
	public void setInqulinos(List<Usuario> inqulinos) {
		inquilinos = inqulinos;
	}
	public boolean isAlquiler() {
		return alquiler;
	}
	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public char getUnidad() {
		return unidad;
	}

	public void setUnidad(char unidad) {
		this.unidad = unidad;
	}
	
	
}