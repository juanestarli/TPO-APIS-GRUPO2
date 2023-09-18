package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdEdificio;
	private String Calle;
	private int Altura;
	private List<EspacioComun> espaciosComunes;
	private List<Departamento> departamentos;
	private List<Usuario> usuarios;
	
	
	
	public Edificio(String calle, int altura) {
		super();
		Calle = calle;
		Altura = altura;
		espaciosComunes = new ArrayList<>();
		departamentos = new ArrayList<>();
		
	}
	
	public int getIdEdificio() {
		return IdEdificio;
	}
	
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public int getAltura() {
		return Altura;
	}
	public void setAltura(int altura) {
		Altura = altura;
	}
	public List<EspacioComun> getEspaciosComunes() {
		return espaciosComunes;
	}
	public void setEspaciosComunes(List<EspacioComun> espaciosComunes) {
		this.espaciosComunes = espaciosComunes;
	}
	@Override
	public String toString() {
		return "Edificio [IdEdificio=" + IdEdificio + ", Calle=" + Calle + ", Altura=" + Altura + ", Unidades="
				+ departamentos + ", Altura=" + espaciosComunes + "]";
	}
	public List<Departamento> getDepartamentos(){
		return this.departamentos;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
}
