package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import model.*;

public class Test2 {
	
	public static void runTest() {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("	1. Inyectamos un Edificio: ");
		Edificio edificio1 = factory.getBean(Edificio.class);
		System.out.println(edificio1);
		
		System.out.println("\n	2. Seteamos el edificio: ");
		edificio1.setAltura(2567);
		edificio1.setCalle("O'higgins");
		System.out.println(edificio1);
		
		System.out.println("\n	3. Inyectamos un Usuario y lo seteamos: ");
		Usuario user = factory.getBean(Usuario.class);
		setUsuario(user, "Raul", "Alfonsin", "17000345", "AlfonoCapo");
		System.out.println(user);
		
		System.out.println("\n	4. Inyectamos un Departamento y asociamos nuestro usuario como propietario e inquilino del mismo: \\n");
		Departamento dept = factory.getBean(Departamento.class);
		setDepartamento(dept, false, edificio1, 14, "b", user);
		user.setVivienda(dept);
		user.agregarPropiedad(dept);
		System.out.println(user);
		System.out.println(dept);
		System.out.println(edificio1);
		
		
		((ConfigurableApplicationContext)factory).close();
	}
	
	private static void setDepartamento(Departamento dept, boolean alquila, Edificio edificio1, int piso, String unidad, Usuario propietario) {
		dept.setAlquiler(alquila);
		dept.setEdificio(edificio1);
		dept.setPiso(piso);
		dept.setUnidad(unidad);
		dept.setPropietario(propietario);
	}

	private static void setUsuario(Usuario user, String nombre, String apellido, String dni, String pass) {
		user.setDni(dni);
		user.setNombre(nombre);		
		user.setApellido(apellido);
		user.setContrasena(pass);
	}

}
