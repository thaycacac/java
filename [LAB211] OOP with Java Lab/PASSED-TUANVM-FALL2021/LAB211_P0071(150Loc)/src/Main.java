
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *

 */
public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        GetData getdata = new GetData();
        ArrayList<Task> taskList = new ArrayList<>();
        int id = 1;
        TaskManager manager = new TaskManager();
        int choice;
        
        do {
            //Display menu
            display.displayMenu();
            //get user choice
            choice = getdata.getInt("Your choice: ", "Choice must be in range [1-4]", 1, 4);
            switch (choice) {
                //1. Add Task
                case 1:
                    id = manager.addTask(taskList, id);
                    break;
                //2. delete task
                case 2:
                    manager.deleteTask(taskList);
                    break;
                //3. Display task
                case 3:
                    manager.getDataTasks(taskList);
                    break;
                //4. Exit
                case 4:
                    System.exit(0);
                    break;
            }
        }while (true);
    
    }
}
