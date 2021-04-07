// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if(root == null){
//             return null;
//         }
//         TreeNode left = invertTree(root.left);
//         TreeNode right = invertTree(root.right);
//         //这个第一层是把左叶子节点和右叶子节点交换，第二三四层都是将左右子树交换
//         root.left = right;
//         root.right = left;
//         return root;
//     }
// }



class Solution {
    //这道题不同于判断是否为对称二叉树，因为对称二叉树一定是完满二叉树，所以我们不能通过双指针来交换左右节点的值，所以我们只能交换左右节点
    //和左右子树。这道题说白了还是一个二叉树的后序遍历，当找到该节点的左右孩子后，我们设置一个TreeNode节点来充当容器，交换左右孩子节点。
    //然后操作完之后，我们的递归方法就返回到上一层的节点，上一层再执行相同的操作，对TreeNode的左右子树进行交换，最终实现对政客数的翻转。
    //这里要注意，我们的递归终止条件就是当前节点的左右孩子都为null。递归方法的参数应该是当前节点的左右孩子，最终返回值也就是root。
    public TreeNode invertTree(TreeNode root) {
        //递归终止条件
        if(root == null){
            return null;
        }

        //设置一个TreeNode变量承接从下层递归方法返回的节点
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //交换左右节点或左右子树
        root.left = right;
        root.right = left;

        return root;
    }
}






