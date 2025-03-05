public class BusDriver {
    private static int idCounter = 101;
    private final int id;

    private String name;
    private String license;

    public BusDriver(String name, String license) {
        this.id = idCounter++;
        this.name = name;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Bus driver: {");
        // method chaining
        sb.append("id: ").append(id);
        sb.append(", name: ").append(getName());
        sb.append(", license: ").append(getLicense()).append("}");
        return sb.toString();
    }
}
