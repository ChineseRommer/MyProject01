// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length-1;
//         int ans = 0;
//         while(left < right){
//             int area = Math.min(height[left], height[right]) * (right - left);
//             ans = Math.max(area, ans);
//             if(height[left] < height[right]){
//                 left++;
//             }
//             else{
//                 right--;
//             }
//         }
//         return ans;
//     }
// }



























class Solution {
    //这道题就比较精妙，我们可以使用双指针法。我们可以使用while循环，只要左右指针不重合，我们就一直遍历下去，每一次遍历都要判断
    //当次循环下容水的最大值，这个容水最大值取决于左右指针最小值，然后乘以底边长。得到之后，然后判断谁更小，然后移动更小值的那个挡板。
    //为啥移动最更短的那个指针呢？因为我们多次循环比较，是为了得到更大的容积，如果我们移动较大值的那个挡板，那么最小值还是不变或者变得更小。
    //本次的最大容积还会因为底边长度变小而减少容积，所以只有移动较小值的那个指针，才有可能会得到更大的那个最小挡板长度，而总容积才有希望
    //变得更大。
    public int maxArea(int[] height) {
        //定义左右指针
        int left = 0;
        int right = height.length - 1;
        //定义初始d的容量最大值，方便后面循环比较
        int ans = 0;
        //循环遍历，寻找每一种情况下的容积，然后比较得到最大容积
        while(left < right){
            //计算本种情况下的容积
            int area = Math.min(height[left], height[right]) * (right - left);
            //循环比较最大容量
            ans = Math.max(ans, area);
            //移动左右指针，进行下一次循环
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return ans;
    }
}













