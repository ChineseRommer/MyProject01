class Solution {
    //这道题暴力解法就是一层for循环，时间复杂度O(n)。但是想要时间复杂度为O(log n)，那就是双指针了
    public int[] searchRange(int[] nums, int target) {

        //定义一个二元数组
        int[] ans = new int[2];

        //定义一个flag，防止正确起始位置被覆盖
        int flag = 0;

        //定义区间左右边界
        int left = 0;
        int right = 0;

        //遍历所有数组
        for(int i = 0; i < nums.length; i++){
            if(flag == 0 && nums[i] == target){
                left = i;//将起始位置记住
                //防止起始位置被覆盖，做标记
                flag = 1;
            }
            if(flag == 1 && nums[i] != target){//末尾元素不是目标元素
                right = i - 1;
                break;//没必要再往下循环了，必须立马跳出循环，以免后面的覆盖污染结果
            }
            if(flag == 1 && nums[i] == target && i + 1 == nums.length){//以免出现数组最后一位也是目标元素，造成统计不上的错误
                right = i;
            }
        }

        //组装结果
        if(flag == 1){//如果为1，说明存在，那就返回新的值
            ans[0] = left;
            ans[1] = right;
        }
        if(flag == 0){//如果为0，那就说明不存在，那就设置成-1
            ans[0] = -1;
            ans[1] = -1;
        }

        return ans;
    }
}