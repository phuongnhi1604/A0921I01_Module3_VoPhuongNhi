package model.service.Impl;

import model.bean.Position;
import model.repository.Impl.PositionRepositoryImpl;
import model.repository.PositionRepository;
import model.service.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
