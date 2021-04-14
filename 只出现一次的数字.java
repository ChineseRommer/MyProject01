class Solution {
    //为满足题意，可以使用位运算，位运算有三大性质：任何数与0异或都为它本身，任何数与自己异或都为0，异或满足交换律。
    //有了以上性质，就好做了，我们把数组中所有元素都互相异或，最后所有偶数个的数都利用交换律相当于自己和自己异或，都变成0了，
    //最后剩下的就是那个只出现一次的数字了。
    public int singleNumber(int[] nums) {
        int ans = 0;

        //遍历所有元素
        for(int i = 0; i < nums.length; i++){
            ans ^= nums[i];
        }

        return ans;
    }
}




























// class Solution {
//     public int singleNumber(int[] nums) {
//         int single = 0;
//         for (int num : nums) {
//             single ^= num;
//         }
//         return single;
//     }
// }
