class Solution {
    //这道题是一道典型的动态规划问题，虽然用中心拓展法更简便，但是为了践行套路做题的宗旨，我们还是使用动态规划来完成这道题。
    //说到动态规划，我们就一定要记住那三个特点:最优子结构，重叠子问题，状态转移方程。先想一下重叠子问题，给我们一个字符串，怎么判断它是不是
    //回文串呢？那就是先看两端的字母是否相同，如果两端的字母相同，再看中间的字符串是否是回文串（说到这里，肯定有人和我杠，说
    //我明明就是从最中间开始看的啊，然后再向两边扩展看字母是否一样，你这样看也好吧，但是特别长的字符串，你找中间位置都要找半天吧，
    //所以还是我说的从两边向中间找更好，或者说它更适合运用在动态规划中），如果中间的字符串也是回文串，这个整体就是
    //回文串，那么怎么判断中间的字符串是不是回文串呢？这又回到了最初的问题，就是再看中间字符串的两端字母是否相等，若相等再判断中中间字符串
    //是否是回文串，就这样一直惊醒下去，直到找到最中间的那一个或两个字母，这时候在比较两字母是否相等，相等则说明整体就是一个回文串，若最后
    //只剩一个字母，一个字母也是回文串，所以整体也是回文串，这就是重叠子问题。然后就是单个字母一定是回文串，这可以理解为最优子结构，然后
    //状态转移方程，就是一个二维数组dp[i][j]，这个代表字符串中从第i个字母到第j个字母中的字符串是否是回文串，那么二维数组的对角线上，也
    //就是单个字母一定都为true，如此便可解决此题了。
    public int countSubstrings(String s) {
        //先获取字符串长度，以便于后面使用
        int n = s.length();

        //定义一个计数变量
        int count = n;//单个字母的情况先考虑进来

        //定义dp数组
        boolean[][] dp = new boolean[n][n];

        //对单个字母的情况进行初始化
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        //遍历每一种情况的连续字符串的组合，并分类讨论，使用不同的状态转移方程
        for(int i = n-2; i >= 0; i--){//小于n-1是代表把最末尾单个字母的情况排除掉
        //这里之所以采用倒序相减是为了避免一些需要的子问题还没有被判断是否正确就被上层判断引用，造成结果少了
            for(int j = i + 1; j < n; j++){//从i+1开始是为了把最左边的单个字母的情况排除掉
                //分类讨论
                if(s.charAt(i) != s.charAt(j)){
                    // return false;//错误写法
                    dp[i][j] = false;
                }
                if(s.charAt(i) == s.charAt(j) && i+1 == j){
                    // count++;//这也不行，因为这只会记录连在一起的两个字母构成的回文串，不能记录没连在一起的回文串的个数
                    // return true;//错误写法
                    dp[i][j] = true;
                }
                if(s.charAt(i) == s.charAt(j) && i+1 != j){
                    //状态转移方程
                    dp[i][j] = dp[i+1][j-1];
                }

                if(dp[i][j] == true){
                    count++;
                }
            }
        }

        return count;
    }
}





























// class Solution {
//     public int countSubstrings(String s) {
//         int n = s.length(), ans = 0;
//         for (int i = 0; i < 2 * n - 1; ++i) {
//             int l = i / 2, r = i / 2 + i % 2;
//             while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
//                 --l;
//                 ++r;
//                 ++ans;
//             }
//         }
//         return ans;
//     }
// }








// class Solution {
//     public int countSubstrings(String s) {
//         int n = s.length();
//         boolean[][] dp = new boolean[n][n];
//         int count=0;
//         for(int j=0;j<n;j++)
//             for(int i=0;i<=j;i++)
//               if(s.charAt(j)==s.charAt(i))
//                     if(dp[i][j] = i==j || j-i==1 || dp[i+1][j-1])
//                         count++;
//         return count;
//     }
// }








// class Solution {
//     public int countSubstrings(String s) {
//         int size = s.length();
//         char[] ss = s.toCharArray();
//         // 初始化
//         boolean[][] dp = new boolean[size][size];
//         for (int i = 0 ; i < size; i++) {   // 主对角线，单个字符认为是长度为 1 的回文串
//             dp[i][i] = true;
//         }
//         // 填表并记录结果
//         int count = size;   // 至少单个字符都算是回文串
//         for (int i = size - 2; i >= 0; i--) {
//             for (int j = i + 1; j < size; j++) {
//                 if (ss[i] != ss[j]) {
//                     dp[i][j] = false;
//                 } else  if (i + 1 == j) {
//                     dp[i][j] = true;
//                 } else {
//                     dp[i][j] = dp[i + 1][j - 1];
//                 }
//                 // s[i ,j]是回文串吗
//                 if (dp[i][j] == true) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

