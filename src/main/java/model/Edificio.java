package model;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdEdificio;
	private String Calle;
	private int Altura;
	private ArrayList<Unidad> Unidades;
	private ArrayList<Depto> departamentos;
	private ArrayList<Usuario> usuarios;
	
	
	
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
	public ArrayList<Unidad> getUnidades() {
		return Unidades;
	}
	public void setUnidades(ArrayList<Unidad> unidades) {
		Unidades = unidades;
	}
	@Override
	public String toString() {
		return "Edificio [IdEdificio=" + IdEdificio + ", Calle=" + Calle + ", Altura=" + Altura + ", Unidades="
				+ Unidades + "]";
	}
	public ArrayList<Depto> getDepartamentos(){
		return this.departamentos;
	}

	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
}
