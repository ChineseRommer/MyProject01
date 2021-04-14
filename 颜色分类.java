class Solution {
    //这道题使用单双指针皆可，杀鸡焉用牛刀，还是使用单指针，用for循环遍历数组，指针首先在第一个位置，如果元素值为0，该元素就与指针对应的
    //元素交换位置，0就到第一个位置了，指针下移，再进行第二次循环，同样判断。0找完后，指针所处位置就是1应该在的第一个位置，接着一样
    //for循环，找1，最后剩下的就全是3了，且都在最后面
    public void sortColors(int[] nums) {
        //定义一个全局指针
        int p = 0;

        //找0
        for(int i = 0; i < nums.length; i++){
            if(nums[i]  == 0){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }

        //找1
        for(int j = p; j < nums.length; j++){//不能将i设置成全局变量直接等于i，否则i是最后一个元素了，这个for循环执行不了
            if(nums[j] == 1){
                int temp = nums[p];
                nums[p] = nums[j];
                nums[j] = temp;
                p++;
            }
        }

    }
}




























// class Solution {
//     public void sortColors(int[] nums) {
//         int n = nums.length;
//         int ptr = 0;
//         for (int i = 0; i < n; ++i) {
//             if (nums[i] == 0) {
//                 int temp = nums[i];
//                 nums[i] = nums[ptr];
//                 nums[ptr] = temp;
//                 ++ptr;
//             }
//         }
//         for (int i = ptr; i < n; ++i) {
//             if (nums[i] == 1) {
//                 int temp = nums[i];
//                 nums[i] = nums[ptr];
//                 nums[ptr] = temp;
//                 ++ptr;
//             }
//         }
//     }
// }
