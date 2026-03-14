package za.ac.cput.payroll.service;

import za.ac.cput.payroll.domain.employee.Employee;
import za.ac.cput.payroll.domain.job.Position;
import za.ac.cput.payroll.repository.EmployeeRepository;
import za.ac.cput.payroll.repository.PositionRepository;

public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    private final PositionRepository positionRepo;

    public EmployeeService(EmployeeRepository employeeRepo, PositionRepository positionRepo) {
        this.employeeRepo = employeeRepo;
        this.positionRepo = positionRepo;
    }

    public void assignEmployeeToPosition(String employeeNumber, String positionCode) {
        Employee employee = employeeRepo.findByEmployeeNumber(employeeNumber)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found: " + employeeNumber));
        Position position = positionRepo.findByPositionCode(positionCode)
                .orElseThrow(() -> new IllegalArgumentException("Position not found: " + positionCode));

        if (employee.getCurrentPosition() != null)
            throw new IllegalStateException("Employee already assigned to a position");
        if (!position.isOpen())
            throw new IllegalStateException("Position is not open");

        employee.assignTo(position);
        positionRepo.save(position);
        employeeRepo.save(employee);
    }

    public void unassignEmployee(String employeeNumber) {
        Employee employee = employeeRepo.findByEmployeeNumber(employeeNumber)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found: " + employeeNumber));
        if (employee.getCurrentPosition() == null) return;
        employee.unassign();
        employeeRepo.save(employee);
    }

    public Employee registerEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
