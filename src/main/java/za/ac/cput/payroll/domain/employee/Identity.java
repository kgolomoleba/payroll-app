package za.ac.cput.payroll.domain.employee;

public class Identity {
    private final String type;
    private final String value;

    public Identity(String type, String value) {
        if (type == null || type.isBlank()) throw new IllegalArgumentException("Identity type required");
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Identity value required");
        this.type = type;
        this.value = value;
    }

    public String getType() { return type; }
    public String getValue() { return value; }
}
