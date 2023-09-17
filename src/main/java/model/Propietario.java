package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Propietario")
public class Propietario extends Usuario{
	
	@OneToMany(mappedBy = "IdPropietario", cascade = CascadeType.ALL)
	private List<Depto> Propiedades;
	@OneToMany(mappedBy = "IdPropietario", cascade = CascadeType.ALL)
	private ArrayList<Reclamo> reclamos;

	public Propietario(String nombre, String apellido, String dni, String contraseña) {
		super(nombre, apellido, dni, contraseña);
		// TODO Auto-generated constructor stub
		this.Propiedades= new ArrayList<>();
	}


	public void addPropiedades(Depto depto ) {
		Propiedades.add(depto);
	}
	
	public List<Depto> getPropiedades() {
		return Propiedades;
	}

	public void setPropiedades(List<Depto> propiedades) {
		Propiedades = propiedades;
	}



	

	

	
	
	

}
