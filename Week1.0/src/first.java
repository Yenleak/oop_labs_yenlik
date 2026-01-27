import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your name: "); 

        String name = scanner.nextLine();
        String line = "-".repeat(name.length());

        System.out.println("+" + line + "+");
        System.out.println("|" + name + "|");
        System.out.println("+" + line + "+");

        scanner.close();
    }
}