import java.util.HashSet;
import java.util.Objects;

//суперкласс
public class Device {
    private String brand;
    private String model;

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(brand, device.brand) && 
               Objects.equals(model, device.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    @Override
    public String toString() {
        return "Device: " + brand + " " + model;
    }
}

//подкласс
class Smartphone extends Device {
    private String serialNumber;

    public Smartphone(String brand, String model, String serialNumber) {
        super(brand, model);
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serialNumber);
    }

    @Override
    public String toString() {
        return super.toString() + " [SN: " + serialNumber + "]";
    }
}

// testt

class Main {
    public static void main(String[] args) {
        HashSet<Smartphone> phoneSet = new HashSet<>();

        Smartphone phone1 = new Smartphone("Apple", "iPhone 15", "SN12345");
        Smartphone phone2 = new Smartphone("Apple", "iPhone 15", "SN12345"); // дубликат
        Smartphone phone3 = new Smartphone("Samsung", "S23", "SN99999");

        phoneSet.add(phone1);
        phoneSet.add(phone2);
        phoneSet.add(phone3);

        System.out.println("Количество устройств в HashSet: " + phoneSet.size());
        
        for (Smartphone p : phoneSet) {
            System.out.println(p);
        }
    }
}
