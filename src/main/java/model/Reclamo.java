package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reclamo")
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdReclamo;
	@ManyToOne
	@JoinColumn(name = "IdUsuario")
	private Usuario Usuario;
	private Edificio Edificio;
	private Unidad Unidad;
	private String Descripcion;
	private String Foto;
	private String EstadoReclamo;
	private RespuestaReclamo Respuesta;
	
	
	public Reclamo (Usuario usuario, model.Edificio edificio, model.Unidad unidad,
			String descripcion, String foto) {
		super();
		
		Usuario = usuario;
		Edificio = edificio;
		Unidad = unidad;
		Descripcion = descripcion;
		Foto = foto;
	}
	public int getIdReclamo() {
		return IdReclamo;
	}
	public void setIdReclamo(int idReclamo) {
		IdReclamo = idReclamo;
	}
	public Usuario getUsuario() {
		return Usuario;
	}
	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
	public Edificio getEdificio() {
		return Edificio;
	}
	public void setEdificio(Edificio edificio) {
		Edificio = edificio;
	}
	public Unidad getUnidad() {
		return Unidad;
	}
	public void setUnidad(Unidad unidad) {
		Unidad = unidad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getFoto() {
		return Foto;
	}
	public void setFoto(String foto) {
		Foto = foto;
	}
	public RespuestaReclamo getRespuesta() {
		return Respuesta;
	}
	public void setRespuesta(RespuestaReclamo respuesta) {
		Respuesta = respuesta;
	}
	public String getEstadoReclamo() {
		return EstadoReclamo;
	}
	public void setEstadoReclamo(String estadoReclamo) {
		EstadoReclamo = estadoReclamo;
	}
	
	
	
}
