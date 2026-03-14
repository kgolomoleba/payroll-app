package za.ac.cput.payroll.repository;

import za.ac.cput.payroll.domain.job.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobRepository {
    Optional<Job> findById(UUID id);
    Job save(Job job);
    List<Job> findAll();
}
