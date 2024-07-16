package ec.edu.ups.edu.DAO;

import java.util.List;

import ec.edu.ups.edu.model.Planilla;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PlanillaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Planilla planilla) {
		em.persist(planilla);
	}
	
	public Planilla read(String codigo) {
		Planilla planilla = em.find(Planilla.class, codigo);
		return planilla;
	}
	
	public void update(Planilla planilla) {
		em.merge(planilla);
	}
	
	public void delete(String codigo) {
		Planilla planilla = this.read(codigo);
		em.remove(planilla);
	}
	
	public List<Planilla> getAll(){
		String jpql = "SELECT p FROM Planilla p";
		Query query = em.createQuery(jpql, Planilla.class);		
		return query.getResultList();
	}

}
