package za.ac.cput.payroll.domain.employee;

import za.ac.cput.payroll.domain.job.Position;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final String employeeNumber; // unique, mandatory
    private String name;
    private EmploymentType employmentType;
    private String nationality;
    private ContactDetails contact;
    private Address address;
    private final List<Identity> identities = new ArrayList<>();
    private Position currentPosition; // only one at a time

    public Employee(String employeeNumber, String name, EmploymentType type, String nationality,
                    ContactDetails contact, Address address) {
        if (employeeNumber == null || employeeNumber.isBlank())
            throw new IllegalArgumentException("employeeNumber is mandatory");
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.employmentType = type;
        this.nationality = nationality;
        this.contact = contact;
        this.address = address;
    }

    public void addIdentity(String type, String value) {
        identities.add(new Identity(type, value));
    }

    public void assignTo(Position position) {
        if (currentPosition != null)
            throw new IllegalStateException("Employee already has a position");
        if (!position.isOpen())
            throw new IllegalStateException("Position is not open");
        this.currentPosition = position;
        position.assignTo(this);
    }

    public void unassign() {
        if (currentPosition != null) {
            currentPosition.vacate();
            currentPosition = null;
        }
    }

    public String getEmployeeNumber() { return employeeNumber; }
    public String getName() { return name; }
    public EmploymentType getEmploymentType() { return employmentType; }
    public String getNationality() { return nationality; }
    public ContactDetails getContact() { return contact; }
    public Address getAddress() { return address; }
    public List<Identity> getIdentities() { return identities; }
    public Position getCurrentPosition() { return currentPosition; }
}
