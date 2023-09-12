package model;

import java.util.ArrayList;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Unidad {
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
	
	
}
