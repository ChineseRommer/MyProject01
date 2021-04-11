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
    //这道题怎堪一个妙字了得！
    //二叉搜索树的中序遍历是一个严格的递增数列，若是将其中序遍历反置，就会得到一个递减的数列。我们可以知道，所谓的累加树就是每个节点的新值
    //就是其本身的值加上大于它的值，那么就可以利用反序的后序遍历将该节点的新值计算出来，然后再更新值，就可以实现要求。
    


    //定义一个新值变量
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        //递归终止条件
        if(root == null){
            return null;
        }

        // //定义一个新值变量
        // int sum = 0;//这个要写在方法外面，否则每递归一次就会把sum重新从0开始加起来

        convertBST(root.right);
        //反序的中序遍历的操作
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        //返回被更新值后的根节点
        return root;
    }
}































// class Solution {
//     int sum = 0;

//     public TreeNode convertBST(TreeNode root) {
//         if (root != null) {
//             convertBST(root.right);
//             sum += root.val;
//             root.val = sum;
//             convertBST(root.left);
//         }
//         return root;
//     }
// }

