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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer heigher){
        if(root == null){
            return true;
        }
        if(lower != null && root.val<=lower){//如果更新后的最小值比根节点还大，那么肯定不行
            return false;
        }
        if(heigher != null && root.val>=heigher){//如果更新后的最大值比根节点还小，那么肯定不行
            return false;
        }
        if(!helper(root.left, lower, root.val)){//因为这是左子树，所以根节点值都比他大，所以最大值更新为root.val
            return false;
        }
        if(!helper(root.right, root.val, heigher)){//因为这是右子树，所以根节点都比他小，所以最小值更新为root.val
            return false;
        }
        return true;
    }
}