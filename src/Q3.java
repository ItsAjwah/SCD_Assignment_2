import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q3 {
    public static List<int[]> mergeintervals(List<int[]> intervals) //takes a list of intervals represented as arrays of integers as its parameter.
    {
        if (intervals.isEmpty()) {
            return new ArrayList<>();
        }

        List<int[]> merged_interval = new ArrayList<>();
        int[] curr_interval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] nextinterval = intervals.get(i);

            if (curr_interval[1] >= nextinterval[0]) { //merging curr and next interval
                curr_interval[1] = Math.max(curr_interval[1], nextinterval[1]);
            } else {
                // Add the current interval to the result and update the current interval
                merged_interval.add(curr_interval);
                curr_interval = nextinterval;
            }
        }

        // Add the last merged interval
        merged_interval.add(curr_interval);

        return merged_interval;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter intervals as pairs of start and end values. Enter '0 0' to stop.");

        List<int[]> intervals = new ArrayList<>();
        int interval_count = 1; //phli iteration

        while (true) {
            System.out.print("Enter interval " + interval_count + " (start end): ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            if (start == 0 && end == 0) {
                break; //stop hogye
            }

            intervals.add(new int[]{start, end});
            interval_count++;
        }

        List<int[]> mergedIntervals = mergeintervals(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }

        scanner.close();
    }
}
