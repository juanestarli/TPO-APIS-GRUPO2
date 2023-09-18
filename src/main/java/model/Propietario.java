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
	private int IdPropietario;
	@OneToMany(mappedBy = "IdPropietario", cascade = CascadeType.ALL)
	private List<Departamento> propiedades = new ArrayList<>();
	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	private List<Reclamo> reclamos = new ArrayList<>();

	public Propietario(String nombre, String apellido, String dni, String contraseña) {
		super(nombre, apellido, dni, contraseña);
		this.IdPropietario=super.getId();
		
	}


	public void addPropiedades(Departamento depto ) {
		propiedades.add(depto);
	}
	
	public List<Departamento> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Departamento> propiedades) {
		this.propiedades = propiedades;
	}


	public int getIdPropietario() {
		return IdPropietario;
	}





	

	

	
	
	

}
