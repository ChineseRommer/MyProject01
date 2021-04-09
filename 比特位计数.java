class Solution {
    //这道题是一道动态规划问题，为啥我这么确定是动态规划问题呢？因为动态规划问题有三大特点：重叠子问题，最优子结构，可列出状态转移方程。
    //我们先来分析一下这个题的解题思想：我们知道，二进制中，偶数被除以2后的1的个数不变，因为这就是右移运算，最右边为0，所以不影响。
    //奇数的1的个数一定是等于它前面的那个偶数的1的个数加1，因为奇数就是 在那个偶数的基础上在最右边加1的得到的。所以我们可以写出最关键的一步:
    //就是状态转移方程。然后我们发现其最基础的子问题就是0的1的个数是0，1的1的个数是1，这也可以理解为最优子结构了，然后在此基础上我们可以
    //推导出任意自然数的二进制的1的个数。重叠子问题在这道题中意义不太大，因为对内存及运行时间影响不大，所以忽略。注意这里1的1的个数也可以由
    //0的1的个数推出来，所以最优子结构只需要0的1的个数即可
    public int[] countBits(int num) {
        //乘装所有结果的大容器
        int[] result = new int[num + 1];
        
        //遍历数组，一层层向下剥离
        for(int i = 1; i < result.length; i++){//直接从1开始，否则在里面又会重新计算0的1的个数，导致结果出错
            //最优子结构
            result[0] = 0;

            //状态转移方程
            if((i & 1) == 0){//如果为偶数(偶数与1按位相与，肯定为0)  ,记住加括号
                result[i] = result[i >> 1]; //二进制序列向右移
            }
            if((i & 1) == 1){//奇数与1按位相与肯定为1
                result[i] = result[i - 1] + 1;
            }
        }

        return result;
    }
}




























// class Solution {
//     public int[] countBits(int num) {
//         int[] bits = new int[num + 1];
//         for (int i = 0; i <= num; i++) {
//             bits[i] = countOnes(i);
//         }
//         return bits;
//     }

//     public int countOnes(int x) {
//         int ones = 0;
//         while (x > 0) {
//             x &= (x - 1);
//             ones++;
//         }
//         return ones;
//     }
// }


//这方法太牛批了！
// class Solution {
//     public int[] countBits(int num) {
//       int[] result = new int[num + 1];
//       for(int i = 1; i <= num; i++){
//         if ((i & 1) == 0){
//           result[i] = result[i >> 1];
//         }else {
//           result[i] = result[i - 1] + 1;
//         }
//       }
//       return result;
//     }
// }