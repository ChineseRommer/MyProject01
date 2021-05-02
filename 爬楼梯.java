/*class Solution {
    public int climbStairs(int n) {
        int left=1;
        int mid=1;
        int right=2;
        if(n==1) return 1;
        else if(n==2) return 2;
        else{
        for(int i=2; i<n; i++){
            left = mid;
            mid = right;
            right = left+mid;
        }
        }
        return right;
    }
}
*/

// class Solution{
//     public int climbStairs(int n){
//         int left=0;
//         int mid=0;
//         int right=1;
//         for(int i=0; i<n; i++){
//             left = mid;
//             mid = right;
//             right = left+mid;
//         }
//         return right;
//     }
// }





























class Solution{
    //使用动态规划，dp[i]代表到达第i级台阶的方案数，则dp[i] = dp[i - 1] + dp[i- 2];
    //而basecase就是dp[0] = 0; dp[1] = 1; dp[2] = 2;
    public int climbStairs(int n){
        //设置dp数组
        int[] dp = new int[n + 1];
        //定义basecase
        dp[0] = 0;
        if(n > 0){
            dp[1] = 1;
        }
        if(n > 1){
            dp[2] = 2;
        }
        for(int i = 3; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}















