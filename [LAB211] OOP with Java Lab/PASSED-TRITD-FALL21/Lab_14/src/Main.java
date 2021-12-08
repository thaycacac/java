


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Task> listTask = new ArrayList<>();
        
        TaskControl taskC = new TaskControl();
        int choice;
        
        while (true) {
            choice = TaskControl.menuChoice();
            switch (choice) {
                case 1:
                    listTask = taskC.addTask(listTask);
                    break;
                case 2:
                    listTask = taskC.updateTask(listTask);
                    break;
                case 3:
                    taskC.deleteTask(listTask);
                    break;
                case 4:
                    taskC.getDataTasks(listTask, "MMM-dd-yyyy");
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("EXIT...");
                    return;
            }
        }
    }

}
