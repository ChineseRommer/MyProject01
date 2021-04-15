class Solution {
    //这道题又是求最值的，我们也可以使用动态规划。dp[i]就代表前i个数的相乘之积，状态转移方程就是
    //dp[i] = Math.max(dp[i - 1] * nums[i], dp[i - 1], nums[i])。base case就是dp[0] = nums[0]; 
    //但是这就真的完美了吗？
    //并没有，如果前面有负数，没乘进去，之后又有一个负数，又没乘进去，本来可以负负得正的，但都浪费了，这可如何是好？
    //我们可以设置一个最小dp数组，用来记录每一个位置乘积的最小值。最小值肯定就是负数了，否则成一个正整数，咋也不可能乘得变小。
    //所以我们在后面选择里加上最小乘积乘以当前元素，说不定就乘出正数了，这样就行了。还要注意的是，dp[i - 1]参与评选一定是负数，
    //因为它没有乘以正整数变大，那就一定是乘以一个负数变小了，所以上面那个dp[i - 1]是没有必要的。
    public int maxProduct(int[] nums) {
        //定义最大和最小dp数组
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        //base case
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        //遍历每一个位置，算出最大乘积和最小乘积
        for(int i = 1; i < nums.length; i++){
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));
        }

        //筛选最终结果
        int ans = maxDp[0];
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, maxDp[i]);
        }

        return ans;
    }
}






























// class Solution {
//     public int maxProduct(int[] nums) {
//         int length = nums.length;
//         int[] maxF = new int[length];
//         int[] minF = new int[length];
//         // System.arraycopy(nums, 0, maxF, 0, length);
//         // System.arraycopy(nums, 0, minF, 0, length);
//         //base case
//         maxF[0] = nums[0];
//         minF[0] = nums[0];
//         for (int i = 1; i < length; ++i) {
//             maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
//             minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
//         }
//         int ans = maxF[0];
//         for (int i = 1; i < length; ++i) {
//             ans = Math.max(ans, maxF[i]);
//         }
//         return ans;
//     }
// }


