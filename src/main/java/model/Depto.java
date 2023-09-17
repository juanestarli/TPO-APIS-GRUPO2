package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Depto")
public class Depto extends Unidad{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String IdDepto;
	@ManyToOne
	@JoinColumn(name = "IdPropietario")
	private Propietario Propietario;
	@OneToMany(mappedBy = "depto", cascade = CascadeType.ALL)
	private List<Inquilino> Inquilinos;
	private boolean alquiler;
	
	
	public Depto(int Piso, Propietario propietario, List<Inquilino> inqulinos, boolean alquiler) {
		super(Piso);
		Propietario = propietario;
		Inquilinos = new ArrayList<Inquilino>() ;
		this.alquiler = alquiler;
	}
	
	
	
	public Depto(int Piso, Propietario propietario, boolean alquiler) {
		super(Piso);
		Propietario = propietario;
		this.alquiler = alquiler;
	}
	
	public void AgregarInquilino(Inquilino inquilino) {
		Inquilinos.add(inquilino);
	}
	
	public void EliminarInquilino(Inquilino inquilino) {
		Inquilinos.remove(inquilino);
	}
	
	public String getIdDepto() {
		return IdDepto;
	}
	public void setDepto(String IdDepto) {
		this.IdDepto = IdDepto;
	}
	public Usuario getPropietario() {
		return Propietario;
	}
	public void setPropietario(Propietario propietario) {
		Propietario = propietario;
	}
	public List<Inquilino> getInqulinos() {
		return Inquilinos;
	}
	public void setInqulinos(List<Inquilino> inqulinos) {
		Inquilinos = inqulinos;
	}
	public boolean isAlquiler() {
		return alquiler;
	}
	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}
	
	
}
