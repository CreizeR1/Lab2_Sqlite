package repository;

import entity.Disease;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class DiseaseRepository implements RepoDisease {
    private static final Logger log= LogManager.getLogger(DiseaseRepository.class);
    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("TST").createEntityManager();

    @Override
    @Transactional
    public void insert( Disease disease){
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(disease);
            transaction.commit();
            log.info("Successful");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Disease disease){
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Найти объект для удаления
            Disease delDisease = em.find(Disease.class, disease.getId_disease());
            if (delDisease  != null) {
                em.remove(delDisease );
                log.info("Successful");
            } else {
                log.info("Error");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.info(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void update( Disease disease){
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();


            Disease diseaseToUpdate = em.find(Disease.class, disease.getId_disease());
            if (diseaseToUpdate != null) {

                em.merge(diseaseToUpdate);
                log.info("Successful");
            } else {
                log.info("Error");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.info(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Disease> getAll(){
        return em.createQuery("SELECT c FROM Disease c", Disease.class).getResultList();
    }


}
