class Solution {
    //这道题是一个经典的动态规划问题，想要求和n的完全平方数的最小个数就先求n减去一个小于它的平方数的数的完全平方数的最小个数，看起来
    //有点拗口，直接上dp数组。这里 dp[n] = x 代表何为n的完全平方数的最小个数为x，那么状态转移方程就是dp[n] = dp[n - square(i)] + 1,
    //其中i<=sqrt(n)，这样相减之后才能是正数（前者是平方运算，后者是开方运算）。说到这里，我们不难想到要一层for循环来遍历所有小于n的平方数，
    //从而考虑到所有的子问题。但是只有一层for循环真的够吗？当然不够，假设dp[18] = dp[17] + 1，而dp[17] = dp[16] + 1，但是我们的dp[17]
    //的最优解还没有算出来，所以最终无法得到答案。所以，成功的路上没有捷径，我们只能从dp[1]到dp[17]再到dp[18]一步一步地算，如此才能
    //得到正确答案。所以我们最外层还是需要另外一层for循环，用来一步一步地求最优子结构。还有就是为了在使用
    //Math.min(dp[i], dp[i - Math.pow(j, 2)] + 1)能够正确覆盖原来的默认值（base case），我们需要给dp数组都填充成为最大的整形数Integer.MAX_VALUE
    //如此这道动态规划题就可以解决了！
    public int numSquares(int n) {
        //定义dp数组
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);//默认值填充成最大整形，方便覆盖

        //定义base case
        dp[0] = 0;

        //获得比n小的最大平方数的平方根
        int maxIndex = (int)Math.sqrt(n);

        //一步一步地求最优子结构
        for(int i = 1; i < n + 1; i++){//必须要是n+1,否则n就取不到了，最后一步就完成不了了
            for(int j = 1; j < maxIndex + 1; j++){
                //判断平方数是不是都比要求的数大了，如果都大了，那就没必要再遍历下去了
                if(Math.pow(j, 2) > i){
                    break;//这也是动态规划的终止条件了，否则假如永远到达不了base case，就永远状态转移了，最后导致dp数组索引越界
                }

                //状态转移方程
                int squareNum = (int)Math.pow(j, 2);//必须要转换，因为这个平方方法默认得到的结果是double类型的，就会报错
                dp[i] = Math.min(dp[i], dp[i - squareNum] + 1);
            }
        }

        return dp[n];
    }
}



























// class Solution {

//   public int numSquares(int n) {
//     int dp[] = new int[n + 1];
//     Arrays.fill(dp, Integer.MAX_VALUE);
//     // bottom case
//     dp[0] = 0;

//     // pre-calculate the square numbers.
//     int max_square_index = (int) Math.sqrt(n) + 1;
//     int square_nums[] = new int[max_square_index];
//     for (int i = 1; i < max_square_index; ++i) {
//       square_nums[i] = i * i;
//     }

//     for (int i = 1; i <= n; ++i) {
//       for (int s = 1; s < max_square_index; ++s) {
//         if (i < square_nums[s])
//           break;
//         dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
//       }
//     }
//     return dp[n];
//   }
// }
