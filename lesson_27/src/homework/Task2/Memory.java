package homework.Task2;

public class Memory extends Component {
    private final int capacity;
    private final String type;
    private final int frequency;

    public Memory(String brand, String model, int capacity, String type, int frequency) {
        super(brand, model);
        this.capacity = capacity;
        this.type = type;
        this.frequency = frequency;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public int getFrequency() {
        return frequency;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", capacity - ").append(capacity).append(" Gb");
        sb.append(", type - ").append(type);
        sb.append(", frequency - ").append(frequency).append(" MHz");

        return sb.toString();
    }
}
