// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m=word1.length();
//         int n=word2.length();
//         int[][] dp = new int[m+1][n+1];
//         for(int i=0; i<m+1; i++){
//             dp[i][0] = i;
//         }
//         for(int j=0; j<n+1; j++){
//             dp[0][j] = j;
//         }
//         for(int i=1; i<m+1; i++){
//             for(int j=1; j<n+1; j++){
//                 int a=dp[i][j-1]+1;
//                 int b=dp[i-1][j]+1;
//                 int c=dp[i-1][j-1];
//                 if(word1.charAt(i-1) != word2.charAt(j-1)){
//                     c += 1;
//                 }
//                 dp[i][j] = Math.min(a, Math.min(b, c));
//             }
//         }
//         return dp[m][n];
//     }
// }





























class Solution {
    //这道题是一道动态规划题，其实道理想通后就非常简单。
    //我们设置dp[i][j]数组，其代表字符串A的前i个字符转换为字符串B前j个字符，需要进行的改动为dp[i][j]。
    //其实所有改动可以分为三种情况：A增加（对应B减少），B增加（对应A减少）,A或者B改动一个字符
    //这三种情况对应的状态转移方程就是:dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1(如果两者第i个和第j个字符恰好相等就不用改动)
    //dp[i][j]就等于以上三种情况中数值最小的
    //利用双层for循环从单个字符到多个字符逐渐使用动态规划求值
    public int minDistance(String word1, String word2) {
        //获取两者的字符串长度
        int m = word1.length();
        int n = word2.length();
        //定义dp数组
        int[][] dp = new int[m + 1][n + 1];
        //定义basecase
        for(int i = 0; i < m + 1; i++){
            dp[i][0] = i;//对于一个字符串是null的情况，转换就需要增加i个字符
        }     
        for(int j = 0; j < n + 1; j++){
            dp[0][j] = j;
        }   
        //循环遍历逐渐求结果
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                //分类讨论三种情况
                int a = dp[i - 1][j] + 1;
                int b = dp[i][j - 1] + 1;
                int c = dp[i - 1][j - 1] + 1;
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){//字符串是按照索引来定位，所以等于第i个位置减去1
                    c--;//如果两者的对应位置字符本来就相等，那就没有必要改动，所以编辑距离还是原来的那个值，所以自减一下
                }
                //这三种情况都可以完成A的前i个字符到B的前j个字符的转化，所以要比较哪个编辑距离最小
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }

        return dp[m][n];
    }
}




















