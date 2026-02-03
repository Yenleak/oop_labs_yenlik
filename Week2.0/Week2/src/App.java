
import java.util.Scanner;
public class App{
    public static void main(String[] args) {
        System.out.println("Salem, Yenleak");
        int a=5;
        int c=6;
        int b=++a+c+a++;
        System.err.println("a+c= " +b );

        int apple=120;
        int banana= 300;
        System.err.println("apple + banana="+ (apple+banana));

        System.out.println("-How are you?");

        Scanner scanner= new Scanner(System.in);
        System.err.println("(atyndy zhaz: )");

        String at= scanner.nextLine();
        System.out.println("-My name is "+ at );

        scanner.close();
    }
}