package ec.edu.ups.edu.services;

import java.util.List;

import ec.edu.ups.edu.bussines.GestionUsuario;
import ec.edu.ups.edu.model.Usuario;
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

public class UsuarioService {
	@Inject
	private GestionUsuario gUsuario;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create (Usuario usuario) {
		try {
			gUsuario.createUsuario(usuario);
			return Response.ok(usuario).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR,"Error bd")).build();
		}
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Usuario usuario) {
	    try {
	    	gUsuario.updateUsuario(usuario);
	        return Response.ok(usuario).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
	    }
	}
	
	
	@DELETE
	public Response delete(@QueryParam("id") String cedula) {
		try {
			gUsuario.deleteUsuario(cedula);
			return Response.ok(cedula).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@GET
	@Path("/{codigo}")
	public Usuario get(String cedula) {
		Usuario usuario;
		try {
			usuario = gUsuario.getUsuario(cedula);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Usuario> list(){
		List<Usuario> usuario = gUsuario.getUsuarios();
		return usuario;
	}
	
}
