package model.repository;

import model.bean.Contract_Detail;

import java.util.List;

public interface ContractDetailRepository {
    public List<Contract_Detail> findAll();
    public boolean add(Contract_Detail contract_detail);
}
