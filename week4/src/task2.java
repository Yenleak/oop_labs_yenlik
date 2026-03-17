import java.util.Scanner;
import java.util.Vector;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<person> users = new Vector<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Person\n2. Add Student\n3. Add Staff\n4. Print All\n5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 5) break;

            if (choice == 4) {
                for (person p : users) System.out.println(p);
                continue;
            }

            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Address: "); String addr = sc.nextLine();

            if (choice == 1) {
                users.add(new person(name, addr));
            } else if (choice == 2) {
                System.out.print("Program: "); String prog = sc.nextLine();
                System.out.print("Year: "); int yr = sc.nextInt();
                System.out.print("Fee: "); double fee = sc.nextDouble();
                users.add(new student(name, addr, prog, yr, fee));
            } else if (choice == 3) {
                System.out.print("School: "); String school = sc.nextLine();
                System.out.print("Pay: "); double pay = sc.nextDouble();
                users.add(new staff(name, addr, school, pay));
            }
        }
    }
}

class person {
    private String name;
    private String address;

    public person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "person[ name= " + name + ", address= " + address + "]";
    }
}

class student extends person {
    private String program;
    private int year;
    private double fee;

    public student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "student[" + super.toString() + ",program= " + program + ",year= " + year + ",fee= " + fee + "]";
    }
}

class staff extends person {
    private String school;
    private double pay;

    public staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "staff[" + super.toString() + ",school=" + school + ",pay=" + pay + "]";
    }
}