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
	private List<Unidad> Unidades;
	private List<Departamento> departamentos;
	private List<Usuario> usuarios;
	
	
	
	public Edificio(String calle, int altura, ArrayList<Unidad> unidades) {
		super();
		Calle = calle;
		Altura = altura;
		Unidades = unidades;
		
	}
	
	public Edificio() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Unidad> getUnidades() {
		return Unidades;
	}
	public void setUnidades(List<Unidad> unidades) {
		Unidades = unidades;
	}
	@Override
	public String toString() {
		return "Edificio [IdEdificio=" + IdEdificio + ", Calle=" + Calle + ", Altura=" + Altura + ", Unidades="
				+ Unidades + "]";
	}
	public List<Departamento> getDepartamentos(){
		return this.departamentos;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
}
