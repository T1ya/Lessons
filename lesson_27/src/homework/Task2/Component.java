package homework.Task2;

public class Component {
    private String brand;
    private String model;

    public Component(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("brand - ").append(brand);
        sb.append(", model - ").append(model);
        return sb.toString();
    }
}
