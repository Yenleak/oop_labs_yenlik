import java.time.LocalDateTime;

enum CoffeeType {
    ESPRESSO, LATTE, CAPPUCCINO
}
public class Coffee2 {
    public static final String MACHINE_MODEL = "Model XJ1000";

    private static int totalCoffeeMade = 0;

    private final LocalDateTime creationTime;

    private CoffeeType type;
    private double volume;

    {
        this.creationTime = LocalDateTime.now();
    }

    public Coffee2() {
        this(CoffeeType.ESPRESSO, 50.0); 
        System.out.println("Создан кофе по умолчанию");
    }

    public Coffee2(CoffeeType type, double volume) {
        this.type = type;       
        this.volume = volume;
        totalCoffeeMade++;      
    }

    public CoffeeType getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public static int getTotalCoffeeMade() {
        return totalCoffeeMade;
    }

    public void prepare() {
        prepare(true); 
    }

    public void prepare(boolean addSugar) {
        System.out.println("Подготовка " + this.type + " объемом " + this.volume + " мл.");
        if (addSugar) {
            System.out.println("Добавлен сахар");
        } else {
            System.out.println("Без сахара");
        }
    }
    public static void main(String[] args) {
        System.out.println("Модель кофемашины: " + MACHINE_MODEL);

        Coffee2 myCoffee = new Coffee2(CoffeeType.LATTE, 200.0);
        myCoffee.prepare(); 

        Coffee2 defaultCoffee = new Coffee2();
        defaultCoffee.prepare(false); 

        System.out.println("Всего приготовлено кофе: " + Coffee2.getTotalCoffeeMade());
    }
}
