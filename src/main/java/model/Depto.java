package model;

import java.util.ArrayList;
import java.util.List;

public class Depto extends Unidad{
	private String depto;
	private Usuario Propietario;
	private ArrayList<Usuario> Inquilinos;
	private boolean alquiler;
	
	
	public Depto(String depto, Usuario propietario, ArrayList<Usuario> inqulinos, boolean alquiler) {
		super();
		this.depto = depto;
		Propietario = propietario;
		Inquilinos = inqulinos;
		this.alquiler = alquiler;
	}
	public void AgregarInquilino(Usuario inquilino) {
		Inquilinos.add(inquilino);
	}
	
	public void EliminarInquilino(Usuario inquilino) {
		Inquilinos.remove(inquilino);
	}
	
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public Usuario getPropietario() {
		return Propietario;
	}
	public void setPropietario(Usuario propietario) {
		Propietario = propietario;
	}
	public ArrayList<Usuario> getInqulinos() {
		return Inquilinos;
	}
	public void setInqulinos(ArrayList<Usuario> inqulinos) {
		Inquilinos = inqulinos;
	}
	public boolean isAlquiler() {
		return alquiler;
	}
	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}
	
	
}
