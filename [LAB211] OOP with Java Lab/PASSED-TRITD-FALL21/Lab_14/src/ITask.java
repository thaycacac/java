


import java.util.ArrayList;

public interface ITask {
  
    public ArrayList addTask(ArrayList<Task> taskList) throws Exception;

    public ArrayList updateTask(ArrayList<Task> listTask) 
            throws Exception;
 
    public void deleteTask(ArrayList<Task> listTask) throws Exception;
    

    public void getDataTasks(ArrayList<Task> listTask, String formatDate) 
            throws Exception;
}
