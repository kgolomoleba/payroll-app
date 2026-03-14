package za.ac.cput.payroll;

import za.ac.cput.payroll.domain.employee.*;
import za.ac.cput.payroll.domain.job.Position;
import za.ac.cput.payroll.repository.inmemory.InMemoryEmployeeRepository;
import za.ac.cput.payroll.repository.inmemory.InMemoryPositionRepository;
import za.ac.cput.payroll.service.EmployeeService;

public class Smoke {
    public static void main(String[] args) {
        var empRepo = new InMemoryEmployeeRepository();
        var posRepo = new InMemoryPositionRepository();
        var service = new EmployeeService(empRepo, posRepo);

        var emp = new Employee("E1001", "Sam", EmploymentType.PERMANENT, "SA",
                new ContactDetails("071...", "sam@example.com", "021..."),
                new Address("1 Main Rd", "PO Box 123"));
        empRepo.save(emp);

        var pos = new Position("POS-001");
        posRepo.save(pos);

        service.assignEmployeeToPosition("E1001", "POS-001");
        System.out.println("Assigned? " + (empRepo.findByEmployeeNumber("E1001").get().getCurrentPosition() != null));
        System.out.println("Position open? " + posRepo.findByPositionCode("POS-001").get().isOpen());
    }
}