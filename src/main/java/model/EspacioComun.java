package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EspacioComun{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspacioComun;
	@ManyToOne
	@JoinColumn(name = "edificio")
	private Edificio edificio;
	private int piso;
	private String nombre;
	private String descripcion;
	
	
	public EspacioComun( int piso, String nombre, String descripcion) {
		this.setPiso(piso);
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public EspacioComun(int id, String desc, String nombre, int piso, Edificio edificio2) {
		// TODO Auto-generated constructor stub
		this.idEspacioComun=id;
		this.descripcion=desc;
		this.nombre=nombre;
		this.piso=piso;
		this.edificio=edificio2;
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

	public int getId() {
		return idEspacioComun;
	}

	public Edificio getEdificio() {
		// TODO Auto-generated method stub
		return this.edificio;
	}
	
	
}
