package model;

public class EspacioComun extends Unidad{
	
	private String nombre;
	private String descripcion;
	
	
	public EspacioComun( int Piso, String nombre, String descripcion) {
		super(Piso);
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
	
	
}
