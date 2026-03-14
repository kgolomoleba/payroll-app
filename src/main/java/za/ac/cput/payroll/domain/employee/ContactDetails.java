package za.ac.cput.payroll.domain.employee;

public class ContactDetails {
    private final String cellPhone;
    private final String email;
    private final String homePhone;

    public ContactDetails(String cellPhone, String email, String homePhone) {
        this.cellPhone = cellPhone;
        this.email = email;
        this.homePhone = homePhone;
    }

    public String getCellPhone() { return cellPhone; }
    public String getEmail() { return email; }
    public String getHomePhone() { return homePhone; }
}
