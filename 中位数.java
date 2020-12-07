class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for(int i=0; i<n; i++){//i代表字符串的长度
            for(int j=0; j<n-i; j++){
                int k = j+i;
                if(i == 0){
                    dp[j][k] = true;
                }
                else if(i == 1){
                    dp[j][k] = (s.charAt(j) == s.charAt(k));
                }
                else{
                    dp[j][k] = ((s.charAt(j) == s.charAt(k)) && dp[j+1][k-1]);
                }
                // if(dp[j][k] && i+1>ans.length())
                //  ans = ans + s.charAt(j);
                 if (dp[j][k] && i+1 > ans.length()) {
                     ans = s.substring(j, i + j + 1);
                }
            }
        }
        return ans;
    }
}
