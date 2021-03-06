class Solution {
    //这道题啥也别说了，就两个字：巧妙！
    //这道题既可以使用回溯法，也可以使用动态规划，但是回溯法时间复杂度是n的阶乘倍，难以通过所有测试用例。所以只简单说一下思路，就是做决策就是将
    //你选中的气球从数组中删除，然后将新数组和新的得分（选项集和结果集）送入下一层决策树，然后再取消选择，就是将被散出的元素重新添加到数组中。
    //如果数组为null了，就将当前的得分与之前的得分作比较取最大，当然原始得分要显示地赋值为0。如此便可解答。
    //但是我们为了时间复杂度达标，就必须使用动态规划算法。这个动态规划的状态转移方程是最难找的了，因为很巧妙，这里就不卖关子，直接说了。
    //我们在气球数组两端分别加一个虚假气球，权值为1。然后再在新数组中间选择任意一个气球作为最后被戳破的那个，对，你没有看错，就是最后被戳破，
    //这样做有什么好处呢？先申明dp数组的意思，就是在第i个气球和第j个气球之间，戳破所有气球所获得的最大值。
    //就是你想要求dp[i][j]的最大值，这就转换成了你要求dp[i][k] + dp[k][j] + points[i]*points[k]*points[j]的最大值了，
    //因为k是最后被戳破，所以就可以得到以上状态转移方程。然后dp[i][k]和dp[k][j]的最值也可以转换成相同的子问题，一直到什么时候呢？一直到
    //i和j之间已经没有气球了，这个时候dp[i][j] = 0，注意，这恶鬼我们可以在数组初始化时就完成，不用后面再判断赋值。当然，k要实时变换位置，
    //所以应该有个for循环遍历i到j，当然，i和j的值也是要不断变换的，否则只能考虑到一种情况，所以还需要在外层加上两层for循环。有了不断变化
    //的戳气球方案，那么怎么在这么多方案中找到最优的那个方案呢？那我们只需要在最里层循环加上一个Math,max(dp[i][j],dp[i][k]+dp[k][j]+...)
    //即可，注意这里的dp[i][j]是在每一次循环中都要动态更新的，而最原始的那个就是0，所以后来的一定能够覆盖它，至少不会比它小。说到这里，
    //我们不得不注意遍历顺序，如果最外层for循环遍历顺序是从左往右的话，那么就会造成还没被正确求出最值的dp数组元素，就被其它dp数组元素调用，
    //导致跟回文子串一样的空指针异常。所以我们还是采用从右往左的遍历顺序。这样这道题就可以通过动态规划解决了！
    public int maxCoins(int[] nums) {
        //获取气球数组长度
        int n = nums.length;
        //定义一个加入两个虚拟气球的数组
        int[] points = new int[n + 2];
        //给新数组赋值
        points[0] = points[n+1] = 1;
        for(int i = 1; i < n+1; i++){//第一个和最后一个已经被赋值了
            points[i] = nums[i - 1];
        }

        //定义dp数组
        int[][] dp = new int[n + 2][n + 2];

        //遍历所有戳气球的选择
        for(int i = n + 1; i >= 0; i--){//左边界的遍历
            for(int j = i + 1; j < n + 2; j++){//右边界的遍历
                for(int k = i + 1; k < j; k++){//最后被戳的气球的选择
                    //状态转移方程
                    dp[i][j] = Math.max(dp[i][j],
                                        dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }

        return dp[0][n + 1];
    }
}









