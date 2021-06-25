class Solution {
    //这道题也是一道经典的回溯算法题。说到回溯算法，还是那几步：做决策（选择决策树的哪条路径），进入下一层决策树，取消决策。首先看一下
    //这个做决策，这里做决策有两种选择，就是选左括号还是选右括号，由于只有两种选择，所以有点像二叉树的深度遍历，而之前的那个电话号码组合
    //字母由于有多种选择，所以就类似于多叉树的深度遍历。这里的做决策，如果想要往左走，就要判断左括号数是否还大于0，否则无法继续添加
    //左括号。往右边走，就要判断是否剩余左括号数是否少于右括号数，因为我们一定是先写左括号，后写右括号，所以左括号数一定是少于或等于
    //左括号数的，所以要再添加右括号，就要满足左括号数小于右括号数。做决策就是将左括号或右括号添加到一个结果字符串中。然后进入下一层决策树
    //就需要修改回溯方法的参数，比如左右括号数量减一。说到这里，就顺便提一下回溯终止条件，那就是左右括号同时减为零时，就说明
    //括号已经使用完了。最后是取消决策，就是将结果字符串删除掉最后的一个字符，该字符的索引应该是现在字符串长度减一。
    public List<String> generateParenthesis(int n) {
        //定义一个乘装所有结果的大容器
        List<String> ans = new ArrayList<>();

        // //特殊情况指明一下,这道题不用指明也行，但建议加上，养成良好习惯
        if(n == 0){
            return ans;//直接返回一个空的集合
        }

        //调用回溯方法
        trackback(ans, n, n, new StringBuffer());

        return ans;
    }

    //定义回溯方法，方法参数分别代表承装最终结果的大容器，选项集（左右括号剩余数量），路径集（承装单个结果的字符串）,给定的括号个数
    public void trackback(List<String> ans, int left, int right, StringBuffer cur){
        //回溯终止条件
        if(left == 0 && right == 0){
            //封装数据
            ans.add(cur.toString());
            return ;
        }

        //做决策
        //走左边
        if(left > 0){
            cur.append("(");
            //进入下一层决策树
            trackback(ans, left-1, right, cur);
            //取消选择
            cur.deleteCharAt(cur.length()-1);
        }
        //走右边
        if(left < right){
            //做决策
            cur.append(")");
            //进入下一层决策树
            trackback(ans, left, right-1, cur);
            //取消选择
            cur.deleteCharAt(cur.length()-1);
        }
    }
}





























// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<String>();
//         backtrack(ans, new StringBuilder(), 0, 0, n);
//         return ans;
//     }

//     public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
//         if (cur.length() == max * 2) {
//             ans.add(cur.toString());
//             return;
//         }
//         if (open < max) {
//             cur.append('(');
//             backtrack(ans, cur, open + 1, close, max);
//             cur.deleteCharAt(cur.length() - 1);
//         }
//         if (close < open) {
//             cur.append(')');
//             backtrack(ans, cur, open, close + 1, max);
//             cur.deleteCharAt(cur.length() - 1);
//         }
//     }
// }

