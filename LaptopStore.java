import java.util.*;


public class LaptopStore {
    private Set<Laptop> laptops = new HashSet<>();

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops(Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean passFilter = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "бренд":
                        if (!laptop.getBrand().equals(value)) {
                            passFilter = false;
                        }
                        break;
                    case "RAM":
                        if (laptop.getRAM() < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "Кол-во гб":
                        if (laptop.getStorageCapacity() < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "Операционная система":
                        if (!laptop.getOperatingSystem().equals(value)) {
                            passFilter = false;
                        }
                        break;
                    case "Цвет":
                        if (!laptop.getColor().equals(value)) {
                            passFilter = false;
                        }
                        break;
                    default:
                        System.out.println("Invalid filter criteria: " + key);
                        break;
                }
            }
            if (passFilter) {
                System.out.println("Matching laptop: " + laptop.getBrand());
            }
        }
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();
        store.addLaptop(new Laptop("HP", 8, 512, "Windows 10", "Black"));
        store.addLaptop(new Laptop("Dell", 16, 1024, "Ubuntu", "Silver"));
        store.addLaptop(new Laptop("Apple", 16, 512, "macOS", "Space Gray"));

        Map<String, Object> filters = new HashMap<>();
        Scanner in = new Scanner(System.in);
        Boolean startFilter = true;
        while (startFilter) {
            System.out.println("Выберите фильтры:");
            System.out.println("1 - бренд");
            System.out.println("2 - RAM");
            System.out.println("3 - Кол-во гигобайт");
            System.out.println("4 - Операционная система");
            System.out.println("5 - Цвет");
            System.out.println("6 - Закончить ввод фильтров(без фильтров)");
            int num = Integer.parseInt(in.nextLine());
            switch (num) {
                case 1:
                    System.out.println("Введите бренд:");
                    String nameOfBrand = in.nextLine();
                    filters.put("бренд", nameOfBrand);
                    break;
                case 2:
                    System.out.println("Введите RAM:");
                    int ramValue = Integer.parseInt(in.nextLine());
                    filters.put("RAM", ramValue);
                    break;
                case 3:
                    int gBValue = Integer.parseInt(in.nextLine());
                    filters.put("Кол-во гб", gBValue);
                    break;
                case 4:
                    String nameOfSistem = in.nextLine();
                    filters.put("Операционная система", nameOfSistem);
                    break;
                case 5:
                    String color = in.nextLine();
                    filters.put("Цвет", color);
                    break;
                case 6:
                    startFilter = false;
                default:
                    System.out.println("Введите правильное число");
                    break;
            }
        }
        in.close();

        System.out.println("Отфильтрованные ноутбуки:");
        store.filterLaptops(filters);
    }
}
