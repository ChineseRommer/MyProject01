class Solution {
    //这道题可以使用双指针，用两层for循环分别控制左右指针的移动，然后左右指针所指向的数相等时返回该数，这种双指针一定能够遍历所有
    //两个元素组合的情况。
    //这是我为数不多的自己写出来的算法！
    public int findDuplicate(int[] nums) {
        // //定义左右指针
        // int left = 0;
        // int right = nums.length - 1;

        //定义最终结果
        int ans = 0;//因为肯定存在，所以初始值是啥都无所谓，因为肯定会被覆盖

        //遍历所有情况
        for(int i = 0; i < nums.length; i++){
            for(int j  = i + 1; j < nums.length; j++){
                //比较两数组元素
                if(nums[i] == nums[j]){
                    ans = nums[i];
                }
            }
        }

        return ans;
    }
}