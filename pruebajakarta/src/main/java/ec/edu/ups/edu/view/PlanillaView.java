package ec.edu.ups.edu.view;

import java.util.List;

import ec.edu.ups.edu.bussines.GestionPlanilla;
import ec.edu.ups.edu.model.Planilla;
import ec.edu.ups.edu.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("planillas")
@RequestScoped
public class PlanillaView {
	@Inject
	private GestionPlanilla gPlanilla;
	
	private Planilla planilla = new Planilla();
	private String id;
	private List<Planilla> listado;
	public GestionPlanilla getgPlanilla() {
		return gPlanilla;
	}
	public void setgPlanilla(GestionPlanilla gPlanilla) {
		this.gPlanilla = gPlanilla;
	}
	
	public Planilla getPlanilla() {
		return planilla;
	}
	public void setPlanilla(Planilla planilla) {
		this.planilla = planilla;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Planilla> getListado() {
		return listado;
	}
	public void setListado(List<Planilla> listado) {
		this.listado = listado;
	}
	
	//----------------------------------------------
	@PostConstruct
	public void init() {
		listado=gPlanilla.getPlanillas();
	}
	
	public String verListado() {
		return "listaPlanillas?faces-redirect=true";
	}
	
	

}
