
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyProject implements IProject {
    //private Project[] projects;
    private List<Project> projects;//a list project

    public MyProject() {
        projects = new ArrayList();
    }

    @Override
    public void print() {
        //Heading
        System.out.printf("%-10s%-20s%-20s%-15s\n", "ID", "Name", "Sponsor",
                "Start Year");
        for (int i = 0; i < projects.size(); i++) {
            Project p = projects.get(i);
            System.out.printf("%-10d", i + 1);
            p.display();
        }
    }

    @Override
    public void addProject(Project p) {
        projects.add(p);//append p to the end of projects
    }

    @Override
    public void listProjectByYear(int year) {
        boolean found = false;
        for (int i = 0; i < projects.size(); i++) {
            Project p = projects.get(i); //p= projects[i] 
            if (p.getStarted() == year) {
                System.out.printf("%-10d", i + 1);
                p.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found any project started in " + year);
        }

    }

    @Override
    public void sortByStarted() {
        Collections.sort(projects);
    }

    @Override
    public void sortByName() {
        Collections.sort(projects, new CompareByName());
    }

}

class CompareByName implements Comparator<Project> {

    @Override
    public int compare(Project o1, Project o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

}
