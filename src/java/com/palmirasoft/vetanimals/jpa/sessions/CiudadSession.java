package com.palmirasoft.vetanimals.jpa.sessions;

import com.palmirasoft.vetanimals.jpa.entities.Ciudad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author @DavidAlzate88
 */
@Stateless
public class CiudadSession {

   @PersistenceContext
   private EntityManager entityManager;
   
   public void create(Ciudad ciudad) {
       entityManager.persist(ciudad);
   }
   
   public void edit(Ciudad ciudad) {
       entityManager.merge(ciudad);
   }
   
   public void remove(Ciudad ciudad) {
       entityManager.remove(ciudad);
   }
   
   public List<Ciudad> findAll() {
       CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
       cq.select(cq.from(Ciudad.class));
       return entityManager.createQuery(cq).getResultList();
   }
}