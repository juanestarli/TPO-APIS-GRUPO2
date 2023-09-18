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
import model.*;

@Entity
@Table(name = "Inquilino")
public class Inquilino extends Usuario{
	private int IdInquilino; 
	@ManyToOne
	@JoinColumn(name = "IdDepto")
	private Departamento depto;
	@OneToMany(mappedBy = "Inquilino", cascade = CascadeType.ALL)
	private List<Reclamo> reclamos = new ArrayList<>();
	
	
	public Inquilino(String nombre, String apellido, String dni, String contraseña, Departamento depto) {
		super(nombre, apellido, dni, contraseña);
		this.depto = depto;
		this.IdInquilino = super.getId();
	}


	
	public List<Reclamo> getReclamos(){
		return reclamos;
	}
	
	public void addReclamo(Reclamo r){
		reclamos.add(r);
	}

	public Departamento getDepto() {
		return depto;
	}


	public void setDepto(Departamento depto) {
		this.depto = depto;
	}


	
	
	
	
	
	
	

}
