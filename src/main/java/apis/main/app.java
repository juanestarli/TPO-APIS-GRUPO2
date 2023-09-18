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
		conf.addAnnotatedClass(Departamento.class);
		conf.addAnnotatedClass(Edificio.class);
		conf.addAnnotatedClass(EspacioComun.class);
		conf.addAnnotatedClass(Reclamo.class);
		conf.addAnnotatedClass(RespuestaReclamo.class);
		
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		//instanciar edificio
		Edificio arcos2000 = new Edificio("Arcos", 2000, new ArrayList<Unidad>());
		//instanciar propietarios
		Propietario Juan = new Propietario("Juan","Estarli","44161556","Juan1234");
		Propietario Rafa = new Propietario("Rafael","Gini","43651556","Rafa1234");
		
		//instanciar deptos
		Departamento piso7b = new Departamento(7,'b',Juan,false);
		Departamento piso5a = new Departamento(5,'a',Juan,false);
		Departamento piso3b = new Departamento(3,'b',Rafa,false);
		//instanciar espacios comunes
		EspacioComun Pileta = new EspacioComun(15, "Pileta", "Sector pileta");
		EspacioComun Sum = new EspacioComun(15, "Sum", "Salon de usos multiples");
		//instanciar inquilinos
		Inquilino Martin = new Inquilino("Martin", "Ramirez", "45637263", "Martin1234", piso3b);
		Inquilino Juana = new Inquilino("Juana","Garcia","64758798","Juana1234",piso3b);
		Inquilino Ramon = new Inquilino("Ramon","Perez","26875687","Ramon1234",piso7b);
		Inquilino Marta = new Inquilino("Marta","Gonzalez","4352676","Marta1234",piso5a);
		

		session.save(arcos2000);
	    session.save(Juan);
	    session.save(Rafa);
	    session.save(piso7b);
	    session.save(piso5a);
	    session.save(piso3b);
	    session.save(Pileta);
	    session.save(Sum);
	    session.save(Martin);
	    session.save(Juana);
	    session.save(Ramon);
	    session.save(Marta);
		tx.commit();
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
			Departamento departamento = getDepartamentoHQL(departamentoId, session);
			if (departamento.getInqulinos().size() != 0 && departamento.getPropietario().getId() == userId) 
				return;
			if (!pertenece(userId, departamento.getInqulinos()) && departamento.getPropietario().getId() != userId) 
				return;
			Usuario user = getUsuarioHQL(userId, session);
			Edificio edificio = getEdificioHQL(edificioId, session);
			Departamento unidad = getDepartamentoHQL(departamentoId, session);
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
		
		private static Departamento getDepartamentoHQL(int departamentoId, Session session) {
			return session.get(Departamento.class, departamentoId);
		}
		
		private static Usuario getUsuarioHQL(int userId, Session session) {
			return session.get(Usuario.class, userId);
		}
		
		private static Unidad getUnidadHQL(int unidadId, Session session) {
			return session.get(Unidad.class, unidadId);
		}
	

}
