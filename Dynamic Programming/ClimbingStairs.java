class ClimbingStairs {
    int countWays(int n) {
        // your code here
        if (n == 0 || n == 1) return 1; 
        
        int[] dp = new int[n + 1];  // dp[i] = ways to reach step i
        dp[0] = 1;  // (no steps)
        dp[1] = 1;  // first step

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  
        }

        return dp[n];  // Number of ways to reach the top step
    }
}
