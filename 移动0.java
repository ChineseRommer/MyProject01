class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while(right < n){
            if(nums[right] != 0){//注意这里不能再加上那个nums[left]==0了，否则就会在第一个数不为0时无法进入循环，最终使得无法正确移动0
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}