package ec.edu.ups.edu.bussines;

import java.util.List;

import ec.edu.ups.edu.DAO.PlanillaDAO;
import ec.edu.ups.edu.model.Planilla;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionPlanilla {
	@Inject
	private PlanillaDAO daoPlanilla;
	
	public Planilla getPlanilla(String codigo)throws Exception{
		Planilla planilla = daoPlanilla.read(codigo);
		if(planilla == null)
			throw new Exception("Planilla no existe");
		return planilla;
	}
	
	public List<Planilla> getPlanillas(){
		return daoPlanilla.getAll();
	}
	
	public void createPlanilla(Planilla planilla) throws Exception {			
		daoPlanilla.insert(planilla);
	}
	
	public void deletePlanilla(String codigo) throws Exception{
		Planilla planilla = daoPlanilla.read(codigo);
		if(planilla == null) {				
			throw new Exception("Planilla no existe");
		}
		else {
			daoPlanilla.delete(codigo);
		}
		
	}
	
	public void updatePlanilla(Planilla planilla) throws Exception {
		Planilla existingplanilla = daoPlanilla.read(planilla.getPla_codigo());
        if (existingplanilla == null) {
            throw new Exception("Planilla no existe");
        } else {
        	daoPlanilla.update(planilla);
        }
    }
}
