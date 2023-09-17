package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Inquilino")
public class Inquilino extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdInquilino;
	@ManyToOne
	@JoinColumn(name = "IdDepto")
	private Depto depto;
	@OneToMany(mappedBy = "IdInquilino", cascade = CascadeType.ALL)
	private ArrayList<Reclamo> reclamos;
	
	
	public Inquilino(String nombre, String apellido, String dni, String contraseña, Depto depto) {
		super(nombre, apellido, dni, contraseña);
		this.depto = depto;
	}


	


	public Depto getDepto() {
		return depto;
	}


	public void setDepto(Depto depto) {
		this.depto = depto;
	}


	
	
	
	
	
	
	

}
