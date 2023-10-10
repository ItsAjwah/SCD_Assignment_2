import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericStack<T> {
    private Node<T> top; // top of the stack
    private int size;
    private int cap;

    public GenericStack(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.top = null;
    }

    public void push(T item) {

        if (size() >= cap) {
            throw new GenericStackException("Stack is full. Cannot push more elements.");
        } else {
            Node<T> newnode = new Node<>(item);
            newnode.next = top;
            top = newnode;
            size++;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new GenericStackException("Stack is empty, there is no element to pop.");
        }
        T poppedValue = top.data;
        top = top.next;
        size--;
        return poppedValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {

        return size;
    }

//    public void displayStack() {
//        Node<T> now = top; //abhi wala node
//        while (now != null) {  //agr abhi wala null ni hy
//            System.out.println(now.data);  ///abhi wale node ka data print
//            now = now.next;  //or next node pey move kerdia
//        }
//    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int stack_size = scanner.nextInt();

        GenericStack<Integer> intStack = new GenericStack<>(stack_size);
        GenericStack<String> stringStack = new GenericStack<>(stack_size);
        GenericStack<Float> floatStack = new GenericStack<>(stack_size);

        boolean do_operation = true;

        while (do_operation) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Check if the stack is empty");
            System.out.println("4. Get the size of the stack");
            //System.out.println("5. Display the stack");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (intStack.size() < stack_size) {
                        System.out.print("Enter an element to push onto the stack: ");
                        if (scanner.hasNextInt()) {
                            int value = scanner.nextInt();
                            intStack.push(value);
                            System.out.println(value + " is Pushed into the stack.");
                        } else if (scanner.hasNextFloat()) {
                            float value = scanner.nextFloat();
                            floatStack.push(value);
                            System.out.println(value + " is Pushed into the stack.");
                        } else {
                            String value = scanner.next();
                            stringStack.push(value);
                            System.out.println(value + " is Pushed into the stack.");
                        }
                    } else {
                        System.out.println("Stack is full, Cannot push more elements.");
                    }
                    break;
                case 2:
                    try {
                        int poppedValue = intStack.pop();
                        System.out.println("Popped value is: " + poppedValue);
                    } catch (GenericStackException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Stacks are empty:");
                    System.out.println("Integer Stack: " + intStack.isEmpty());
                    // System.out.println("Stack is empty: " + intStack.isEmpty());

                    // System.out.println("Float Stack: " + floatStack.isEmpty());
                   // System.out.println("String Stack: " + stringStack.isEmpty());

                    break;
                case 4:
                    System.out.println("Sizes of the stacks:");
                    System.out.println("Integer Stack: " + intStack.size());
                    //System.out.println("Float Stack: " + floatStack.size());
                    //System.out.println("String Stack: " + stringStack.size());
                    break;

//                case 5:
//                    System.out.println("Stack elements:");
//                    intStack.displayStack();
//                   // stringStack.displayStack();
//                   // floatStack.displayStack();
//                    break;
                case 5:
                    do_operation = false;
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
