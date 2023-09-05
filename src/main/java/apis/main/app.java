package apis.main;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
import model.Usuario;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Usuario usuario = new Usuario("Juan","Estarli","44161556","juan1234");
		
		Transaction tx = session.beginTransaction();
		session.save(usuario);
		tx.commit();

		usuario = new Usuario("rafa", "Gini", "45736283","rafa1234");
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		

		// Mostrando el registro insertado
		session.beginTransaction();
		Usuario res = session.get(Usuario.class, 1);
		session.getTransaction().commit();
		System.out.println(res);
		
		// Obteniendo todos los registros
		Query<Usuario> getQuery = session.createQuery("FROM Usuario", Usuario.class);
		List<Usuario> usuarios = getQuery.getResultList();
		for (Usuario u : usuarios) {
			System.out.println(u);
		}

		
	}

}
