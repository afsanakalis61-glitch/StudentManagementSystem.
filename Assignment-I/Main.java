import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("-------------------");
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));

        System.out.println("Student Added Successfully!");
    }

    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public static void updateStudent() {

        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();

                System.out.println("Record Updated!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public static void deleteStudent() {

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {
                students.remove(s);

                System.out.println("Record Deleted!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Program Exited!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 5);
    }
}