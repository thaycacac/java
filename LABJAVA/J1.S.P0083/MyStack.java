
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author THAYCACAC
 */
 /*
 Title 
  	Stacks
 Background 
	Stack is common data structures in real world such as: a stacks of glasses. Stacks act like “LIFO”, mean LAST IN- FIRST OUT.

Program Specifications
	Write a application to demo how stack works
	Create the MyStack class with following info:
	•	Properties
	o	stackValues, contain value of the stack
	•	Methods
	o	push(): Push a value to the stack
	o	pop(): Pop a value out from the stack
	o	get(): Get a value from the stack
Guidelines
	NA
*/
public class MyStack {

    Stack<Integer> stack = new Stack<>();
    int stackValues;

    public MyStack() {
    }

    public MyStack(int stackValues) {
        this.stackValues = stackValues;
    }

    public void push(int stackValues) {
        stack.push(stackValues);
    }

    public void pop() {
        System.out.println(stack.pop());
    }

    public void get(int position) {
        System.out.println(stack.get(position));
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Push values to the stack
        for (int i = 0; i < list.length; i++) {
            myStack.push(list[i]);
        }
//        Pop values out from the stack
        myStack.pop();
        myStack.pop();
//        Get values from the stack
        for (int i = 0; i < 3; i++) {
            myStack.get(i);
        }
    }

}
