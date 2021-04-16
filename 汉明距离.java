class Solution {
    //这道题就是将两个数位运算异或，然后将得到的结果逐位右移，然后对2取余，得到末尾为1，记1的个数，这就是汉明距离了，最后得到最终结果
    public int hammingDistance(int x, int y) {
        //定义计数的变量
        int count = 0;
        //异或运算
        int result = x ^ y;
        //循环遍历，取1，计算1的个数
        while(result > 0){
            if(result % 2 == 1){
                count++;
            }
            //位运算右移
            result = result >> 1;
        }

        return count;
    }
}

// class Solution {
//     //直接调用内部API（没意思）
//     public int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);
//     }
// }































// class Solution {
//   public int hammingDistance(int x, int y) {
//     int xor = x ^ y;
//     int distance = 0;
//     while (xor != 0) {
//       if (xor % 2 == 1)
//         distance += 1;
//       xor = xor >> 1;
//     }
//     return distance;
//   }
// }

