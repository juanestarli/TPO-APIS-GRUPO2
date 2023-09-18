package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EspacioComun{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspacioComun;
	private int piso;
	private String nombre;
	private String descripcion;
	
	
	public EspacioComun( int piso, String nombre, String descripcion) {
		this.setPiso(piso);
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	
}
