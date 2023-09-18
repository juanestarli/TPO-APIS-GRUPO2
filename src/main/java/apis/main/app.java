package apis.main;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		Edificio arcos2000 = new Edificio("Arcos", 2000);
		//instanciar Usuarios
		Usuario Juan = new Usuario("Juan","Estarli","44161556","Juan1234");
		Usuario Rafa = new Usuario("Rafael","Gini","43651556","Rafa1234");
		
		//instanciar deptos
		Departamento piso7b = new Departamento(7,'b',Juan,false);
		Departamento piso5a = new Departamento(5,'a',Juan,false);
		Departamento piso3b = new Departamento(3,'b',Rafa,false);
	
		//instanciar espacios comunes
		EspacioComun Pileta = new EspacioComun(15, "Pileta", "Sector pileta");
		EspacioComun Sum = new EspacioComun(15, "Sum", "Salon de usos multiples");
		
		//instanciar Usuarios
		Usuario Martin = new Usuario("Martin", "Ramirez", "45637263", "Martin1234");
		Usuario Juana = new Usuario("Juana","Garcia","64758798","Juana1234");
		Usuario Ramon = new Usuario("Ramon","Perez","26875687","Ramon1234");
		Usuario Marta = new Usuario("Marta","Gonzalez","4352676","Marta1234");
		
		//instanciar Reclamos
		Reclamo reclamo1 = new Reclamo(Marta, arcos2000, piso3b, null, 
				"se me rompió la cañería, y tengo el living inundado", "foto de la cañería");
		
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
		session.save(reclamo1);
		tx.commit();
	}

	
	//------------------- NUEVO POR RAFA ---------------------
	
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		public static void generarReclamoEspacioComun(int userId, int edificioId, int espacioComunId, String descripcionReclamo, String urlImagen, Session session) {
			if (pertenece(userId, edificioId, session)) {
				Usuario user = getUsuarioHQL(userId, session);
				Edificio edificio = getEdificioHQL(edificioId, session);
				EspacioComun espacioComun = getEspacioComunHQL(espacioComunId, session);
				Reclamo nuevoReclamo = new Reclamo(user, edificio,  null, espacioComun, descripcionReclamo, urlImagen);
				persistirReclamo(nuevoReclamo, session);
			}
		}


		public static void generarReclamoParticular(int userId, int edificioId, int departamentoId, String descripcionReclamo, String urlImagen, Session session) {
			Departamento departamento = getDepartamentoHQL(departamentoId, session);
			boolean esInquilino = pertenece(userId, departamento.getInqulinos());
			int cantidadHabitantes = departamento.getInqulinos().size();
			if ( esInquilino || (cantidadHabitantes == 0 && esPropietario(userId, departamento)) ) {
				Usuario user = getUsuarioHQL(userId, session);
				Edificio edificio = getEdificioHQL(edificioId, session);
				Reclamo nuevoReclamo = new Reclamo(user, edificio, departamento, null, descripcionReclamo, urlImagen);
				persistirReclamo(nuevoReclamo, session);
			}
		}
		
		private static void persistirReclamo(Reclamo nuevoReclamo, Session session) {
		    Transaction tx = session.beginTransaction();
		    try {
		        session.save(nuevoReclamo); 
		        tx.commit(); 
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback(); 
		        }
		        e.printStackTrace();
		    } finally {
		        session.close(); 
		    }
		    
		    System.out.println("Reclamo persistido:" + nuevoReclamo.getIdReclamo());
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
		
		private static boolean pertenece(int userId, List<Usuario> Usuarios) {
			int cantidadUsuarios = Usuarios.size();
			int i = 0;
			while (i < cantidadUsuarios && Usuarios.get(i).getId() != userId)
				i++;
			return i != cantidadUsuarios;
		}
		
		public static List<Reclamo> consultarReclamosPorEdificioYEstado(int edificioId, String estadoReclamo, Session session) {
		    String hql = "FROM Reclamo r WHERE r.edificio.id = :edificioId AND r.estadoReclamo = :estadoReclamo";
		    Query<Reclamo> query = session.createQuery(hql, Reclamo.class);
		    query.setParameter("edificioId", edificioId);
		    query.setParameter("estadoReclamo", estadoReclamo);
		    List<Reclamo> reclamos = query.getResultList();
		    return reclamos;
		}
		
		public static List<Reclamo> consultarReclamosPorEstado(String estadoReclamo, Session session) {
		    String hql = "FROM Reclamo r WHERE r.estadoReclamo = :estadoReclamo";
		    Query<Reclamo> query = session.createQuery(hql, Reclamo.class);
		    query.setParameter("estadoReclamo", estadoReclamo);
		    List<Reclamo> reclamos = query.getResultList();
		    return reclamos;
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
	
		private static EspacioComun getEspacioComunHQL(int espacioComunId, Session session) {
			return session.get(EspacioComun.class, espacioComunId);
		}
		
		private static boolean esPropietario(int userId, Departamento depto) {
			return depto.getPropietario().getId() == userId;
		}
		


}
