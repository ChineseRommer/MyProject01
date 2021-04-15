class Solution {
    //这道题我们可以使用动态规划解法，dp[i][j]代表第0行第0列那个元素（最左上方那个元素）到第i行第j列那个元素的最短路径和。然后我们要分析
    //重叠子问题，我们要求dp[i][j]，就可以这样理解：能够到达（i, j）这个元素，那肯定是从（i, j-1）或者(i-1, j)者两个元素中的一个元素
    //到达的，但是如何确定是哪一个呢？当然是选dp[i-1][j]和dp[i][j-1]中那个最小的了，然后这个最小值加上grid[i][j]的值就是最终答案了。
    //说到这里，我们就要顺带说明一下base case，如果某个元素的行为0，那么它只可能是由它的左方元素右移得到的，而对于列为0的元素，它只可能
    //是它的上方元素下移得到的，所以dp[0][j] = dp[0][j-1] + grid[0][j],而dp[i][0] = dp[i-1][0] + grid[i][0],而到达最左上方的那个元素
    //的最短路径就是它的权值，所以dp[0][0] = grid[0][0]。这样一来，我们就可以解决这道问题了。
    public int minPathSum(int[][] grid) {
        //获取矩阵行数与列数
        int row = grid.length;
        int col = grid[0].length;
        //创建dp数组
        int[][] dp = new int[row][col];

        // //考虑一下特殊情况，加不加都行
        // if(grid == null || grid.length == 0 || grid[0].length == 0){
        //     return 0;
        // }

        //定义base case
        dp[0][0] = grid[0][0];//代表只有一个元素,最短路径就是它的权值
        //到达第0行的所有元素的状态转移方程
        for(int i = 1; i < col; i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //到达第0列所有元素的状态转移方程
        for(int j = 1; j < row; j++){
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        //到达处于非边缘地区的所有元素的状态转移方程，都有两种选择，选取路径更小的那条
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }
}




























// class Solution {
//     public int minPathSum(int[][] grid) {
//         if (grid == null || grid.length == 0 || grid[0].length == 0) {
//             return 0;
//         }
//         int rows = grid.length, columns = grid[0].length;
//         int[][] dp = new int[rows][columns];
//         dp[0][0] = grid[0][0];
//         for (int i = 1; i < rows; i++) {
//             dp[i][0] = dp[i - 1][0] + grid[i][0];
//         }
//         for (int j = 1; j < columns; j++) {
//             dp[0][j] = dp[0][j - 1] + grid[0][j];
//         }
//         for (int i = 1; i < rows; i++) {
//             for (int j = 1; j < columns; j++) {
//                 dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//             }
//         }
//         return dp[rows - 1][columns - 1];
//     }
// }


