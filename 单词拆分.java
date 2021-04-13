class Solution {
    //这道题可以使用动态规划，我们可以设置一个dp数组，dp[i]，表示前i个字符组成的字符串在字符集合中。所以可以得到递推公式，
    //dp[i] = dp[j] + check(j, i)
    public boolean wordBreak(String s, List<String> wordDict) {
        //定义一个set集合,有序不可重复，方便判断检验字符串是否在集合中
        Set<String> wordDictSet = new HashSet(wordDict);

        //定义一个dp数组
        boolean[] dp = new boolean[s.length() + 1];

        //定义一个base case
        dp[0] = true;//空字符串符合题意

        //遍历所有情况，注意从左往右一步步遍历，以便于基础情况不会空
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 0; j < i + 1; j++){//确保能遍历到最后第i个字符
                //状态转移方程
                // dp[i] = dp[j] + wordDict.contains(s.substring(j, i));
                if(dp[j] && wordDict.contains(s.substring(j, i))){//不能是加号，应该是与号
                    dp[i] = true;
                    break;//比较完就走，以免结果被覆盖
                }
            }
        }

        return dp[s.length()];
    }
}































// public class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> wordDictSet = new HashSet(wordDict);
//         boolean[] dp = new boolean[s.length() + 1];
//         dp[0] = true;
//         for (int i = 1; i <= s.length(); i++) {
//             for (int j = 0; j < i; j++) {
//                 if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
//         return dp[s.length()];
//     }
// }