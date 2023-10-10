import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Q3 {
    public static void mergeintervals(List<int[]> intervals) {
        if (intervals.isEmpty()) {
            return;
        }
        int index = 0;
        int[] curr_interval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] nextinterval = intervals.get(i);

            if (curr_interval[1] >= nextinterval[0]) { // Merging curr and next interval
                curr_interval[1] = Math.max(curr_interval[1], nextinterval[1]);  //jo bara hoga
                // woi num return kerna
            } else {
                // Update the current interval  and agle index pey move hogye
                intervals.set(index, curr_interval);  //curr_interval, index ki jagh replace ho rh
                index++;
                curr_interval = nextinterval;
            }
        }

        intervals.set(index, curr_interval);
        index++;

        intervals.subList(index, intervals.size()).clear(); //any remaining intervals in the list after the newindex are removed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter intervals as pairs of start and end values. Enter '0 0' to stop.");

        List<int[]> intervals = new ArrayList<>();
        int interval_count = 1; // 1st index for iteration

        while (true) {
            System.out.print("Enter interval " + interval_count + " (start end): ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            if (start == 0 && end == 0) {
                break; // 0 0 pey stop kerdein gy
            }

            intervals.add(new int[]{start, end});
            interval_count++; //jesy ab 2 hogye ga
        }

        mergeintervals(intervals);

        for (int[] interval : intervals) {
            System.out.println("Merged Interval: [" + interval[0] +
                    ", " + interval[1] + "]");
        }

        scanner.close();
    }
}
