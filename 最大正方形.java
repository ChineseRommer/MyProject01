class Solution {
    //说实话，这道题一上来就让我想到了大二时学的卡诺图！
    //这道题还是使用动态规划，但是状态转移方程不好想。这里简单说一下思想，dp[i][j] = x 代表以第i行第j列的元素为正方形的右下角，
    //那么这个正方形的最大边长为x，而处在最左边那一列和最上边那一行的所有元素，其能构成的正方形的最大边长只能是1，而以其它位置元素
    //为右下角的正方形的最大边长一定等于其左边那个元素、上面那个元素、左上方那个元素三个中边长最小的那个再加1，这就是规律。当然前提
    //还是那个元素的值为1.这样就差不多能解决这道题了。
    public int maximalSquare(char[][] matrix) {
        //特殊情况考虑一下
        if(matrix.length == 0 || matrix[0].length == 0){//不写也行，下面就进入不了for循环，直接返回0
            return 0;//空矩阵边长肯定是0
        }

        //获取矩阵长宽
        int m = matrix.length;
        int n = matrix[0].length;

        //定义正方形最大边长
        int max = 0;

        //定义dp数组
        int[][] dp = new int[m][n];

        //遍历每一个元素
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){//如果是1就要判断能构成多大的正方形,注意这里的1是char，要加单引号
                    //base case
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;//第一行和第一列只能构成边长为1的正方形
                    }
                    else{
                        //状态转移方程
                        // dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;//这样写是错的
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }

                //每循环一次，就要在矩阵的不同元素间比较谁构成的正方形边长最长
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;//返回最大面积
    }
}





