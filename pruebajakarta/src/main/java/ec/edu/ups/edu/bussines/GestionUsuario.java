package ec.edu.ups.edu.bussines;

import java.util.List;

import ec.edu.ups.edu.DAO.UsuarioDAO;
import ec.edu.ups.edu.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUsuario {
	@Inject
	private UsuarioDAO daoUsuario;
	
	
	public Usuario getUsuario(String cedula)throws Exception{
		Usuario usuario = daoUsuario.read(cedula);
		if(usuario == null)
			throw new Exception("Usuario no existe");
		return usuario;
	}
	
	public List<Usuario> getUsuarios(){
		return daoUsuario.getAll();
	}
	
	public void createUsuario(Usuario usuario) throws Exception {			
		daoUsuario.insert(usuario);
	}
	
	public void deleteUsuario(String cedula) throws Exception{
		Usuario usuario = daoUsuario.read(cedula);
		if(usuario == null) {				
			throw new Exception("usuario no existe");
		}
		else {
			daoUsuario.delete(cedula);
		}
		
	}
	
	public void updateUsuario(Usuario usuario) throws Exception {
		Usuario existingusuario = daoUsuario.read(usuario.getUsu_id());
        if (existingusuario == null) {
            throw new Exception("usuario no existe");
        } else {
        	daoUsuario.update(usuario);
        }
    }

}
