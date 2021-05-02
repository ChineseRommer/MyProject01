class Solution {
    //这个为什么可以这样定义dp数组，那是因为，我们从左往右加时，当左边的数的总和加上新的数，如果小于这个新的数，那么说明左边那些数相加
    //就是一个负数，所以直接舍弃，不用有任何怜悯。可能有人会问，万一左边的数相加是负数，但是只加上左边最近的两个数可能是正数，那颗怎么办？
    //其实这种情况是不会出现的，因为如果有这种情况，最近的两个数相加大于0，那么我们在上一次循环中，就把这两个数当成是dp[i-2]或者dp[i-1]了
    //所以不用担心这种情况。至于前面几个数相加是正数，但后面相加就是负数，造成集体是负数，那么由于这里要求连续子序列，所以我们可能也要舍弃
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++){//以第i个数为结尾的连续子数组，其和最大为dp[i]
            //这里的循环必须从1开始，否则i-1也会地址越界，所以我刚刚一直出错！！！
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
        }
        //把最小整形数找出来，以方便dp[i]覆盖它
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}