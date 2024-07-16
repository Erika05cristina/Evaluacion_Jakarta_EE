package ec.edu.ups.edu.pruebajakarta;

import java.util.List;

import ec.edu.ups.edu.DAO.PlanillaDAO;
import ec.edu.ups.edu.DAO.UsuarioDAO;
import ec.edu.ups.edu.model.Planilla;
import ec.edu.ups.edu.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	@Inject
	private PlanillaDAO daoPlanilla;
	@Inject
	private UsuarioDAO daoUsuario;
	
	@PostConstruct
	public void init() {
		//Usuario
		
		Usuario usuario1 = new Usuario();
		usuario1.setUsu_id("0123452346");
		usuario1.setUsu_nombre("Jaime");
		usuario1.setUsu_telefono("0987654321");
		usuario1.setUsu_direccion("cuenca");
		
		
		daoUsuario.insert(usuario1);
		
		List<Usuario> listadoUsu =daoUsuario.getAll();
		for(Usuario usu: listadoUsu) {
			System.out.println(usu.getUsu_id()+ " "+ usu.getUsu_nombre()+" "+ usu.getUsu_telefono()+" "+ usu.getUsu_direccion());
			}
		//Planilla
		Planilla planilla1 = new Planilla();
		planilla1.setPla_codigo("0123456");
		planilla1.setPla_consumo("345");
		planilla1.setPla_mes("mayo");
		planilla1.setPla_ciudad("Cuenca");
		planilla1.setUsuario(usuario1);
		
		daoPlanilla.insert(planilla1);
		
		List<Planilla> listadoPlan =daoPlanilla.getAll();
		for(Planilla plan: listadoPlan) {
			System.out.println(plan.getPla_codigo()+ " "+ plan.getPla_ciudad()+" "+ plan.getPla_mes()+" "+ plan.getPla_consumo()+" "+plan.getUsuario());
			}		
	
	}

}
