package model.service;

import model.bean.Service;
import model.repository.ServiceRepository;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    public List<String> add(Service service);
    List<Service> sortArea();
}
