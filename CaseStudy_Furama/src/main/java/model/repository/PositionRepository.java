package model.repository;

import model.bean.Position;

import java.util.List;

public interface PositionRepository {
    public List<Position> findAll();
}
