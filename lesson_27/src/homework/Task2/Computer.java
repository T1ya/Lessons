package homework.Task2;

public class Computer {
    private Processor processor;
    private Memory memory;
    private Storage storage;

    public Computer(String processorBrand, String processorModel, int processorCores, double processorSpeed, String processorArchitecture,
                    String memoryBrand, String memoryModel, int memoryCapacity, String memoryType, int memoryFrequency,
                    Storage storage) {
        // composition
        this.processor = new Processor(processorBrand, processorModel, processorCores,processorSpeed,processorArchitecture);
        this.memory = new Memory(memoryBrand, memoryModel, memoryCapacity,memoryType, memoryFrequency);
        // agregation
        this.storage = storage;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer: \n");
        sb.append("Processor: ").append(processor.toString()).append("\n");
        sb.append("Memory: ").append(memory.toString()).append("\n");
        sb.append("Storage: ").append(storage.toString()).append("\n");
        return sb.toString();
    }
}
