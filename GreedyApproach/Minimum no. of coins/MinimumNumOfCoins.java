import java.util.*;

public class MinimumNumOfCoins {
    public static void main(String[] args) {
        int amount = 93;
        int[] coins = {1, 2, 5, 10, 20, 50, 100};
        
        // Sort coins in ascending order (not necessary in this case since it's already sorted)
        Arrays.sort(coins);
        
        int count = 0;
        
        // Start from the largest coin and work downwards
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        
        System.out.println("Minimum coins needed: " + count);
    }
}