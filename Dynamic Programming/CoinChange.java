// coin change problem(Count Ways)
class CoinChange {
    public int count(int coins[], int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1; // 0

        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= sum; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        return dp[sum];
    }
}
