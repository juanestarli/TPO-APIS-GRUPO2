package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reclamo")
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReclamo;
	@ManyToOne
    @JoinColumn(name = "IdUsuario")
	private Usuario usuario;
	@ManyToOne
    @JoinColumn(name = "idEdificio")
	private Edificio edificio;
	@ManyToOne
    @JoinColumn(name = "idDepartamento")
	private Departamento departamento;
	@ManyToOne
    @JoinColumn(name = "idEspacioComun")
	private EspacioComun espacioComun;
	private String descripcion;
	private String foto;
	private String estadoReclamo;
	@OneToOne(mappedBy = "reclamo", cascade = CascadeType.ALL)
	private RespuestaReclamo respuesta;
	
	
	public Reclamo (Usuario usuario, Edificio edificio, Departamento departamento, EspacioComun esp,String descripcion, String foto) {
		super();
		
		this.usuario = usuario;
		this.edificio = edificio;
		this.departamento = departamento;
		this.espacioComun = esp;
		this.descripcion = descripcion;
		this.foto = foto;
	}
	
	public int getIdReclamo() {
		return idReclamo;
	}
	
	public void setIdReclamo(int idReclamo) {
		idReclamo = idReclamo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Edificio getEdificio() {
		return edificio;
	}
	
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public RespuestaReclamo getRespuesta() {
		return respuesta;
	}
	
	public void setRespuesta(RespuestaReclamo respuesta) {
		this.respuesta = respuesta;
	}
	
	public String getEstadoReclamo() {
		return estadoReclamo;
	}
	
	public void setEstadoReclamo(String estadoReclamo) {
		this.estadoReclamo = estadoReclamo;
	}
	
	public Departamento getDepartamento() {
		return this.departamento;
	}
	
	public EspacioComun getEspacioComun() {
		return this.espacioComun;
	}
	
	
	
}
