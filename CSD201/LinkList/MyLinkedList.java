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
public class MyLinkedList<T> {
    MyNode<T> head, tail;
    IVisitable visitor;
    
    public MyLinkedList(IVisitable visitor)
    {
        this.visitor = visitor;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void addToTail(T data)
    {
        MyNode<T> n = new MyNode<>();
        n.setData(data);
        if(isEmpty())
        {
            head = tail = n;
        }
        else
        {
            tail.setNext(n);
            tail = n;
        }
    }
    
    public void addToIndex(T data, int index)
    {
        
    }
    
    public void traverse()
    {
        MyNode<T> temp = head;
        while(temp!=null)
        {
            if(visitor!=null) visitor.visit(temp.getData());
            temp = temp.getNext();
        }
    }
}
