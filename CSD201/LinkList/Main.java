/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycustomlinkedlist;

/**
 *
 * @author sonnt
 */
public class Main implements IVisitable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyLinkedList<Student> list = new MyLinkedList<>(new Main());
        list.addToTail(new Student(1, "Vinh"));
        list.addToTail(new Student(2, "Long"));
        list.addToTail(new Student(3, "Nam"));
        list.traverse();
    }

    @Override
    public void visit(Object obj) {
        Student s = (Student)obj;
        System.out.println(s.getName());
    }
    
}
