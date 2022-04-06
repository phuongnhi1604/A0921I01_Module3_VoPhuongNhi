package model.repository;

import model.bean.Division;

import java.util.List;

public interface DivisionRepository {
    public List<Division> findAll();
}
