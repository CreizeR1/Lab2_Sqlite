package repository;


import entity.Visit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;

public class VisitRepository implements RepoVisit {
    private static final Logger log= LogManager.getLogger(VisitRepository.class);
    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("TST").createEntityManager();

    @Override
    public void insert( Visit visit) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(visit);
            transaction.commit();
            log.info("Successful");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public void delete( Visit visit) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Найти объект для удаления
            Visit delVisit = em.find(Visit.class, visit.getId());
            if (delVisit != null) {
                em.remove(delVisit);
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
    public void update( Visit visit){
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();


            Visit visitToUpdate = em.find(Visit.class, visit.getId());
            if (visitToUpdate != null) {

                em.merge(visitToUpdate);
                log.info("Successful.");
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
    public List<Visit> getAll() {
        return em.createQuery("SELECT v FROM Visit v", Visit.class).getResultList();
    }




}
