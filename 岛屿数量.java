class Solution {
    //这道题使用深度优先遍历，一般说到深度优先遍历，我们就会联想到二叉树的前中后序遍历，但是这道题并不是二叉树，而是多叉树。对于多叉树，
    //我们应该如何处理呢？换汤不换药，我们可以将这道题看作多叉树的遍历。为何说是多叉树的遍历呢？因为当我们使用双重for循环遍历矩阵的每一个
    //元素时，如果是连在一起的一个岛屿，我们肯定要把岛屿的所有点都遍历完才行，也就是以该点位根节点，遍历其所有子节点，而每个点有几个子节点呢？
    //没错，就是4个，就是上下左右四个点，然后遍历到子节点再继续深度遍历，直到该岛屿的所有节点都被遍历完为止，而什么时候该岛屿的点就被遍历完
    //了呢？就是当节点的子节点都是0时，就说明这一支路都遍历完了，岛屿数量加一，所以这也是递归终止条件。但是我们需要注意的是，这样会出现
    //循环遍历的情况，就是相邻位置互为子节点，会被遍历多遍，使之永远无法终止递归，这可如何是好？我们可以把遍历过的节点的值都变为0，这样就可以
    //终止递归了。就这样有多少棵多叉树，我们就有多少个岛屿。如此此题可解！

     
    public int numIslands(char[][] grid) {
        //定义一个记录岛屿数的变量
        int ans = 0;

        //获取行数与列数
        int row = grid.length;
        int col = grid[0].length;

        //必须要for循环遍历所有节点，否则仅依靠岛屿自身节点的递归，会造成把自己岛屿遍历完后，到达不了其它岛屿了
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    //调用递归方法
                    dfs(grid, i, j);
                }
            }
        }
        
        return ans;
    }

    //递归方法
    public void dfs(char[][] grid, int row, int col){
        //递归终止条件
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0'){
            //不仅要排除大于，还要排除等于
            return ;
        }

        //标记被遍历过的元素
        grid[row][col] = '0';

        //多叉树的深度遍历
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }
}































// void dfs(int[][] grid, int r, int c) {
//     // 判断 base case
//     if (!inArea(grid, r, c)) {
//         return;
//     }
//     // 如果这个格子不是岛屿，直接返回
//     if (grid[r][c] != 1) {
//         return;
//     }
//     grid[r][c] = 2; // 将格子标记为「已遍历过」
    
//     // 访问上、下、左、右四个相邻结点
//     dfs(grid, r - 1, c);
//     dfs(grid, r + 1, c);
//     dfs(grid, r, c - 1);
//     dfs(grid, r, c + 1);
// }

// // 判断坐标 (r, c) 是否在网格中
// boolean inArea(int[][] grid, int r, int c) {
//     return 0 <= r && r < grid.length 
//         	&& 0 <= c && c < grid[0].length;
// }



// class Solution {
//     void dfs(char[][] grid, int r, int c) {
//         int nr = grid.length;
//         int nc = grid[0].length;

//         if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
//             return;
//         }

//         grid[r][c] = '0';
//         dfs(grid, r - 1, c);
//         dfs(grid, r + 1, c);
//         dfs(grid, r, c - 1);
//         dfs(grid, r, c + 1);
//     }

//     public int numIslands(char[][] grid) {
//         if (grid == null || grid.length == 0) {
//             return 0;
//         }

//         int nr = grid.length;
//         int nc = grid[0].length;
//         int num_islands = 0;
//         for (int r = 0; r < nr; ++r) {
//             for (int c = 0; c < nc; ++c) {
//                 if (grid[r][c] == '1') {
//                     ++num_islands;
//                     dfs(grid, r, c);
//                 }
//             }
//         }

//         return num_islands;
//     }
// }

