package model.repository;

import model.bean.Customer_Type;
import model.bean.Service_Type;

import java.util.List;

public interface ServiceTypeRepository {
    public List<Service_Type> findAll();
}
