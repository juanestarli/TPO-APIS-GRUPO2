package apis.main;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import model.*;
import test.Test1;
import test.Test2;

public class app {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration().configure();
		configurarAnotations(conf);
		
		// <=========== TEST 1, PERSISTENCIAS ===========>
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Test1.runTest(sf, session, tx);
		session.close();
		
		// <=========== TEST 2, INYECCIONES CON SPRING FRAMEWORK ===========>
		Test2.runTest();
		
		// <=========== FIN DEL PROGRAMA ===========>
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("------------ TODO OK. ------------");
		System.out.println("----------------------------------");
		System.out.println();
	
	}

	//------------------- MODULOS ---------------------
	
	private static void configurarAnotations(Configuration conf) {
		conf.addAnnotatedClass(Usuario.class);
		conf.addAnnotatedClass(Departamento.class);
		conf.addAnnotatedClass(Edificio.class);
		conf.addAnnotatedClass(EspacioComun.class);
		conf.addAnnotatedClass(Reclamo.class);
		conf.addAnnotatedClass(RespuestaReclamo.class);
	}
	
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
		System.out.print(esInquilino);

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
		while (i < cantidadUsuarios && usuarios.get(i).getId() != userID)
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
		
		



