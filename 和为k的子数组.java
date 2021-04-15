class Solution {
    //这道题乍一看要暴力解法，使用回溯法，但是有一种比较简便的方法，就是利用双层for循环，然后内层循环是建立在外层循环参数的基础上的，
    //外层循环从左往右遍历，内层循环从外层循环的参数基础上从右往左遍历，并且一边遍历，一边sum求和，这样就可以得到所有数组的排列组合了，
    //然后遍历一下，比较一下，若等于目标值count就加1。
    public int subarraySum(int[] nums, int k) {
        //定义统计总数的变量
        int count = 0;

        //遍历所有组合情况
        for(int i = 0; i < nums.length; i++){
            //定义一个在某一种组合种情况下的求和变量
            int sum = 0;
            for(int j = i; j >= 0; j--){
                sum += nums[j];//对每种组合求和
                //比较是否等于目标值
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}






























// public class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
//         for (int start = 0; start < nums.length; ++start) {
//             int sum = 0;
//             for (int end = start; end >= 0; --end) {
//                 sum += nums[end];
//                 if (sum == k) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

