package model.service;

import model.bean.Contract_Detail;

import java.util.List;

public interface ContractDetailService {
    public List<Contract_Detail> findAll();
    public boolean add(Contract_Detail contract_detail);
}
