package model.repository;

import model.bean.CustomerUseService;

import java.util.List;

public interface CustomerUseServiceRepository {
    public List<CustomerUseService> findAll();
}
