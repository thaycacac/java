package Manager;

import Entity.Doctor;
import java.util.ArrayList;

/**
 *
 * @author THAYCACAC
 */
public class Manager {

    //display menu
    public static int menu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 5);
        return choice;
    }

    //allow user add doctor
    public static void addDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        //check code exist or not
        if (!Validate.checkCodeExist(ld, code)) {
            System.err.println("Code exist.");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int availability = Validate.checkInputInt();
        //check worker duplicate
        if (!Validate.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }

    //allow user update doctor
    public static void updateDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        //check code exist or not
        if (Validate.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        System.out.print("Enter code: ");
        String codeUpdate = Validate.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int availability = Validate.checkInputInt();
        //check user change infomation or not
        if (!Validate.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

    //allow user delete doctor
    public static void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    //allow user search doctor
    public static void searchDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter name: ");
        String nameSearch = Validate.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    //get docter by code
    public static Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    //get list found by name
    public static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
