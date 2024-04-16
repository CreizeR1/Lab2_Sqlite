package repository;

import entity.Visit;

import java.util.List;

public interface RepoVisit {
    void insert( Visit visit);
    void delete( Visit visit);
    void update( Visit visit);
    List<Visit> getAll();

}
