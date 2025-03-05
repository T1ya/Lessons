package homework.Task2;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage("BarraCuda", "ZA500CM10002", 500, "SSD", "SATA");

        Computer computer = new Computer("Intel", "Core i7-4790", 4, 3.6, "x64",
                "Kingston", "KVR32S22S8/16", 16, "DDR4", 3200,
                storage);

        System.out.println(computer);
    }
}
