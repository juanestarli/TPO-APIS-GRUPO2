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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Edificio")
@Component
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	
	private String calle;
	private int altura;
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	@Autowired
	private List<EspacioComun> espaciosComunes;
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	@Autowired
	private List<Departamento> departamentos;
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	@Autowired
	private List<Usuario> usuarios = new ArrayList<>();
	
	
	public Edificio() {
		super();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Edificio(String calle, int altura) {
		super();
		this.calle = calle;
		this.altura = altura;
		espaciosComunes = new ArrayList<>();
		departamentos = new ArrayList<>();
		
	}
	
	public int getIdEdificio() {
		return idEdificio;
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public List<EspacioComun> getEspaciosComunes() {
		return espaciosComunes;
	}
	public void setEspaciosComunes(List<EspacioComun> espaciosComunes) {
		this.espaciosComunes = espaciosComunes;
	}
	@Override
	public String toString() {
		return "Edificio [IdEdificio = " + idEdificio + ", Calle = " + calle + ", Altura = " + altura + ", Departamentos = "
				+ getUnidadesString() + ", Altura = " + altura + "]";
	}
	private ArrayList<String> getUnidadesString() {
		ArrayList<String> unidades = new ArrayList<>();
		for (Departamento u : departamentos) {
			unidades.add(u.getPiso() + " " + u.getUnidad());
		}
		return unidades;
	}

	public List<Departamento> getDepartamentos(){
		return this.departamentos;
	}
	
	public void addUsuarios(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	public void removeUsuarios(Usuario usuario) {
		this.usuarios.remove(usuario);
	}

	public void setIdEdificio(int int1) {
		// TODO Auto-generated method stub
		this.idEdificio=int1;
		
	}


	
	
}
