package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import apis.main.app;
import model.Departamento;
import model.Edificio;
import model.EspacioComun;
import model.Usuario;

public class Test1 {
	
	public static void runTest(SessionFactory sf, Session session, Transaction tx) {
		Edificio arcos2000 = new Edificio("Arcos", 2000);
		session.save(arcos2000);

		
		Usuario Juan = new Usuario("Juan","Estarli","44161556","Juan1234");
		Usuario Rafa = new Usuario("Rafael","Gini","43651556","Rafa1234");
		session.save(Juan);
	    session.save(Rafa);
		
		Departamento piso7b = new Departamento(7,"b",Juan,false);
		Departamento piso5a = new Departamento(5,"a",Juan,false);
		Departamento piso3b = new Departamento(3,"b",Rafa,false);
		
		piso7b.setEdificio(arcos2000);
		piso5a.setEdificio(arcos2000);
		piso3b.setEdificio(arcos2000);
		
		session.save(piso7b);
		session.save(piso5a);
	    session.save(piso3b);
	    

		EspacioComun Pileta = new EspacioComun(15, "Pileta", "Sector pileta");
		EspacioComun Sum = new EspacioComun(15, "Sum", "Salon de usos multiples");
		
		session.save(Pileta);
	    session.save(Sum);
		
		Usuario Martin = new Usuario("Martin", "Ramirez", "45637263", "Martin1234");
		Usuario Juana = new Usuario("Juana","Garcia","64758798","Juana1234");
		Usuario Ramon = new Usuario("Ramon","Perez","26875687","Ramon1234");
		Usuario Marta = new Usuario("Marta","Gonzalez","4352676","Marta1234");

		
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

		session.save(Martin);
	    session.save(Juana);
	    session.save(Ramon);
	    session.save(Marta);
		
	    piso7b.AgregarInquilino(Marta);
	    piso7b.AgregarInquilino(Martin);
	    piso5a.AgregarInquilino(Ramon);
	    piso3b.AgregarInquilino(Juana);
	  
		tx.commit();
		
		String descripcionreclamo1 = "Se me rompio la canieria, y tengo el living inundado";
		String foto1 = "Foto de la canieria";
		
		String descripcionreclamo2 = "Esta perdiendo agua la pileta!!";
		String foto2 = "Foto de la pileta";

		app.generarReclamoParticular(Marta.getId(), arcos2000.getIdEdificio(), piso3b.getId(), descripcionreclamo1, foto1, session);
		app.generarReclamoEspacioComun(Ramon.getId(), arcos2000.getIdEdificio(), Pileta.getId(), descripcionreclamo2, foto2, session);
		
		session.close();

		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("------------ TODO OK. ------------");
		System.out.println("----------------------------------");
		System.out.println();
	}
}
