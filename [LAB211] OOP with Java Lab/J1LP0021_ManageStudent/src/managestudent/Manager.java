/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author LeSyThanhLong
 */
public class Manager {

    /**
     * @param args the command line arguments
     */
    ArrayList<Student> students = new ArrayList<>();
    Validation validation = new Validation();

    public boolean checkStudentExist(String id, String name, String semester, String courseName) {
        for (Student student : students) {
            if (id.equals(student.getId())
                    && semester.equals(student.getSemester())
                    && name.equals(student.getStudentName())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    public Student checkIdExist(String id) {
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public void createStudent() {
        while (true) {
            String id = validation.inputString("Enter id:", "[A-Za-z0-9\\s]");
            Student student = checkIdExist(id);
            String name;
            if (student == null) {
                name = validation.inputString("Enter Name:", "[A-Za-z\\s]");
            } else {
                name = student.getStudentName();
            }
            String semester = validation.inputString("Enter semester:", "[A-Za-z0-9\\s]");
            String course = validation.checkInputCourse("Enter course:");
            if (checkStudentExist(id, name, semester, course)) {
                students.add(new Student(id, name, semester, course));
            } else {
                System.out.println("This record is existed.");
            }
            if (students.size() > 10) {
                boolean yesorno = validation.checkInputYN("Do you want to continue:");
                if (!yesorno) {
                    break;
                }
            }

        }
    }

    public void findAndSort() {
        String name = validation.inputString("Enter Name:", "[A-Za-z\\s]+");
        Collections.sort(students);
        if (students.isEmpty()) {
            System.out.println("No students");
        }
        for (Student student : students) {
            if (student.getStudentName().contains(name)) {
                student.print();
            }
        }

    }

    public void updateOrDelete() {
        String id = validation.inputString("Enter id", "[A-Za-z0-9\\s]+");
        ArrayList<Student> listStudentFindByID = getListStudentById(id);
        if (listStudentFindByID.isEmpty()) {
            System.out.println("Not found student.");
        } else {
            Student student = getStudentByListFound(listStudentFindByID);
            if (validation.checkInputUD("Do you want update or delete")) {
                while (true) {
                    String name = validation.inputString("Enter name:", "[A-Za-z\\s]+");;
                    String semester = validation.inputString("Enter semester:", "[A-Za-z\\s]+");
                    String course = validation.checkInputCourse("Enter course:");
                    if (!checkStudentExist(id, name, semester, course)) {
                        System.out.println("Duplicate");
                    } else {
                        if (!name.equalsIgnoreCase(student.getStudentName())) {
                            for (Student change_name : students) {
                                if (change_name.getId().equals(id)) {
                                    change_name.setStudentName(name);
                                }
                            }
                        }
                        student.setId(id);
                        student.setStudentName(name);
                        student.setSemester(semester);
                        student.setCourseName(course);
                        return;
                    }

                }

            } else {
                students.remove(student);
            }
        }
    }

    public ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    public Student getStudentByListFound(ArrayList<Student> listStudentFindByID) {
        System.out.println("List student found: ");
        int count = 0;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindByID) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        int choice = validation.inputInt("Enter choice:", 0, listStudentFindByID.size() - 1);
        return listStudentFindByID.get(choice);
    }

    public void report() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student student : students) {
            String key= student.getId()+"#"+student.getStudentName()+"|"+student.getCourseName();
            if(reports.containsKey(key)){
                int total= reports.get(key);
                reports.put(key, total+1);
            }else{
                 reports.put(key, 1);
            }

        }
        for (String key : reports.keySet()) {
            System.out.println(key.split("#")[1]+"|"+reports.get(key));
        }
    }

    public void generateStudent() {
        students.add(new Student("s1", "long", "fall", "Java"));
        students.add(new Student("s1", "long", "summer", ".NET"));
        students.add(new Student("s1", "long", "fall", "C/C++"));
        students.add(new Student("s2", "van", "fall", "Java"));
        students.add(new Student("s2", "van", "spring", "Java"));
        students.add(new Student("s3", "toan", "fall", "C/C++"));
        students.add(new Student("s4", "nam", "fall", "Java"));
        students.add(new Student("s5", "ha", "fall", ".NET"));
        students.add(new Student("s5", "ha", "summer", "Java"));
        students.add(new Student("s6", "man", "fall", "Java"));

    }

}
