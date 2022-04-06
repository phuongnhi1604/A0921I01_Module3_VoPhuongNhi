package model.repository;

import model.bean.Contract;

import java.util.List;

public interface ContractRepository {
    public List<Contract> findAll();
    public boolean add(Contract contract);
}
