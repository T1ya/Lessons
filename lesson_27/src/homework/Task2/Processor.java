package homework.Task2;

public class Processor extends Component {
    private final int cores;
    private final double speed;
    private final String architecture;

    public Processor(String brand, String model, int cores, double speed, String architecture) {
        super(brand, model);
        this.cores = cores;
        this.speed = speed;
        this.architecture = architecture;
    }

    public int getCores() {
        return cores;
    }

    public double getSpeed() {
        return speed;
    }

    public String getArchitecture() {
        return architecture;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", cores - ").append(cores);
        sb.append(", speed - ").append(speed);
        sb.append(", architecture - ").append(architecture);

        return sb.toString();
    }
}
