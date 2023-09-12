package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Inquilino")
public class Inquilino extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdInquilino;
	@ManyToOne
	@JoinColumn(name = "IdDepto")
	private Depto Depto;
	
	
	public Inquilino(String nombre, String apellido, String dni, String contraseña, Depto depto) {
		super(nombre, apellido, dni, contraseña);
		Depto = depto;
	}


	public int getIdInquilino() {
		return IdInquilino;
	}


	public void setIdInquilino(int idInquilino) {
		IdInquilino = idInquilino;
	}


	public Depto getDepto() {
		return Depto;
	}


	public void setDepto(Depto depto) {
		Depto = depto;
	}
	
	
	
	
	
	

}
