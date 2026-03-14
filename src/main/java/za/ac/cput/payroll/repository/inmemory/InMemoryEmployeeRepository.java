package za.ac.cput.payroll.repository.inmemory;

import za.ac.cput.payroll.domain.employee.Employee;
import za.ac.cput.payroll.repository.EmployeeRepository;

import java.util.*;

public class InMemoryEmployeeRepository implements EmployeeRepository {
    private final Map<String, Employee> store = new HashMap<>();

    @Override
    public Optional<Employee> findByEmployeeNumber(String employeeNumber) {
        return Optional.ofNullable(store.get(employeeNumber));
    }

    @Override
    public Employee save(Employee employee) {
        store.put(employee.getEmployeeNumber(), employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(store.values());
    }
}
