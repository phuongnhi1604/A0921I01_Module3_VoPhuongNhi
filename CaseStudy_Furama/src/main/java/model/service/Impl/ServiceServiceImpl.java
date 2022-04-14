package model.service.Impl;

import common.Validation;
import model.bean.Service;
import model.repository.Impl.ServiceRepositoryImpl;
import model.repository.ServiceRepository;
import model.service.ServiceService;

import java.util.ArrayList;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceRepository serviceRepository=new ServiceRepositoryImpl();
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<String> add(Service service) {
        List<String> messList = new ArrayList<>();
        boolean check = true;
        if (Validation.checkNumber(String.valueOf(service.getNumber_of_floors()))){
            messList.add("");
        }else {
            check = false;
            messList.add("The Number of floor is not in the correct format!");
        }
        if (check){
            serviceRepository.add(service);
        }
        return messList;
    }

    @Override
    public List<Service> sortArea() {
        return serviceRepository.sortArea();
    }


}
