package model.repository;

import model.bean.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> findAll();
    public boolean add(Service service);
    List<Service> sortArea();
}
