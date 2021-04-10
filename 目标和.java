class Solution {
    //这道题既可以使用回溯，也可以使用动态规划，但是动态规划中并不是正宗的背包问题，因为这个存在负数的情况，所以写状态转移方程会存在
    //dp[][]数组的索引为负值，还要索引加上数组总和来避免索引异常，非常麻烦，所以还是使用回溯算法

        //乘装结果的容器
        int result = 0;

    public int findTargetSumWays(int[] nums, int S) {

        //调用回溯方法
        trackback(0, 0, nums, S);

        return result;
    }

    //回溯方法
    public void trackback(int sum, int i, int[] nums, int s){
        if(nums.length == i){//每个数只能用一次，所以数量相等就说明完成
            if(sum == s){
                result++;
                // return ;
            }
            return ;//这样一来我就不用那个else了
        }
        //else{//如果没有这个else，就会出现长度够了，但是和不等于目标值的东西越过这个里层if，执行完外层if，就会再执行下方的做决策，导致i值越界
        //做决策（分两种情况）
        //加上当前这个数
        sum += nums[i];
        //进入下一层决策树
        trackback(sum, i+1, nums, s);
        //取消决策
        sum -= nums[i];

        //减掉当前这个数
        sum -= nums[i];
        //进入下一层决策树
        trackback(sum, i+1, nums, s);
        //取消决策
        sum += nums[i];
        //}
    }
}



























// public class Solution {
//     int count = 0;
//     public int findTargetSumWays(int[] nums, int S) {
//         calculate(nums, 0, 0, S);
//         return count;
//     }
//     public void calculate(int[] nums, int i, int sum, int S) {
//         if (i == nums.length) {
//             if (sum == S)
//                 count++;
//         } else {
//             calculate(nums, i + 1, sum + nums[i], S);
//             calculate(nums, i + 1, sum - nums[i], S);
//         }
//     }
// }
