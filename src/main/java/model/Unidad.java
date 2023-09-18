package model;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Unidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUnidad;
	private int Piso;
	
	
	public Unidad( int piso) {
		Piso = piso;
	}
	
	public int getPiso() {
		return Piso;
	}
	public void setPiso(int piso) {
		Piso = piso;
	}
	
	public int getId() {
		return IdUnidad;
	}
	
}
