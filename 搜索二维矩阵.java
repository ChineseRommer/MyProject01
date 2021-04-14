// class Solution {
//     //先来一个暴力解法皮一下（坏笑）
//     public boolean searchMatrix(int[][] matrix, int target) {
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[0].length; j++){
//                 if(matrix[i][j] == target){
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
// }

class Solution {
    //这道题如果使用暴力解法简直无聊死了，而这种方法也体现不了聪明，所以我有一种缩减搜索范围法
    //我们可以从矩阵的左下角开始比较，如果该元素小于目标值，我们直接在该元素右边找，如果找到了返回true，如果没有返回false;
    //如果该元素大于目标值，直接回退到该元素的上一行元素，再比较，如果还是大，再往上走一行，直到小于目标值，然后使用第一种情况的方法即可
    public boolean searchMatrix(int[][] matrix, int target) {
        //先获得行数和列数
        int row = matrix.length;
        int col = matrix[0].length;
        //判断左下角的元素与目标值的大小
        if(matrix[row - 1][0] <= target){
            int i = row - 1;
            for(i = i; i >= 0; i--){
                for(int j = 0; j < col; j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        else{//如果大于目标值，这就退行
        int i = row - 1;
            while(matrix[i][0] > target){
                i--;//直到小于或等于目标值时再结束退行
                if(i < 0){
                    return false;//防止一直找不到，指针越界
                }
            }
            for(i = i; i >=0; i--){
                for(int j = 0; j < col; j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}



