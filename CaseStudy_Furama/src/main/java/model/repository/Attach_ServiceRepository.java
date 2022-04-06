package model.repository;

import model.bean.Attach_Service;

import java.util.List;

public interface Attach_ServiceRepository {
    List<Attach_Service> findAll();
}
