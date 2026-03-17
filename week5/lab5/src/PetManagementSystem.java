import java.util.ArrayList;

public class PetManagementSystem {

    public static void main(String[] args) {

        Person john = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Computer Science", "AI");

        Animal murka = new Cat("Murka", 5);

        john.assignPet(murka);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);

        System.out.println(registry);

        // John в отпуске
        john.leavePetWith(alice);

        System.out.println(registry);

        // John возв
        john.retrievePetFrom(alice);

        System.out.println(registry);
    }
}

// ANIMAL 

abstract class Animal {

    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getSound();

    public String toString() {
        return name + " (" + age + " years old)";
    }
}

//ANIMAL TYPES 

class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public String getSound() {
        return "Meow";
    }
}

class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    public String getSound() {
        return "Woof";
    }
}

class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    public String getSound() {
        return "Tweet";
    }
}

class Fish extends Animal {

    public Fish(String name, int age) {
        super(name, age);
    }

    public String getSound() {
        return "Bulck";
    }
}

// PERSON 

abstract class Person {

    protected String name;
    protected int age;
    protected Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void assignPet(Animal pet) {
        this.pet = pet;
    }

    public void removePet() {
        this.pet = null;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void leavePetWith(Person other) {

        if (!hasPet()) {
            System.out.println(name + " has no pet");
            return;
        }

        if (other instanceof PhDStudent && pet instanceof Dog) {
            System.out.println("PhD students cannot take care of dogs");
            return;
        }

        other.assignPet(pet);
        removePet();

        System.out.println(name + " left pet with " + other.name);
    }

    public void retrievePetFrom(Person other) {

        if (!other.hasPet()) {
            System.out.println(other.name + " has no pet");
            return;
        }

        assignPet(other.pet);
        other.removePet();

        System.out.println(name + " got pet back from " + other.name);
    }

    public abstract String getOccupation();

    public String toString() {

        String petInfo;

        if (pet == null)
            petInfo = "No pet";
        else
            petInfo = pet.toString();

        return name + " (" + getOccupation() + ") - Pet: " + petInfo;
    }
}

// EMPLOYEE 

class Employee extends Person {

    private String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    public String getOccupation() {
        return "Employee: " + jobTitle;
    }
}

//STUDENT 

class Student extends Person {

    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getOccupation() {
        return "Student: " + major;
    }
}

//PHD STUDENT 

class PhDStudent extends Student {

    private String researchField;

    public PhDStudent(String name, int age, String major, String researchField) {
        super(name, age, major);
        this.researchField = researchField;
    }

    public void assignPet(Animal pet) {

        if (pet instanceof Dog) {
            System.out.println("PhD students cannot have dogs");
            return;
        }

        super.assignPet(pet);
    }

    public String getOccupation() {
        return "PhD Student researching " + researchField;
    }
}

// REGISTRY

class PersonRegistry {

    private ArrayList<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
    }

    public void removePerson(Person p) {
        people.remove(p);
    }

    public String toString() {

        String result = "Registry:\n";

        for (Person p : people) {
            result += p + "\n";
        }
        return result;
    }
}