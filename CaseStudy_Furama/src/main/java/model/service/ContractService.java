package model.service;

import model.bean.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> findAll();
    public boolean add(Contract contract);
}
