package repository;

import entity.Disease;



import java.util.List;

public interface RepoDisease {
    void insert(Disease disease);
    void delete(Disease disease);
    void update(Disease disease);
    List<Disease> getAll();
}
