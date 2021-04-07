/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//         if(t1 == null){
//             return t2;
//         }
//         if(t2 == null){
//             return t1;
//         }

//         TreeNode newTree = new TreeNode(t1.val + t2.val);
//         newTree.left = mergeTrees(t1.left, t2.left);
//         newTree.right = mergeTrees(t1.right, t2.right);
//         return newTree;
//     }
// }


class Solution {
    //这道题其实就是二叉树的前序遍历。加入让我们合并两颗数，我们肯定是从根节点开始，将两棵树对应位置的节点的值相加，然后赋给新创建的树的
    //对应节点上，但是这里注意，我们要在每一层递归方法中都新建一个TreeNode节点，这样才能确保每合并一个节点就能够有一个对应的新节点来储存
    //合并后的值。不过不用担心这些每一层新建的节点能否连接起来，因为这里巧妙地运用了一个newTree.left = ... ，这样一来。我们每层新建的节点
    //通过拼接幅值之后，九江这个节点然会给上一层递归方法，上一层接收到之后就会将该节点赋给上层节点的左孩子与右孩子，这样我们最终得到的就是
    //一颗完整的树了。注意这里的递归终止条件是递归到某节点为null为止，如果两棵树的一个节点为null，则直接返回另一棵树的节点，若都为null，
    //那最终返回的也就是null，然后该层递归方法返回的节点的左孩子后者右孩子为null，符合逻辑。
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //递归终止条件
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }

        //前序遍历的递归逻辑
        TreeNode newTree = new TreeNode(t1.val + t2.val);
        newTree.left = mergeTrees(t1.left, t2.left);
        newTree.right = mergeTrees(t1.right, t2.right);

        return newTree;
    }
}




