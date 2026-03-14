package za.ac.cput.payroll.repository;

import za.ac.cput.payroll.domain.job.Position;
import za.ac.cput.payroll.domain.job.PositionStatus;

import java.util.List;
import java.util.Optional;

public interface PositionRepository {
    Optional<Position> findByPositionCode(String positionCode);
    List<Position> findByStatus(PositionStatus status);
    Position save(Position position);
}
