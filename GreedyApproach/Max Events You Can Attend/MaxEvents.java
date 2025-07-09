import java.util.*;

public class MaxEvents {
    public static int maxEvents(int[][] events) {
        // Sort by end day 
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        boolean[] attendedDays = new boolean[100001]; 
        int count = 0;

        for (int[] event : events) {
            int start = event[0];
            int end = event[1];

            // Try to attend the event on the earliest available day
            for (int d = start; d <= end; d++) {
                if (!attendedDays[d]) {
                    attendedDays[d] = true;
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] events = new int[n][2];
        for (int i = 0; i < n; i++) {
            events[i][0] = sc.nextInt();  // startDay
            events[i][1] = sc.nextInt();  // endDay
        }

        System.out.println(maxEvents(events));
    }
}
