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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Reclamo")
@Component
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReclamo;
	
	@ManyToOne
    @JoinColumn(name = "IdUsuario")
	@Autowired
	private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "idEdificio")
	@Autowired
	private Edificio edificio;
	
	@ManyToOne
    @JoinColumn(name = "idDepartamento")
	@Autowired
	private Departamento departamento;
	
	@ManyToOne
    @JoinColumn(name = "idEspacioComun")
	@Autowired
	private EspacioComun espacioComun;
	
	private String descripcion;
	private String foto;
	private String estadoReclamo;
	
	@OneToOne(mappedBy = "reclamo", cascade = CascadeType.ALL)
	@Autowired
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
	
	public Reclamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdReclamo() {
		return idReclamo;
	}
	
	public void setIdReclamo(int idReclamo) {
		this.idReclamo = idReclamo;
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
