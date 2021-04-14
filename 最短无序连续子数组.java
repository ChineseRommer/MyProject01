class Solution {
    //这道题可以使用一个很聪明的暴力解法，就是从左到右依次取数组中的元素与数组中在它右边元素比较，如果发现这个元素小于它右边的元素，那么说明
    //至少这两个元素间的数都要排序，否则完成不了。我们先记下者两个元素所在位置，等到最后两者相减加一就是要排序的数组的长度，但是可能两个
    //元素中间还有一个更小的元素，需要更右边的元素加入到排序，所以为了不漏掉这种情况，我们要遍历所有数组元素，然后使用第二层for循环比较
    //在它右边的所有元素，然后实时更新最左指针和最右指针，最后结果就是最右指针减去最左指针。当然，如果数组本身就是有序的，或者是空数组，
    //那么最后相减是不大于0的，这时候返回0
    public int findUnsortedSubarray(int[] nums) {
        //定义最左指针和最右指针
        // int left = Integer.MAX_VALUE;
        // int right = Integer.MIN_VALUE;//这样不好，因为相减为负数后会造成超过int的最大容量，造成判断错误，影响最后结果
        int left = nums.length;
        int right = 0;

        //遍历比较所有数组元素
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    left = Math.min(left, i);
                    right = Math.max(right, j);
                }
            }
        }

        return (right - left < 0) ? 0 : (right - left + 1);
    }
}




























// public class Solution {
//     public int findUnsortedSubarray(int[] nums) {
//         int l = nums.length, r = 0;
//         for (int i = 0; i < nums.length - 1; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[j] < nums[i]) {
//                     r = Math.max(r, j);
//                     l = Math.min(l, i);
//                 }
//             }
//         }
//         return r - l < 0 ? 0 : r - l + 1;
//     }
// }
