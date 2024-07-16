package ec.edu.ups.edu.services;

import java.util.List;

import ec.edu.ups.edu.bussines.GestionPlanilla;
import ec.edu.ups.edu.model.Planilla;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/planillas")
public class PlanillaService {
	@Inject
	private GestionPlanilla gPlanilla;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Planilla planilla) {
		try {
			gPlanilla.createPlanilla(planilla);
			return Response.ok(planilla).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR,"Error bd")).build();
		
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Planilla planilla) {
	    try {
	    	gPlanilla.updatePlanilla(planilla);
	        return Response.ok(planilla).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
	    }
	}
	
	@DELETE
	public Response delete(@QueryParam("id") String codigo) {
		try {
			gPlanilla.deletePlanilla(codigo);
			return Response.ok(codigo).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@GET
	@Path("/{codigo}")
	public Planilla get(String codigo) {
		Planilla cliente;
		try {
			cliente = gPlanilla.getPlanilla(codigo);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Planilla> list(){
		List<Planilla> planillas = gPlanilla.getPlanillas();
		return planillas;
	}
	
	
	
	

}
