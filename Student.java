import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

// Main class
public class StudentGradeTracker {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Summary Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayReport();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        sc.close();
    }

    // Add student details
    private static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student grade: ");
        double grade = sc.nextDouble();

        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    // Display summary report
    private static void displayReport() {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        System.out.println("\n----- Student Report -----");

        for (Student s : students) {
            System.out.println("Name: " + s.getName() + " | Grade: " + s.getGrade());
            total += s.getGrade();

            if (s.getGrade() > highest)
                highest = s.getGrade();

            if (s.getGrade() < lowest)
                lowest = s.getGrade();
        }

        double average = total / students.size();

        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }
}
