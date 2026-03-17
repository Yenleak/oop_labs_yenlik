public class Student {
    private String studentName;
    private int studentID;
    private int studentYOS;
    private double grade; 

    public Student(String name, int id, int yos, double grade) {
        this.studentName = name;
        this.studentID = id;
        this.studentYOS = yos;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return String.format("Student %s, id: %d", studentName, studentID);
    }

    public void displayDetails() {
        System.out.println("Name - " + studentName);
        System.out.println("ID - " + studentID);
        System.out.println("Year of Study - " + studentYOS);
        System.out.println("Grade - " + grade);
    }
}