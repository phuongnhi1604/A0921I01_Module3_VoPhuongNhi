package model.repository;

import model.bean.RentType;

import java.util.List;

public interface RentTypeRepository {
    public List<RentType> findAll();
}
