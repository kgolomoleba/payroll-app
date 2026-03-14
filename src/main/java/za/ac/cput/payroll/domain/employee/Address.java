package za.ac.cput.payroll.domain.employee;

public class Address {
    private final String streetAddress;
    private final String postalAddress;

    public Address(String streetAddress, String postalAddress) {
        this.streetAddress = streetAddress;
        this.postalAddress = postalAddress;
    }

    public String getStreetAddress() { return streetAddress; }
    public String getPostalAddress() { return postalAddress; }
}
