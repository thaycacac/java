


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TaskControl implements ITask {

    public static int menuChoice() {
        System.out.println("========= Task Program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Display Task");
        System.out.println("5. Exit");
        int userChoice = Validation.checkIntLimit("Enter your choice: ", 1, 5, true);
        return userChoice;
    }

    public Task inputTask(int taskID) {
        Task task = new Task();
        try {
            String rName = Validation.checkInputString("Requirement Name: ",
                    "^[A-Za-z ]+$", true);
            String taskTypeName = Validation.checkInputTaskTypeID("Task Type: ", true);
            Date date = Validation.checkInputDate("Date: ", "MMM-dd-yyyy", true);

            double from = Validation.checkDouble("From: ",
                    8.0, 17.0, true);
            double to = Validation.checkDouble("To: ",
                    from + 0.5, 17.5, true);

            String assign = Validation.checkInputString("Assignee: ",
                    "^[A-Za-z ]+$", true);
            String reviewer = Validation.checkInputString("Reviewer: ",
                    "^[A-Za-z ]+$", true);

            task = new Task(taskID, taskTypeName, rName, date,
                    from, to, assign, reviewer);
        } catch (Exception e) {
            System.out.println("There're an error found!");
        }
        return task;
    }

    @Override
    public ArrayList addTask(ArrayList<Task> listTask) throws Exception {
        System.out.println("\n---------- Add Task ----------");

        //declare taskID;
        int taskID = 1;
        //auto count taskID + 1
        
        if (!listTask.isEmpty()) {
            taskID = listTask.get(listTask.size() - 1).getID() + 1;
        }

        //call method input
        Task taskAdd = inputTask(taskID);

        //add Task object to listTask
        listTask.add(taskAdd);
        System.out.println("Add Success!!\n");
        return listTask;
    }

    @Override
    public ArrayList updateTask(ArrayList<Task> listTask)
            throws Exception {
        System.out.println("\n--------- Update Task ---------");

        //check listTask empty or not
        if (listTask.isEmpty()) {
            System.out.println("List Task Empty!\n");
            return listTask;
        }

        while (true) {
            //user input taskID
            int taskID = Validation.checkIntLimit("Requirement ID: ",
                    1, Integer.MAX_VALUE, false);

            Task taskExist = Validation.checkIDExist(taskID, listTask);
            if (taskExist != null) {
                //set rName
                String rName = Validation.checkInputString("New Requirement Name: ",
                        "^[A-Za-z ]+$", false);
                if (!rName.equalsIgnoreCase("nope")) {
                    taskExist.setRequirementName(rName);
                }

                //set typeName
                String typeName = Validation.checkInputTaskTypeID(
                        "New TaskTypeID: ", false);

                if (typeName != null) {
                    taskExist.setTaskTypeID(typeName);
                }

                //set newDate 
                Date newDate = Validation.checkInputDate("New Date: ",
                        "MMM-dd-yyyy", false);

                if (newDate != null) {
                    taskExist.setDate(newDate);
                }
                //10....
                //10.500000 = 10.5
                //8.00000 = 8.0
                //8.5000 = 8.5
                //8. = 8
                //8 = 8
                //nope = 0.0
                //set from
                double from = Validation.checkDouble("New From: ",
                        8.0, 17.0, false);

                if (from != 0.0) {
                    taskExist.setFromPlan(from);
                }

                //set to
                //0.0
                //old to = 13
                //new from = 15
                //new to = nope = 17
                double to;
                while (true) {
                    to = Validation.checkDouble("New To: ",
                            taskExist.getFromPlan() + 0.5, 17.5, false);

                    if (to != 0.0) {
                        taskExist.setToPlan(to);
                        break;
                    } else {
                        //oldFrom: 13. oldTo 15
                        //new from = 16
                        //to = nope
                        //get oldTo = 13
                        
                        //16 - 16.5
                        //new from = nope
                        //new to 
                        if (taskExist.getToPlan() < from) {
                            System.err.println("Old TaskTo [" + taskExist.getToPlan() + "] smaller "
                                    + "than New TaskFrom [" + taskExist.getFromPlan() + "]");
                        } else {
                            break;
                        }
                    }
                }

                //set assign
                String assign = Validation.checkInputString("New Assignee: ", "^[A-Za-z ]+$", false);
                if (!assign.equalsIgnoreCase("nope")) {
                    taskExist.setAssignee(assign);
                }

                //set review
                String review = Validation.checkInputString("New Review: ", "^[A-Za-z ]+$", false);
                if (!review.equalsIgnoreCase("nope")) {
                    taskExist.setReviewer(review);
                }

                System.out.println("Update Successful!\n");
                break;
            } else {
                System.err.println("TaskID Enter Does Not Exist!!");
            }
        }

        return listTask;
    }

    @Override
    public void deleteTask(ArrayList<Task> listTask) throws Exception {
        //check if listTask empty or not
        System.out.println("\n--------- Delete Task ---------");
        if (listTask.isEmpty()) {
            System.out.println("List Task Empty!\n");
            return;
        }

        try {
            int taskID;
            while (true) {
                //get taskID input by user
                taskID = Validation.checkIntLimit("ID: ", 1,
                        Integer.MAX_VALUE, true);
                Task task = Validation.checkIDExist(taskID, listTask);

                if (task != null) {
                    listTask.remove(task);
                    System.out.println("Delete Task Successful!");
                    break;
                } else {
                    System.out.println("Don't Find TaskID " + taskID + " to Delete!");
                }
            }
        } catch (Exception e) {
            System.out.println("Delete Task Fail!");
        }
    }

    @Override
    public void getDataTasks(ArrayList<Task> listTask, String formatDate) throws Exception {
        if (listTask.isEmpty()) {
            System.err.println("List Task Empty!");
            return;
        }
        //Date format
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        String dateString = "";

        System.out.println("\n----------------------------------"
                + " Task descending order "
                + "----------------------------------");

        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");

        //display task descending
//        for (int i = listTask.size() - 1; i >= 0; i--) {
//            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
//                    listTask.get(i).getID(),
//                    listTask.get(i).getRequirementName(),
//                    listTask.get(i).getTaskTypeID(),
//                    dateString = sdf.format(listTask.get(i).getDate()),
//                    listTask.get(i).getToPlan() - listTask.get(i).getFromPlan(),
//                    listTask.get(i).getAssignee(),
//                    listTask.get(i).getReviewer()
//            );
//        }
        
        /**
        * Sort using comparator
        * if open this comment stop implement Comparable in Task Object
        */
//        Collections.sort(listTask, new Comparator<Task>() {
//            @Override
//            public int compare(Task t1, Task t2) {
//                return -Integer.compare(t1.getID(), t2.getID());
//            }
//        });
        /**
         * 1, 2, 3 3, 2, 2, 2, 2, 2
         */
        
        Collections.sort(listTask);
        
        for (Task task : listTask) {
            System.out.println(task.display(formatDate));
        }
    }
}

