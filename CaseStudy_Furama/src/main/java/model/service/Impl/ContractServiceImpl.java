package model.service.Impl;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.repository.Impl.ContractRepositoryImpl;
import model.service.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepositoryImpl();
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public boolean add(Contract contract) {
        return false;
    }
}
