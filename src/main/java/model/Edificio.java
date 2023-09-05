package model;

import java.util.ArrayList;

public class Edificio {
	private int IdEdificio;
	private String Calle;
	private int Altura;
	private ArrayList<Unidad> Unidades;
	
	
	
	public Edificio(int idEdificio, String calle, int altura, ArrayList<Unidad> unidades) {
		super();
		IdEdificio = idEdificio;
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
	public void setIdEdificio(int idEdificio) {
		IdEdificio = idEdificio;
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
	
	
}
