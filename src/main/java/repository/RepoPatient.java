package repository;

import entity.Patient;

import java.util.List;

public interface RepoPatient {
    void insert(Patient patient) ;
    void delete(Patient patient) ;
    void update( Patient patient) ;
    List<Patient> getAll();
}
