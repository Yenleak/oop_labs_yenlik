public class Animals {
    String name;

    public Animals(String name) {
        this.name = name;
        System.out.println("An object of the Animal class has been created!");
    }

    void makeSound() {
        System.out.println("The animal makes a sound");
    }
} 

class dog extends Animals {

    dog() {
        super(null);
    }
    
    dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " barks: Gav-gav!");
    }
    
    void eat() {
        System.out.println("The dog is eating");
    }

    void eat(String food) {
        System.out.println("The dog is eating a " + food);
    }
} 
class Main { 
    public static void main(String[] args) {
        dog myDog = new dog("Aqtos");
        
        myDog.makeSound(); 
        myDog.eat();       
        myDog.eat("meat"); 
    }
}