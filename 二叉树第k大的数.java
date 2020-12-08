/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    int rank = 0;//注意，这里的两个变量都是全局变量，如果定义到函数内部，则递归时，每一次，rank都会从0开始加起来，故而我一直错
    public int kthSmallest(TreeNode root, int k) {
        fun(root, k);
        return ans;
    }

    void fun(TreeNode root, int k){
        if(root == null){
            return;//循环终止条件
        }
        // int rank = 0;
        fun(root.left, k);
        rank++;///这其实本质是一个中序遍历，中序遍历的二叉搜索树就是升序排列的
        if(rank == k){
            ans = root.val;
            //return;//这里的return要不要都可以
        }
        fun(root.right, k);
        //return;//这里的return要不要都可以
    }
}