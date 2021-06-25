class Solution {
    //这道题使用一个非常妙的解法，我把它称之为加减归零标记法
    //就是遍历所有元素，每比哪里一个就比较一下，如果与之前的那个数pre相同,数量就加一，否则数量减一，若减为0，则立马换掉pre，说明这个数成为了
    //新的众数。不过为了防止数组无序，导致之前统计的count都功亏一篑，所以要先对数组进行排序。
    public int majorityElement(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        int pre = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){//从1开始，因为上方等于已经对第0个元素进行考虑和操作了。
            if(nums[i] == pre){
                count++;
            }
            if(nums[i] != pre){
                count--;
            }
            if(count == 0){
                pre = nums[i];
                count++;//江山易主之后，我们要继续计数，所以把count加成1
            }
        }

        return pre;
    }
}





// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length / 2];
//     }
// }


























// class Solution {
//     public int majorityElement(int[] nums) {
//         int count = 0;
//         Integer candidate = null;

//         for (int num : nums) {
//             if (count == 0) {
//                 candidate = num;
//             }
//             count += (num == candidate) ? 1 : -1;
//         }

//         return candidate;
//     }
// }


