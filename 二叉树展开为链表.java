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
    //这道题虽然不难，但是对于很长时间没有做过关于链表的前驱后继节点的操作的题的我来说，也确实花了不少时间。
    //这道题其实本质就是二叉树的前序遍历，将所有节点都添加到list集合中，然后再将这些非孤立的节点的前驱和后继重新设置，使之成为一个链表。
    public void flatten(TreeNode root) {
        //乘装节点的集合
        List<TreeNode> list = new ArrayList<>();

        //调用递归方法
        preorderTraversal(list, root);

        //获取集合元素个数（节点个数）
        int size = list.size();

        //操作每个节点的前驱与后继
        for(int i = 0; i < size - 1; i++){
            //定义链表的起始节点
            TreeNode pre = list.get(i);
            TreeNode cur = list.get(i + 1);
            pre.left = null;
            pre.right = cur;
        }
    }

    //递归方法
    public void preorderTraversal(List<TreeNode> list, TreeNode root){
        //递归终止条件
        if(root == null){
            return ;
        }

        //前序遍历
        list.add(root);
        preorderTraversal(list, root.left);
        preorderTraversal(list, root.right);
    }
}
















// class Solution {
//     public void flatten(TreeNode root) {
//         List<TreeNode> list = new ArrayList<TreeNode>();
//         preorderTraversal(root, list);
//         int size = list.size();
//         for (int i = 1; i < size; i++) {
//             TreeNode prev = list.get(i - 1), curr = list.get(i);
//             prev.left = null;
//             prev.right = curr;
//         }
//     }

//     public void preorderTraversal(TreeNode root, List<TreeNode> list) {
//         if (root != null) {
//             list.add(root);
//             preorderTraversal(root.left, list);
//             preorderTraversal(root.right, list);
//         }
//     }
// }
