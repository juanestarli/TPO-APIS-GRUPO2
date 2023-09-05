package model;

import java.util.ArrayList;


public class Unidad {
	private int IdUnidad;
	private int Piso;
	
	
	public Unidad( int piso) {
		Piso = piso;
	}
	public int getIdUnidad() {
		return IdUnidad;
	}
	public void setIdUnidad(int idUnidad) {
		IdUnidad = idUnidad;
	}
	public int getPiso() {
		return Piso;
	}
	public void setPiso(int piso) {
		Piso = piso;
	}
	
	
}
