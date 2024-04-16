package repository;

import entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import javax.persistence.*;
import javax.transaction.Transactional;


public class PatientRepository implements RepoPatient {
    private static final Logger log= LogManager.getLogger(PatientRepository.class);
    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("TST").createEntityManager();


    @Override
    @Transactional
    public void insert( Patient patient) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(patient);
            transaction.commit();
           log.info("Successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Patient patient) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Patient delPatient = em.find(Patient.class, patient.getCard());
            if (delPatient != null) {
                em.remove(delPatient);
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
    public void update( Patient patient){
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();


            Patient patientToUpdate = em.find(Patient.class, patient.getCard());
            if (patientToUpdate != null) {

                em.merge(patientToUpdate);
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
    public List<Patient> getAll(){
        return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
    }


}
