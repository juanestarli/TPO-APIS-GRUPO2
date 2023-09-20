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
	private int idDepartamento;
	private int piso;
	private String unidad;
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario propietario;
	@OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL)
	private List<Usuario> inquilinos =  new ArrayList<Usuario>();
	@ManyToOne
	@JoinColumn(name = "edificio")
	private Edificio edificio;
	@Column(name = "alquiler")
	private boolean alquiler;
	
	
	public Departamento(int Piso, String unidad, Usuario propietario, boolean alquiler) {
		this.setPiso(Piso);
		this.setUnidad(unidad);
		this.propietario= propietario;
		this.alquiler = alquiler;
		
	}
	
	public void AgregarInquilino(Usuario inquilino) {
		inquilinos.add(inquilino);
		this.edificio.addUsuarios(inquilino);
	}
	
	public void EliminarInquilino(Usuario inquilino) {
		inquilinos.remove(inquilino);
		this.edificio.addUsuarios(propietario);
	}
	
	public int getPropietario() {
		return propietario.getId();
	}
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
		this.edificio.addUsuarios(propietario);
	}
	public List<Usuario> getInqulinos() {
		return inquilinos;
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

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad2) {
		this.unidad = unidad2;
	}

	public int getId() {
		return idDepartamento;
	}


	public List<Usuario> getInquilinos() {
		return inquilinos;
	}

	public int getEdificio() {
		return edificio.getIdEdificio();
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public void setIdDepartamento(int int1) {
		// TODO Auto-generated method stub
		this.idDepartamento = int1;
		
	}
	

	
	
}
