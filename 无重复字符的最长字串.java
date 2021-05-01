/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int n = s.length();
        int ans = 0;
        for(int left=0; left<n; left++){
            int right = left+1;
            if(left != 0){
                hs.remove(s.charAt(left));
            }
            while(right < n-1 && !hs.contains(s.charAt(right+1))){
               // hs.remove(s.charAt(left));
                hs.add(s.charAt(right));
                 ++right;
            }

            ans = Math.max(ans, right-left);
        }

    return ans;
    }
}
*/
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         // 哈希集合，记录每个字符是否出现过
//         Set<Character> occ = new HashSet<Character>();
//         int n = s.length();
//         // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
//         int rk = -1, ans = 0;
//         for (int i = 0; i < n; ++i) {
//             if (i != 0) {
//                 // 左指针向右移动一格，移除一个字符
//                 occ.remove(s.charAt(i - 1));
//             }
//             while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
//                 // 不断地移动右指针
//                 occ.add(s.charAt(rk + 1));
//                 ++rk;
//             }
//             // 第 i 到 rk 个字符是一个极长的无重复字符子串
//             ans = Math.max(ans, rk - i + 1);
//         }
//         return ans;
//     }
// }























class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        //定义一个Set集合，用来存储不重复的元素
        Set<Character> set = new HashSet<>();
        //定义左右指针，该指针中间部分，左闭右开，都是不重复的元素。
        int left = 0;
        int right = 0;
        //循环遍历左指针，每个左指针对应一个满足题意的右指针，且右指针是可以继承上一次循环的位置的，因为上一层循环已经说明中间是不重复的
        //然后在新的左指针的情况下，右指针从上一次的位置开始，继续遍历
        for(int i = 0; i < s.length(); i++){
            //如果是第一次遍历左指针，那么不用从集合中移除元素
            if(i > 0){
                set.remove(s.charAt(i - 1));//移除上一个左指针对应的字符  
            }
            //左指针右移
            // left++;

            //遍历右指针对应的字符
            for(int j = right; j < s.length(); j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    right++;//右指针右移
                }else{
                    break;
                }
            }
            
            //经过一次外层大循环，找到了该左指针下的最长不重复子串，不同左指针的最长不重复子串也要进行比较
            ans = Math.max(ans, right - i);
        }

        return ans;
    }
}