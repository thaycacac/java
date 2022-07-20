/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managetask;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeSyThanhLong
 */
public class Manager {

    List<Task> tasks = new ArrayList<>();
    Validate check = new Validate();

    public String getTaskType() {
        System.out.println("Choose task type:");
        System.out.println("1. Code");
        System.out.println("2. Test");
        System.out.println("3. Manage");
        System.out.println("4. Learn");
        int choice = check.inputInt("Enter your choice:", 1, 4);
        String type = null;
        switch (choice) {
            case 1:
                type = "Code";
                break;
            case 2:
                type = "Test";
                break;
            case 3:
                type = "Manager";
                break;
            case 4:
                type = "Learn";
        }
        return type;
    }

    public void addTask() {
        int ID;
        if (tasks.isEmpty()) {
            ID = 1;
        } else {
            ID = tasks.get(tasks.size() - 1).getId() + 1;
        }
        
        String requirementName = check.inputString("Enter requirement name:","[A-Za-z0-9\\s]+");
        String taskTypeID = getTaskType();
        String date = check.inputDate("Enter Date: ");
        double planFrom = check.inputDouble("Enter plan from: ", 0, 17);
        double planTo = check.inputDouble("Enter plan tot: ", planFrom + 0.5, 17.5);
        String assign = check.inputString("Enter assign: ","[A-Za-z0-9\\s]+");
        String reviewer = check.inputString("Enter reviewer: ","[A-Za-z0-9\\s]+");
        tasks.add(new Task(ID, taskTypeID, requirementName, date, planFrom, planTo, assign, reviewer));
    }

    public void removeTask() {
        int ID = check.inputInt("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (Task task : tasks) {
            if (task.getId() == ID) {
                tasks.remove(task);
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("ID does not exist");
    }

    public void display() {
        if(tasks.isEmpty()){
            System.out.println("No task");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : tasks) {
            double time= task.getPlanTo()-task.getPlanFrom();
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskTypeId(),
                    task.getDate(),
                    time,
                    task.getAssign(),
                    task.getReviewer()
            );
        }
    }
}
