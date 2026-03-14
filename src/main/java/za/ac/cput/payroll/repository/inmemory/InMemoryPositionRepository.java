package za.ac.cput.payroll.repository.inmemory;

import za.ac.cput.payroll.domain.job.Position;
import za.ac.cput.payroll.domain.job.PositionStatus;
import za.ac.cput.payroll.repository.PositionRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryPositionRepository implements PositionRepository {
    private final Map<String, Position> store = new HashMap<>();

    @Override
    public Optional<Position> findByPositionCode(String positionCode) {
        return Optional.ofNullable(store.get(positionCode));
    }

    @Override
    public List<Position> findByStatus(PositionStatus status) {
        return store.values().stream()
                .filter(p -> p.getStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public Position save(Position position) {
        store.put(position.getPositionCode(), position);
        return position;
    }
}
