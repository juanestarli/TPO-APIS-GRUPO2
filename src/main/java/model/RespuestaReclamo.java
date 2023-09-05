package model;

public class RespuestaReclamo {
	private int IdRespuesta;
	private Reclamo Reclamo;
	private String Descripcion;
	
	
	public RespuestaReclamo(int idRespuesta, model.Reclamo reclamo, String descripcion) {
		super();
		IdRespuesta = idRespuesta;
		Reclamo = reclamo;
		Descripcion = descripcion;
	}
	
	public int getIdRespuesta() {
		return IdRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		IdRespuesta = idRespuesta;
	}
	public Reclamo getReclamo() {
		return Reclamo;
	}
	public void setReclamo(Reclamo reclamo) {
		Reclamo = reclamo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
