class Laptop {
    private String brand;
    private int RAM;
    private int storageCapacity;
    private String operatingSystem;
    private String color;

    public Laptop(String brand, int RAM, int storageCapacity, String operatingSystem, String color) {
        this.brand = brand;
        this.RAM = RAM;
        this.storageCapacity = storageCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}