
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {

    int id;
    String name;
    double cgpa;

    public Student() {
    }

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student s) {
        if (cgpa == s.cgpa) {
            if (name.compareTo(s.name) == 0) {
                if (id == s.id) {
                    return 0;
                } else if (id > s.id) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return name.compareTo(s.name);
            }
        } else if (cgpa > s.cgpa) {
            return -1;
        } else {
            return 1;
        }
    }
}

class Priorities {

    public Priorities() {
    }

    public static List<Student> getStudents(List<String> events) {
        ArrayList<Student> ls = new ArrayList<>();
        int lenEvents = events.size();
        double max = 0;
        for (int i = 0; i < lenEvents; i++) {
            String[] splitInput = events.get(i).split("\\s+");
            if (splitInput[0].equalsIgnoreCase("ENTER")) {
                if (Double.parseDouble(splitInput[2]) > max) {
                    max = Double.parseDouble(splitInput[2]);
                }
                ls.add(new Student(Integer.parseInt(splitInput[3]),
                        splitInput[1], Double.parseDouble(splitInput[2])));
            }
            if (splitInput[0].equalsIgnoreCase("SERVED")) {
                Collections.sort(ls);
                if (ls.isEmpty()) {
                    continue;
                }
                ls.remove(0);
            }
        }
        return ls;
    }
}

public class Solution {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
