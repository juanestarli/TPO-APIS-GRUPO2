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
	private Usuario usuario;
	private Edificio edificio;
	private Departamento departamento;
	private EspacioComun espacioComun;
	private String descripcion;
	private String foto;
	private String estadoReclamo;
	private RespuestaReclamo respuesta;
	
	
	public Reclamo (Usuario usuario, model.Edificio edificio, Departamento departamento,EspacioComun esp,String descripcion, String foto) {
		super();
		
		this.usuario = usuario;
		this.edificio = edificio;
		this.departamento = departamento;
		this.espacioComun = esp;
		this.descripcion = descripcion;
		this.foto = foto;
	}
	public int getIdReclamo() {
		return IdReclamo;
	}
	public void setIdReclamo(int idReclamo) {
		IdReclamo = idReclamo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		usuario = usuario;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		edificio = edificio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		foto = foto;
	}
	public RespuestaReclamo getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaReclamo respuesta) {
		respuesta = respuesta;
	}
	public String getEstadoReclamo() {
		return estadoReclamo;
	}
	public void setEstadoReclamo(String estadoReclamo) {
		estadoReclamo = estadoReclamo;
	}
	
	
	
}
