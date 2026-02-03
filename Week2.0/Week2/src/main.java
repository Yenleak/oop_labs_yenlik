
public class main {
    public static void main(String[] args) {

        Student student = new Student("Yenleak", 1);

        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());

        student.incrementYearOfStudy();

        System.out.println("Done!");
    }
}
