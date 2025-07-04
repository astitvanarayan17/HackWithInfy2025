import java.util.*;

public class JobSequencingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of jobs
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        
        String[] jobIds = new String[n];
        int[][] jobs = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Job ID: ");
            jobIds[i] = sc.next();
            System.out.print("Enter Deadline: ");
            jobs[i][0] = sc.nextInt();
            System.out.print("Enter Profit: ");
            jobs[i][1] = sc.nextInt();
        }

        // Sorting by profit (descending) using simple selection sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (jobs[j][1] > jobs[i][1]) {
                    // Swap profits and deadlines
                    int tempProfit = jobs[i][1];
                    int tempDeadline = jobs[i][0];
                    jobs[i][1] = jobs[j][1];
                    jobs[i][0] = jobs[j][0];
                    jobs[j][1] = tempProfit;
                    jobs[j][0] = tempDeadline;
                    // Swap job IDs
                    String tempId = jobIds[i];
                    jobIds[i] = jobIds[j];
                    jobIds[j] = tempId;
                }
            }
        }

        // Find maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i][0] > maxDeadline) {
                maxDeadline = jobs[i][0];
            }
        }

        boolean[] slots = new boolean[maxDeadline + 1];
        String[] result = new String[maxDeadline + 1];
        int totalProfit = 0;

        // Job sequencing using pure arrays
        for (int i = 0; i < n; i++) {
            int deadline = jobs[i][0];
            int profit = jobs[i][1];
            for (int j = deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    result[j] = jobIds[i];
                    totalProfit += profit;
                    break;
                }
            }
        }

        System.out.print("Jobs done: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i]) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
}