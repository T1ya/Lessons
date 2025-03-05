package homework.Task2;

public class Storage extends Component{
    private final int capacity;
    private final String type;
    private final String interfaceType;

    public Storage(String brand, String model, int capacity, String type, String interfaceType) {
        super(brand, model);
        this.capacity = capacity;
        this.type = type;
        this.interfaceType = interfaceType;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", capacity - ").append(capacity);
        sb.append(", type - ").append(type);
        sb.append(", interface - ").append(interfaceType);

        return sb.toString();
    }
}
