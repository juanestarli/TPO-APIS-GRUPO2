package apis.main;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


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
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		tx.commit();
	}

	public static void oneToMany(Session session) {

		Propietario juan = new Propietario("Juan", "Estarli", "44161556", "juan1234");
		Depto depto1 = new Depto(7, juan, null, false);
		Depto depto2 = new Depto(8, juan, null, false);
		
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
	
	

}
