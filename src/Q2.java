import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2 {
    private final int maxchar = 256;  // 256 since there are 256 possible ASCII characters.
    private Queue<Character> queue;
    private int[] intcount_arr; //This is an array of integers used to count the
    // occurrences of each character in the stream

    public Q2() {  //constructor bna lia
        queue = new LinkedList<>();
        intcount_arr = new int[maxchar];  //256 size rkh dia array ka
    }
    public void add(char c) {

        intcount_arr[c]++;  //jo character aya usme increse kerdia

        queue.add(c);  //phr char ko q mei dal dia

        //jab tk non repeating ni aa jata remove charcctres from queue
        while (!queue.isEmpty() && intcount_arr[queue.peek()] > 1) {
            queue.poll();  // it removes and returns the element at the front of the queue.
        }
    }

    public char nonrepeating() {
        if (queue.isEmpty()) {
            return '-';
        }
        return queue.peek();  // it removes and returns the element at the front of the queue.
    }

    public static void main(String[] args) {
        Q2 inputs = new Q2();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter some characters: ");
        String input = scanner.nextLine();

        for (char c : input.toCharArray()) {
           inputs.add(c);
        }
       /* for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            inputs.add(c);
        }*/

        char first_nonrepeat = inputs.nonrepeating();
        System.out.println("First Non-Repeating Character: " + first_nonrepeat);

        scanner.close();
    }
}
