class Solution {
    public int trap(int[] height) {
        //使用双指针法
        int left = 0; 
        int right = height.length - 1;
        //定义一个左边的暂时最高边界
        int leftMax = 0;
        //定义一个右边的暂时最高边界
        int rightMax = 0;
        int ans = 0;
        //循环遍历
        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            //如果遍历到的新边的高度小于之前设置的暂时最大高度，那么该横坐标下可以存储的水的高度就为两者高度之差
            if(height[left] < height[right]){//如果左边值更小，先计算左边，以免以左边暂时最大值做边界时，右边的边界小于它，就无法装水了
                ans += leftMax - height[left];
                //左指针右移
                left++;
            }else{
                ans += rightMax - height[right];
                //右指针左移
                right--;
            }
        }

        return ans;
    }
}



























// class Solution {
//     public int trap(int[] height) {
//         int ans = 0;
//         int left = 0, right = height.length - 1;
//         int leftMax = 0, rightMax = 0;
//         while (left < right) {
//             leftMax = Math.max(leftMax, height[left]);
//             rightMax = Math.max(rightMax, height[right]);
//             if (height[left] < height[right]) {
//                 ans += leftMax - height[left];
//                 ++left;
//             } else {
//                 ans += rightMax - height[right];
//                 --right;
//             }
//         }
//         return ans;
//     }
// }
