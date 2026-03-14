package za.ac.cput.payroll.domain.job;

import za.ac.cput.payroll.domain.employee.Employee;

public class Position {
    private final String positionCode;
    private PositionStatus status = PositionStatus.OPEN;
    private Job job;               // back-reference (optional)
    private Employee occupant;     // null if open

    public Position(String positionCode) {
        if (positionCode == null || positionCode.isBlank()) {
            throw new IllegalArgumentException("positionCode is mandatory");
        }
        this.positionCode = positionCode;
    }

    public boolean isOpen() { return status == PositionStatus.OPEN; }

    public void assignTo(Employee employee) {
        if (!isOpen()) throw new IllegalStateException("Position is not open");
        this.occupant = employee;
        this.status = PositionStatus.CLOSED;
    }

    public void vacate() {
        this.occupant = null;
        this.status = PositionStatus.OPEN;
    }

    public String getPositionCode() { return positionCode; }
    public PositionStatus getStatus() { return status; }
    public Employee getOccupant() { return occupant; }
    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }
}
