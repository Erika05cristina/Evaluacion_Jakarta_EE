package ec.edu.ups.edu.DAO;

import java.util.List;

import ec.edu.ups.edu.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public Usuario read(String cedula) {
		Usuario usuario = em.find(Usuario.class, cedula);
		return usuario;
	}
	
	public void update(Usuario usuario) {
		em.merge(usuario);
	}
	
	public void delete(String cedula) {
		Usuario planilla = this.read(cedula);
		em.remove(planilla);
	}
	
	public List<Usuario> getAll(){
		String jpql = "SELECT u FROM Usuario u";
		Query query = em.createQuery(jpql, Usuario.class);		
		return query.getResultList();
	}
	
}
