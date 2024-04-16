package repository;

import entity.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.List;

public class DoctorRepository implements RepoDoctor {
    private static final Logger log= LogManager.getLogger(DoctorRepository.class);

    public EntityManager em = Persistence.createEntityManagerFactory("TST").createEntityManager();

    @Override
    @Transactional
    public void insert( Doctor doctor) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(doctor);
            transaction.commit();
            log.info("Successful");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete( Doctor doctor) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Найти объект для удаления
            Doctor delDoctor = em.find(Doctor.class, doctor.getId());
            if (delDoctor != null) {
                em.remove(delDoctor);
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
    public void update(Doctor doctor) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();


            Doctor doctorToUpdate = em.find(Doctor.class, doctor.getId());
            if (doctorToUpdate != null) {

                em.merge(doctorToUpdate);
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
    public List<Doctor> getAll() {
        return em.createQuery("SELECT s FROM Doctor s", Doctor.class).getResultList();
    }


}
