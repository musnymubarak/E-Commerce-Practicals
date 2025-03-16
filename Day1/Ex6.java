import java.util.ArrayList;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Ex6 {
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 78));
        students.add(new Student("Charlie", 92));
        students.add(new Student("David", 88));
        students.add(new Student("Emma", 90));

        
        int totalMarks = 0;
        for (Student student : students) {
            totalMarks += student.marks;
        }
        
        double averageMarks = (double) totalMarks / students.size();

        System.out.println("Average Marks: " + averageMarks);
    }
}
