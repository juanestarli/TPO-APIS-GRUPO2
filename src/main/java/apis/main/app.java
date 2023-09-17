package apis.main;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.*;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		conf.addAnnotatedClass(Usuario.class);
		conf.addAnnotatedClass(Unidad.class);
		conf.addAnnotatedClass(Inquilino.class);
		conf.addAnnotatedClass(Propietario.class);
		conf.addAnnotatedClass(Depto.class);
		conf.addAnnotatedClass(Edificio.class);
		conf.addAnnotatedClass(EspacioComun.class);
		conf.addAnnotatedClass(Reclamo.class);
		conf.addAnnotatedClass(RespuestaReclamo.class);
		
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		Edificio arcos2000 = new Edificio("Arcos", 2000, new ArrayList<Unidad>());
		Propietario Juan = new Propietario("Juan","Estarli","44161556","Juan1234");
		Depto piso7b = new Depto(7,Juan,false);
		Depto piso5a = new Depto(5,Juan,false);
		Depto piso3b = new Depto(3,Juan,false);
		EspacioComun Pileta = new EspacioComun(15, "Pileta", "Sector pileta");
		

		tx.commit();
	}

	public static void oneToMany(Session session) {

		Propietario juan = new Propietario("Juan", "Estarli", "44161556", "juan1234");
		Depto depto1 = new Depto(7, juan, false);
		Depto depto2 = new Depto(8, juan, false);
		
		juan.getPropiedades().add(depto1);
		juan.getPropiedades().add(depto2);
		depto1.setPropietario(juan);
		depto2.setPropietario(juan);

		session.beginTransaction();

		session.save(juan);
		session.getTransaction().commit();

		// Mostrando el registro insertado
		session.beginTransaction();
		Propietario res = session.get(Propietario.class, 1);
		session.getTransaction().commit();
		System.out.println(res);

	}
	//------------------- NUEVO POR RAFA ---------------------
	
		public static void generarReclamoEspacioComun(int userId, int edificioId, int espacioComunId, String descripcionReclamo, String urlImagen, Session session) {
			if (pertenece(userId, edificioId, session)) {
				Usuario user = getUsuarioHQL(userId, session);
				Edificio edificio = getEdificioHQL(edificioId, session);
				Unidad unidad = getUnidadHQL(espacioComunId, session);
				Reclamo nuevoReclamo = new Reclamo(user, edificio, unidad, descripcionReclamo, urlImagen);
				persistirReclamo(nuevoReclamo);
			}
		}
		
		public static void generarReclamoParticular(int userId, int edificioId, int departamentoId, String descripcionReclamo, String urlImagen, Session session) {
			Depto departamento = getDepartamentoHQL(departamentoId, session);
			if (departamento.getInqulinos().size() != 0 && departamento.getPropietario().getId() == userId) 
				return;
			if (!pertenece(userId, departamento.getInqulinos()) && departamento.getPropietario().getId() != userId) 
				return;
			Usuario user = getUsuarioHQL(userId, session);
			Edificio edificio = getEdificioHQL(edificioId, session);
			Depto unidad = getDepartamentoHQL(departamentoId, session);
			Reclamo nuevoReclamo = new Reclamo(user, edificio, unidad, descripcionReclamo, urlImagen);
		}
		
		private static void persistirReclamo(Reclamo nuevoReclamo) {
			//PERSISIR UN RECLAMO
		}
		
		private static boolean pertenece(int userID, int edificioId, Session session) {
			Edificio edificio = getEdificioHQL(edificioId, session);
			List<Usuario> usuarios = edificio.getUsuarios();
			int cantidadUsuarios = usuarios.size();
			int i = 0;
			while (i < cantidadUsuarios && usuarios.get(i).getId() == userID)
				i++;
			return i != cantidadUsuarios;
		}
		
		private static boolean pertenece(int userId, List<Inquilino> inquilinos) {
			int cantidadInquilinos = inquilinos.size();
			int i = 0;
			while (i < cantidadInquilinos && inquilinos.get(i).getId() != userId)
				i++;
			return i != cantidadInquilinos;
		}

		private static Edificio getEdificioHQL(int edificioId, Session session) {
			return session.get(Edificio.class, edificioId);
		}
		
		private static Depto getDepartamentoHQL(int departamentoId, Session session) {
			return session.get(Depto.class, departamentoId);
		}
		
		private static Usuario getUsuarioHQL(int userId, Session session) {
			return session.get(Usuario.class, userId);
		}
		
		private static Unidad getUnidadHQL(int unidadId, Session session) {
			return session.get(Unidad.class, unidadId);
		}
	

}
