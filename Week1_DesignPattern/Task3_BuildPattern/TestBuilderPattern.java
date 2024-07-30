public class TestBuilderPattern {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("8GB")
            .setStorage("256GB SSD")
            .build();

        System.out.println(basicComputer);

        Computer gamingComputer = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 3080")
            .setMotherboard("ASUS ROG")
            .setCoolingSystem(true)
            .setPowerSupply(true)
            .build();

        System.out.println(gamingComputer);
    }
}
