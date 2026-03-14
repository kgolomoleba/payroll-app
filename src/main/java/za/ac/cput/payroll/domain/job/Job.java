package za.ac.cput.payroll.domain.job;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Job {
    private final UUID id = UUID.randomUUID();
    private final String title;
    private final List<Position> positions = new ArrayList<>();

    public Job(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title is mandatory");
        this.title = title;
    }

    public void addPosition(Position position) {
        positions.add(position);
        position.setJob(this);
    }

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public List<Position> getPositions() { return positions; }
}
