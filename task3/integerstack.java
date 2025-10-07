import java.util.Stack;
public class integerstack {
    Stack<Integer> stack = new Stack<>();

    // a. Push elements onto the stack
    public void pushElement(int element) {
        stack.push(element);
        System.out.println("Pushed: " + element);
    }

    // b. Pop elements from the stack
    public void popElement() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            System.out.println("Popped: " + popped);
        } else {
            System.out.println("Stack is empty. Cannot pop.");
        }
    }
    public void checkIfEmpty() {
        if (stack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The stack is not empty.");
        }
    }
public static void main(String[] args) {
        integerstack s = new integerstack();

        s.checkIfEmpty();
        s.pushElement(10);
        s.pushElement(20);
        s.checkIfEmpty();
        s.popElement();
        s.popElement();
        s.popElement(); 
    }
}