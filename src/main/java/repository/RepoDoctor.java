package repository;

import entity.Doctor;


import java.util.List;

public interface RepoDoctor {
    void insert(Doctor doctor);
    void delete(Doctor doctor);
    void update(Doctor doctor);
    List<Doctor> getAll();
}
