class Solution {
    public int uniquePaths(int m, int n) {//用排列组合的思想，就是总共移动m+n-2次，其中m-1次是要向下移动的，所以C  m+n-2  m-1
        long ans = 1;//以免数值太大越界
        for(int x=n, y=1; y < m; x++, y++){//小于m是为了自加m-2次，分子分母都自加m-2次，再累乘就是最终结果
            ans = ans * x/y;//要先乘后除，以免变成除不尽被舍弃
        }
        return (int)ans;
    }
}