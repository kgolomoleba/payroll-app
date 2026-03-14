package za.ac.cput.payroll.service;

import za.ac.cput.payroll.domain.job.Job;
import za.ac.cput.payroll.domain.job.Position;
import za.ac.cput.payroll.domain.job.PositionStatus;
import za.ac.cput.payroll.repository.JobRepository;
import za.ac.cput.payroll.repository.PositionRepository;

import java.util.List;
import java.util.UUID;

public class JobService {
    private final JobRepository jobRepo;
    private final PositionRepository positionRepo;

    public JobService(JobRepository jobRepo, PositionRepository positionRepo) {
        this.jobRepo = jobRepo;
        this.positionRepo = positionRepo;
    }

    public Position addPositionToJob(UUID jobId, String positionCode) {
        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found: " + jobId));
        Position pos = new Position(positionCode);
        job.addPosition(pos);
        jobRepo.save(job);
        return positionRepo.save(pos);
    }

    public List<Position> listOpenPositions() {
        return positionRepo.findByStatus(PositionStatus.OPEN);
    }
}
