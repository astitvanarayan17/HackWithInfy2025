import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of items
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        double[][] items = new double[n][2]; // Each item stores {value, weight}

        // Step 2: Input value and weight for each item
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            items[i][0] = sc.nextDouble();

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            items[i][1] = sc.nextDouble();
        }

        // Step 3: Input knapsack capacity
        System.out.print("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();

        // Step 4: Calculate value/weight ratios
        double[] ratios = new double[n];
        for (int i = 0; i < n; i++) {
            ratios[i] = items[i][0] / items[i][1];
        }

        // Step 5: Sort items by value/weight ratio using index array
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, (i, j) -> Double.compare(ratios[j], ratios[i]));

        // Step 6: Apply Fractional Knapsack logic
        double totalValue = 0.0;

        for (int idx : indices) {
            double value = items[idx][0];
            double weight = items[idx][1];

            if (capacity >= weight) {
                capacity -= weight;
                totalValue += value;
            } else {
                totalValue += value * ((double) capacity / weight);
                break;
            }
        }

        // Step 7: Output result
        System.out.printf("Maximum value in knapsack: %.2f\n", totalValue);

        sc.close();
    }
}
// This code implements the Fractional Knapsack problem using a greedy approach.