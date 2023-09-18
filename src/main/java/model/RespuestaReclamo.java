package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RespuestaReclamo")
public class RespuestaReclamo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRespuesta;
	@OneToOne
    @JoinColumn(name = "idReclamo")
	private Reclamo reclamo;
	private String descripcion;
	
	
	public RespuestaReclamo(int idRespuesta, model.Reclamo reclamo, String descripcion) {
		super();
		this.idRespuesta = idRespuesta;
		this.reclamo = reclamo;
		this.descripcion = descripcion;
	}
	
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public Reclamo getReclamo() {
		return reclamo;
	}
	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
