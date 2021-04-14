class Solution {
    //不知道这道题有什么意思，如果不是二分查找，直接暴力解法，感觉针对无聊死了。
    public int search(int[] nums, int target) {
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                ans = i;
            }
        }

        return ans;
    }
}


















// class Solution {
//     public int search(int[] nums, int target) {
//         int n = nums.length;
//         if (n == 0) {
//             return -1;
//         }
//         if (n == 1) {
//             return nums[0] == target ? 0 : -1;
//         }
//         int l = 0, r = n - 1;
//         while (l <= r) {
//             int mid = (l + r) / 2;
//             if (nums[mid] == target) {
//                 return mid;
//             }
//             if (nums[0] <= nums[mid]) {
//                 if (nums[0] <= target && target < nums[mid]) {
//                     r = mid - 1;
//                 } else {
//                     l = mid + 1;
//                 }
//             } else {
//                 if (nums[mid] < target && target <= nums[n - 1]) {
//                     l = mid + 1;
//                 } else {
//                     r = mid - 1;
//                 }
//             }
//         }
//         return -1;
//     }
// }
