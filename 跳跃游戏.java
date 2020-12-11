class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxlength = 0;//每次循环刚开始能够前进的步数
        for(int i=0; i<n; i++){
            if(maxlength >= i){//表示这次循环刚开始，能不能到达这次循环的起始位置
                maxlength = Math.max(maxlength, i+nums[i]);//更新可以到达的最远距离
                if(maxlength >= n-1){//如果可以到达的最远距离大于等于n-1（因为从nums[0]开始，所以中间元素个数是n-1），则一定能够到达末尾
                    return true;
                }
            }
        }
        return false;
    }
}