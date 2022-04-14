package model.service.Impl;

import model.bean.Contract_Detail;
import model.repository.ContractDetailRepository;
import model.repository.Impl.Contract_DetailRepositoryImpl;
import model.service.ContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new Contract_DetailRepositoryImpl();
    @Override
    public List<Contract_Detail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public boolean add(Contract_Detail contract_detail) {
        return contractDetailRepository.add(contract_detail);
    }
}
