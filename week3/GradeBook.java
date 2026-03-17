import java.util.ArrayList;

public class GradeBook {
    private Course course;
    private ArrayList<Student> students;

    public GradeBook(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public double determineClassAverage() {
        if (students.isEmpty()) return 0;
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade(); 
        }
        return sum / students.size();
    }

    public Student getBestStudent() {
        if (students.isEmpty()) return null;
        Student best = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > best.getGrade()) best = s;
        }
        return best;
    }

    public Student getWorstStudent() {
        if (students.isEmpty()) return null;
        Student worst = students.get(0);
        for (Student s : students) {
            if (s.getGrade() < worst.getGrade()) worst = s;
        }
        return worst;
    }

    public void outputBarChart() {
        int a = 0, b = 0, c = 0, d = 0, f = 0;
        for (Student s : students) {
            double g = s.getGrade();
            if (g >= 90) a++;
            else if (g >= 80) b++;
            else if (g >= 70) c++;
            else if (g >= 60) d++;
            else f++;
        }
        System.out.println("Grade distribution:\nA: " + a + "\nB: " + b + "\nC: " + c + "\nD: " + d + "\nF: " + f);
    }

    public void displayGradeReport() {
        System.out.println("Welcome to the grade book for " + course.getName());
        System.out.println("Class average: " + determineClassAverage());
        System.out.println("Highest grade: " + getBestStudent());
        System.out.println("Lowest grade: " + getWorstStudent());
        outputBarChart();
    }
}