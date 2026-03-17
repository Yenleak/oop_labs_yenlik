
import java.util.ArrayList;
import java.util.Scanner;

public class GradebookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> prereqs = new ArrayList<>();
        prereqs.add("Programming 1");

        Course course = new Course("CS101", "OOP", 5, prereqs);

        GradeBook gradebook = new GradeBook(course);

        System.out.print("How many students? ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Year: ");
            int yos = scanner.nextInt();
            System.out.print("Grade: ");
            double grade = scanner.nextDouble();

            Student s = new Student(name, id, yos, grade);
            gradebook.addStudent(s);
        }

        gradebook.displayGradeReport();
    }
}

//javac GradeBook.java Student.java Course.java GradebookTest.java
//java GradebookTest
//осыны қоямынн