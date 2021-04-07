// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     int ans;
//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         else{
//         int ans1 = maxDepth(root.left);
//         int ans2 = maxDepth(root.right);
//         ans = Math.max(ans1, ans2)+1;
//         return ans;
//         }
//     }
// }





class Solution {
    //声明一个全局变量来记录最大深度的值
    int ans;

    //这道题其实就是一个二叉树的后序遍历，每一个节点在访问完其左右节点之后，最后才访问该节点，而访问该节点时，系统的层数便要加一。
    //其实对于一般人来说，记录二叉树的最大深度，都是看哪一个分支最长，然后数一数有几层，但是电脑是无法判断哪一个分支最长的，
    //也不可能拿尺子去量，所以我们要寻找一种电脑能够接受的方法，那就是递归了。这里有两种方法都是可以的，一种是前序遍历，也就是
    //从二叉树的根节点来一层层记录，最后递归终止条件应该是所有的节点都为空了，但是这种不太符合递归的规范，因为递归一般就是从最顶层往下找，
    //然后遇到终止条件后就从最底层向上层返回这层的结果，所以变量ans应该是先被最底层的递归方法操作之后，再返回给上一层，然后上一层再接着
    //操作变量ans。所以为了更适应递归的逻辑规范，我们选取另一种方法：后序遍历。就是先一口气递归调用到最底层，然后触发递归终止条件，
    //返回一个0，代表第零层，要开始计数了。然后上一层的递归方法接收到这个值后再进行操作，然后再向上层返回，最后到达最顶层，得到我们想要的结果。
    //需要注意的是，我们的递归终止条件就是当前节点的左右孩子都为null，但凡还有一个不为null，我们也要继续递归下去。而且在每一层的递归方法中，
    //我们操作ans都要比较一下，到底是我这个节点的左孩子那一支路的层数多还是右孩子那一支路的层数多，选取层数最多的那一支路的返回值进行
    //本层递归方法的对ans的操作。这样也就解决了那些过早没有左右孩子的节点的问题，因为他们与其它最长支路的节点肯定会有公共祖先，等到了公共
    //祖先那里，祖先一看，你这不行，你兄弟都累加了好几层了，你咋才开始累加，算了，我还是拿你兄弟的ans继续操作吧！就这样，我们肯定能够找到
    //最长的那一支路，得到的结果也就是最大深度了。

    public int maxDepth(TreeNode root) {
        //递归终止条件
        if(root == null){
            return 0;
        }

        int ans1 = maxDepth(root.left);
        int ans2 = maxDepth(root.right);
        //公共祖先对左右孩子进行比较，选取层数更多的那个ans
        ans = Math.max(ans1, ans2) + 1;

    return ans;    
    }
}



