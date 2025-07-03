import java.util.*;

public class Problem1_ActivitySelection {

    public static void main(String[] args) {
        
        int activities[][] = {
            {1, 3},
            {2, 4},
            {3, 5},
            {0, 6},
            {5, 7},
            {8, 9},
        };

        int n = activities.length;
        // Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // int[][] activities = new int[n][2]; // Each activity: [start, end]

        // for (int i = 0; i < n; i++) {
        //     activities[i][0] = sc.nextInt(); // start time
        //     activities[i][1] = sc.nextInt(); // end time
        // }

        // Sort by end time
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEndTime = -1;

        for (int i = 0; i < n; i++) {
            if (activities[i][0] >= lastEndTime) {
                count++;
                lastEndTime = activities[i][1];
            } else {
       
            }
    }

        System.out.println(count);
    }
}
// This code implements the Activity Selection problem using a greedy approach.