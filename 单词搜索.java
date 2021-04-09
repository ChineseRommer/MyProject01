class Solution {
    //这道题两个字：巧妙！
    //这道题还是使用回溯算法。我们应该用普通人的思维想象一下这个步骤：首先就是要能够在茫茫人海中找到要搜寻的单词的的第一个字母，
    //这是一切的开始，否则之后所有的寻找都是白搭。然后找到首字母之后呢？这个时候我们就需要寻找第二个字母了，怎么寻找呢？由于这些字母必须是
    //连续的，所以我们可以在第一个字母的上下左右查找，如果找到了就返回true，如果没找到就返回false。接下来第三个第四个字母是一样的，在上一个
    //字母的基础上寻找，但是要注意的是，已经被寻找的字母不能被二次寻找添加到结果集，所以我们应该把找到后的字母排除掉，但是怎么排除呢？
    //这就是这道题非常精妙的一点了，我们的回溯算法不是要先做决策（进入下一层决策树之前做的操作），进入下一层决策树，取消决策（进入下一层
    //决策树之后做的操作）。所以我们可以在进入下一层决策前将之前的被找到并添加到结果集的字母做个标记，使之能够避开后续的查找，或者后续的查找
    //虽然能找到它，但是不会把它作为结果集（路径的新节点）,然后等到下一层决策树完成寻找后，再将标记去掉，这也就是取消决策，这样一来问题就
    //可以解决了。但是如何标记呢？不可能拿笔画吧，电脑可干不了，所以我们可以将这个节点的值先变成'0'，然后下层决策时就可以排除该点了，
    //最后再将值恢复就可以了。
    public boolean exist(char[][] board, String word) {
        //双层for循环遍历找到首字母
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){//相等说明找到了首字母，当然首字母不止一个，不过不用担心，有for循环在漏不了！
                    //找到了首字母就可以调用回溯方法了
                    if(trackback(board, word, i, j, 0)){
                        return true;//如果回溯方法最终返回true，则返回true
                    }
                }
            }
        }

        return false;//循环遍历完了都每成功返回true，说明没有符合题意的字符串
    }

    //回溯方法(二维字母数组（选项集）， 路径集， 所在行， 所在列， 路径长度（结果集个数）)
    public boolean trackback(char[][] board, String word, int i, int j, int k){
        //回溯终止条件
        // if(board[i][j] == word.charAt(k)){//回溯中途遇到合适的就会触发这个，提前结束本层的判断
        //     return true;
        // }//不能这样，这样会导致只找到一两层符合题意的字母，就立马返回true，不能找到全部的字母就草率地判断为正确
        if(k == word.length()){
            return true;
        }//这个必须放在最前面，否则回溯后的i,j会增大或减小到越界
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;//不能与下面的合在一起写，否则会地址越界，因为没有这个就不能排除地址越界的情况，所以直接在数组里报错
        }
        if(board[i][j] != word.charAt(k)){
            //回溯会触发这个结束当前层的判断,一旦发现不相等就立马悬崖勒马，返回false，否则它会一直往下遍历，
            //导致出现找到格子不连续的字符串的现象
            return false;
        }
        

        //做决策
        char t = board[i][j];
        board[i][j] = '0';
        //进入下一层决策树(有上下左右四种选择)
        boolean ans = trackback(board, word, i-1, j, k+1) || 
                        trackback(board, word, i+1, j, k+1) || 
                        trackback(board, word, i, j-1, k+1) || 
                        trackback(board, word, i, j+1, k+1);
         //取消决策
         board[i][j] = t;

         return ans;
    }
}



























// class Solution {
//     public boolean exist(char[][] board, String word) {
//         for (int i = 0; i < board.length; ++i) {
//             for (int j = 0; j < board[i].length; ++j) {
//                 if (board[i][j] == word.charAt(0)) {
//                     if (dfs(board, word, i, j, 0)) return true;
//                 }
//             }
//         }
//         return false;
//     }
//     public boolean dfs(char[][] board, String word, int i, int j, int k) {
//         if (k == word.length()) {
//             return true;
//         }
//         if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
//             return false;
//         }
        
//         if (word.charAt(k) != board[i][j]) {
//             return false;
//         }
//         char t = board[i][j];
//         board[i][j] = '0';
//         boolean res = dfs(board, word, i + 1, j, k + 1) || 
//         dfs(board, word, i - 1, j, k + 1) || 
//         dfs(board, word, i, j + 1, k + 1) || 
//         dfs(board, word, i, j - 1, k + 1);
//         board[i][j] = t;
//         return res;
//     }
// }

