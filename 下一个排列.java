class Solution {
    //这道题说实在的还真不好想，这里我就简单说一下大牛们的思路吧。
    //想要找最小的下一个排列，我最先想到就是n重for循环，然后记录每一个排列，最后要求啥，直接找就行，但是者显然时间复杂度是不过关的，所以
    //我们要另寻他法。这里我就看到了一个大牛的想法，就是他发现，给定一个序列，我们首先要找到这个序列的倒数第一个升序的子序列的起始位置，
    //记住这个位置，然后注意了，我们再从后往前找，找到第一个大于这个起始位置元素的那个元素，然后两元素交换位置，这时候，倒数第一个升序的
    //子序列的起始位置，这时候一定变成降序的起始位置了，且该降序子序列一直会延伸到序列的结尾。这个时候，我们想要找到最小的下一个排列就
    //只需要把后面这个降序序列，从那个位置的下一个位置开始，重新排列位升序序列，如此就可得到答案。注意，由于是降序变升序，所以不用双层
    //for循环了，直接一层for循环，左右指针指向的元素交换即可。
    public void nextPermutation(int[] nums) {
        //获取数组长度-1
        int j = nums.length - 1;

        //寻找倒数第一个升序子序列
        while(j >= 1 && nums[j - 1] >= nums[j]){//这里的j-1就是我上面说到那个重要位置
            j--;
        }
        if(j >= 1 && nums[j - 1] < nums[j]){
            //从后往前，寻找第一个大于这个关键位置的元素的元素
            int i = nums.length - 1;
            while(i >= 0 && nums[i] <= nums[j - 1]){//不要忘了等于号，以免数组又重复的元素，对于等值的两个元素处理就容易出错
                i--;
            }
            //交换两个元素
            int temp = nums[j - 1];
            nums[j - 1] = nums[i];
            nums[i] = temp;
        }

        //完成上述步骤就得到关键位置到末尾的降序子序列，现在我们要将子序列改为升序子序列
        // for(int i = n + 1; i < nums.length; n++){
            int left = j;                   //左指针
            int right = nums.length - 1;    //右指针
            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; //左指针右移
                right--;//右指针左移
            }

    }
}































// class Solution {
//     public void nextPermutation(int[] nums) {
//         int len = nums.length;
//         for (int i = len - 1; i > 0; i--) {
//                 if (nums[i] > nums[i - 1]) {
//                     Arrays.sort(nums, i, len);
//                     for (int j = i; j <len; j++) {
//                         if (nums[j] > nums[i - 1]) {
//                             int temp = nums[j];
//                             nums[j] = nums[i - 1];
//                             nums[i - 1] = temp;
//                             return;
//                         }
//                     }
//                 }
//             }
//     	Arrays.sort(nums);
// 		return;  
//     }
//  }







//  class Solution {
//     public void nextPermutation(int[] nums) {
//         int i = nums.length - 2;
//         while (i >= 0 && nums[i] >= nums[i + 1]) {
//             i--;
//         }
//         if (i >= 0) {
//             int j = nums.length - 1;
//             while (j >= 0 && nums[i] >= nums[j]) {
//                 j--;
//             }
//             swap(nums, i, j);
//         }
//         reverse(nums, i + 1);
//     }

//     public void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }

//     public void reverse(int[] nums, int start) {
//         int left = start, right = nums.length - 1;
//         while (left < right) {
//             swap(nums, left, right);
//             left++;
//             right--;
//         }
//     }
// }

