class Solution {
    //这道题就是找规律对调，但是要注意，如果遍历所有矩阵元素对调，会发现本来对调好的又会被对调回去，所以我们只需要选取一半元素进行
    //遍历对调，如果行数时(n + 1)/2,那么列数是n/2。
    public void rotate(int[][] matrix) {
        // //获取行数列数
        int n = matrix.length;
        // int row = matrix.length;
        // int col = matrix[0].length;
        //遍历对调
        for(int i = 0; i < (n + 1)/2; i++){
            for(int j = 0; j < n/2; j++){
                //定义一个交换的中间变量
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

    }
}



























// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         for (int i = 0; i < n / 2; ++i) {
//             for (int j = 0; j < (n + 1) / 2; ++j) {
//                 int temp = matrix[i][j];                                      //temp = matrix[1][0];
//                 matrix[i][j] = matrix[n - j - 1][i];                          //matrix[1][0] = matrix[2][1];
//                 matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];          //matrix[2][1] = matrix[1][2];
//                 matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];          //matrix[1][2] = matrix[0][1];
//                 matrix[j][n - i - 1] = temp;                                  //matrix[0][1] = temp;
//             }
//         }
//     }
// }
