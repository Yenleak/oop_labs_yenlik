public class Student {

    private String studentName;
    private int studentID;
    private int yearOfStudy;

    public Student(String name, int id) {
        studentName = name;
        studentID = id;
        yearOfStudy = 1;
    }

    public String getName() {
        return studentName;
    }

    public int getId() {
        return studentID;
    }

    public void incrementYearOfStudy() {
        yearOfStudy++;
    }
    
}
