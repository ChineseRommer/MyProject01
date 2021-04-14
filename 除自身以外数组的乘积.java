// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         //获取数组长度
//         int n = nums.length;

//         //定义一个数组来乘装所有结果
//         int[] ans = new int[n];

//         //定义一个记录所有成绩的变量
//         int all = 1;

//         //计算所有元素乘积
//         for(int i = 0; i < n; i++){
//             all *= nums[i];
//         }

//         //循环遍历赋值
//         for(int i = 0; i < n; i++){
//             if(nums[i] != 0){
//                 ans[i] = all/nums[i];
//             }
//         }

//         return ans;
//     }
// }





class Solution {
    //这道题很容易想到暴力法，就是两层for循环，外层是结果数组的元素遍历乘装，右侧是原数组各元素相乘的结果,但是题中时间复杂度不允许。
    //然后又想到除法，只用一层for循环，但是分母为0时就尴尬了。
    //这可如何是好？我们只要把每一个元素两边的乘积分别当作一个数组存储下来，当要求那个位置时，直接左边乘积数组乘以右边乘积数组，
    //就可以得到想要的的答案了。
    public int[] productExceptSelf(int[] nums) {
        //获取数组长度
        int n = nums.length;

        //定义一个数组来乘装所有结果
        int[] ans = new int[n];

        //定义左右乘积数组
        int[] left = new int[n];
        int[] right = new int[n];

        //循环求得左边乘积数组
        left[0] = 1;//第一个元素左边没有元素，所以设置成1
        for(int i = 1; i < n ; i++){
            left[i] = nums[i -  1] * left[i - 1];
        }

        //循环求得右边乘积数组
        right[n-1] = 1;//最右边的右面没有元素，所以设置成1
        for(int j = n - 2; j >= 0; j--){
            right[j] = nums[j + 1] * right[j + 1];//索引j的元素右边所有元素的乘积为数组j+1那个元素乘以之前右边所有元素的乘积
        }

        //计算结果数组
        for(int i = 0; i < n; i++){
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}











// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int length = nums.length;

//         // L 和 R 分别表示左右两侧的乘积列表
//         int[] L = new int[length];
//         int[] R = new int[length];

//         int[] answer = new int[length];

//         // L[i] 为索引 i 左侧所有元素的乘积
//         // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
//         L[0] = 1;
//         for (int i = 1; i < length; i++) {
//             L[i] = nums[i - 1] * L[i - 1];
//         }

//         // R[i] 为索引 i 右侧所有元素的乘积
//         // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
//         R[length - 1] = 1;
//         for (int i = length - 2; i >= 0; i--) {
//             R[i] = nums[i + 1] * R[i + 1];
//         }

//         // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
//         for (int i = 0; i < length; i++) {
//             answer[i] = L[i] * R[i];
//         }

//         return answer;
//     }
// }
