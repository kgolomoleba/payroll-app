package za.ac.cput.payroll.repository;

import za.ac.cput.payroll.domain.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findByEmployeeNumber(String employeeNumber);
    Employee save(Employee employee);
    List<Employee> findAll();
}
