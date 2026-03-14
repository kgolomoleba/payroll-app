package za.ac.cput.payroll.repository.inmemory;

import za.ac.cput.payroll.domain.job.Job;
import za.ac.cput.payroll.repository.JobRepository;

import java.util.*;

public class InMemoryJobRepository implements JobRepository {
    private final Map<UUID, Job> store = new HashMap<>();

    @Override
    public Optional<Job> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Job save(Job job) {
        store.put(job.getId(), job);
        return job;
    }

    @Override
    public List<Job> findAll() {
        return new ArrayList<>(store.values());
    }
}
