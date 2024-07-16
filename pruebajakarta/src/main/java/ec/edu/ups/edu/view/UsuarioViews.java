package ec.edu.ups.edu.view;

import java.util.List;

import ec.edu.ups.edu.bussines.GestionUsuario;
import ec.edu.ups.edu.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("usuarios")
@RequestScoped
public class UsuarioViews {
	@Inject
	private GestionUsuario gUsuario;
	 
	private String id;
	private List<Usuario> listado;
	private Usuario usuario = new Usuario();
	
	public GestionUsuario getgUsuario() {
		return gUsuario;
	}
	public void setgUsuario(GestionUsuario gUsuario) {
		this.gUsuario = gUsuario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Usuario> getListado() {
		return listado;
	}
	public void setListado(List<Usuario> listado) {
		this.listado = listado;
	}	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	//----------------------------------------
	@PostConstruct
	public void init() {
		listado=gUsuario.getUsuarios();
	}
	
	public String verListado() {
		return "usuarios?faces-redirect=true";
	}
	
	
	
	
	
}
