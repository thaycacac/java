
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change taskList license header, choose License Headers in Project Properties.
 * To change taskList template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 
 */
public class TaskManager extends ArrayList<Task> {

    final GetData getdata = new GetData();
    final Display display = new Display();

    public int addTask(ArrayList<Task> TaskList, int id) {
        System.out.println("----------------Add Task------------------");
        String requirementName = getdata.getString("Requirement Name: ", "", "");
        String taskType = getdata.GetTaskType("Task Type: ");
        String date = getdata.getDate("Date: ");
        double planFrom = getdata.getDouble("From: ", "Plan From must be within 8h-17h", 8.0, 17.0);
        double planTo = getdata.getDouble("To: ", "Plan To must be within From to 17h30", planFrom + 0.5, 17.5);
        String Assignee = getdata.getString("Assignee: ", "", "");
        String reviewer = getdata.getString("Reviewer: ", "", "");
        boolean isExist = checkDuplicate(date, Assignee, planFrom, planTo, TaskList);
        //check value of variable isExist
        if (isExist) {
            System.out.println("Duplicate!!!");
        } else {
            Task newTask = new Task(id, taskType, requirementName, date, planFrom, planTo, Assignee, reviewer);
            TaskList.add(newTask);
            id++;
            System.out.println("Add successful!!");
        }
        return id;
    }

    boolean checkDuplicate(String date, String assignee, double planFrom, double planTo, ArrayList<Task> TaskList) {
        boolean isExist = false;
        //loop use to access each element of arraylist from begining to the end
        for (Task task : TaskList) {
            //compare date in list with date input and assignee in list and assignee input
            if (date.equals(task.getDate()) && assignee.equals(task.getAssignee())) {
                //compare planTo and planfrom with planFrom and planto in every task in list 
                //have date and assignee same with date, assignee input
                /*planto of object newtask must be lest than planFrom in list
                or planfrom of object newtask must be large than planto in list */
                if ((planTo < task.getPlanFrom()) || (planFrom > task.getPlanTo())) {
                    isExist = false;
                } else {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    void deleteTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("List task is empty!");
            return;
        } else {
            System.out.println("-------Del Task---------");
            int indexInList = -1;
            int TaskId = getdata.getInt("ID: ", "Task id is out of range!", 1, Integer.MAX_VALUE);
            //loop use to access each element of arraylist from begining to the end
            for (Task task : taskList) {
                //compare variable taskid with every taskId has in list
                if (TaskId == task.getTaskID()) {
                    indexInList = taskList.indexOf(task);
                }
            }
            //check indexInList not equal - 1 or not
            if(indexInList != -1){
                taskList.remove(indexInList);
                System.out.println("Delete successful!");
            }else{
                System.out.println("Id is not exist!");
            }

        }
    }


    public void getDataTasks(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("List task is empty!");
            return;
        } else{
            System.out.println("----------------------------Task-------------------------------------");
            System.out.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            //loop use to access each element of arraylist from begining to the end
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }


}
