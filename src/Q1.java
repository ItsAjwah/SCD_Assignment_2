import java.util.LinkedList;
import java.util.Scanner;

class GenericStack<T> {
    private LinkedList<T> stack; //stack made
    private int Cap;

    public GenericStack(int maxsize) {
        stack = new LinkedList<>();
        this.Cap = maxsize; //sizee=maxsize
    }

    // Push an item onto the stack
    public void push(T item) {
        if (size() >= Cap) { //agr jo input aa rha uska size humri stack size se bara toh through exception
            throw new GenericStackException("Stack is full. Cannot push more elements.");
        }
        else {
            stack.push(item);
        }
    }


    public T pop() {
        if (isEmpty()) { //agr stack empty hy toh through excpetion
            throw new GenericStackException("Stack is empty,no element to pop.");
        }
        return stack.pop();  //jo top pey hy usko pop kr diengy
    }


    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public int size() {
        return stack.size();
    }


    public void displayStack() {
        for (T element : stack) { //element declared of T type
            System.out.println(element);
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the size of the stack: ");
        int size_of_stack = scanner.nextInt();

        //now genric(T type) stack will be made of size given by user
        GenericStack<Integer> mystack = new GenericStack<>( size_of_stack);

        boolean do_operation = true;

        while (do_operation) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Check if the stack is empty");
            System.out.println("4. Get the size of the stack");
            System.out.println("5. Display the stack");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (mystack.size() < size_of_stack) {
                        System.out.print("Enter an integer to push onto the stack: ");
                        int value = scanner.nextInt();
                        mystack.push(value);
                        System.out.println( value + " is Pushed into the stack.");
                    } else {
                        System.out.println("Stack is full, Cannot push more elements.");
                    }
                    break;
                case 2:
                    try {
                        int poppedvalue = mystack.pop();
                        System.out.println("Popped value is: " + poppedvalue);
                    } catch (GenericStackException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Stack is empty: " + mystack.isEmpty());
                    break;
                case 4:
                    System.out.println("Size of the stack: " + mystack.size());
                    break;
                case 5:
                    System.out.println("Stack elements:");
                    mystack.displayStack();
                    break;
                case 6:
                    do_operation= false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid operation.");
            }
        }

        System.out.println("Exiting the program.");
    }
}

class GenericStackException extends RuntimeException {
    public GenericStackException(String message) {
        super(message);
    }
}
