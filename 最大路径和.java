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
    //这道题还是使用递归，并且本质还是二叉树的后序遍历。因为我们想要求最大路径和，最容易想到的就是从下往上，一层层的实验，然后将路径的权值加起来
    //比较谁更大，但是电脑如何让一层层的遍历所有路径呢？那就是递归，至于为什么是后序遍历，这个也很好理解，因为我们的最大路径和可能没有根节点，
    //而前序遍历一定是先包括根节点的，中序遍历也是这个毛病，所以自能选择后续遍历，在还没有遍历到根节点前的那一条路径时，计算一下路径和，然后再和
    //其它的路径和比较，如此就可以完成了。注意这里的递归函数的返回值一定要是这个节点的最大贡献值，而不是以这个节点为根节点的路径和，所谓最大
    //贡献值就是一个完整路径中，这个节点只是这个完整路径的一个节点，所以为了使路径和最大，这个节点自己的权值不仅要加上去，而且它的左右孩子的最大
    //贡献值中要选择一个最大的也加上去，这样才能得到最终路径的最大路径和，当然，这些的前提是该节点的权值一定是非负数，同样它的左右孩子也至少
    //要有一个是非负数，所以这里就引入了后续遍历一层完成后的操作，就是把该节点的最大贡献值与0作比较，取大的返回给上一层，这样才能保证每一层的
    //节点的最大贡献值都是非负的。路径和就是以该节点为根节点，该节点的权值加上其左右孩子的最大贡献值之和，这样就是形成了一个小路径，然后其路径和
    //在每一层递归都会形成一个，然后各个小路径和比较，最终取出最大的路径和。有人可能会问，那么小路径和为负数怎么办，那么它会在比较过程中被淘汰，
    //而求最大贡献值时有负数呢？前面说过了，我也会淘汰这个节点，就是和0比较，取最大的，取0就相当于什么也没干，把当作父节点没有这个节点嘛。


        //定义一个节点路径和的比较对象
        int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //调用递归方法
        maxGain(root);

        return sum;
    }

    //递归方法
    public int maxGain(TreeNode root){
        //递归终止条件
        if(root == null){
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);//贡献值必须大于0才有效
        int rightGain = Math.max(maxGain(root.right), 0);
        //后序遍历，求小路径和
        sum = Math.max(root.val + leftGain + rightGain, sum);

        //递归返回值，一定是返回该节点的最大贡献值，以便于上一层选择
        return root.val + Math.max(leftGain, rightGain);
    }
}





















// class Solution {
//     int maxSum = Integer.MIN_VALUE;

//     public int maxPathSum(TreeNode root) {
//         maxGain(root);
//         return maxSum;
//     }

//     public int maxGain(TreeNode node) {
//         if (node == null) {
//             return 0;
//         }
        
//         // 递归计算左右子节点的最大贡献值
//         // 只有在最大贡献值大于 0 时，才会选取对应子节点
//         int leftGain = Math.max(maxGain(node.left), 0);
//         int rightGain = Math.max(maxGain(node.right), 0);

//         // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
//         int priceNewpath = node.val + leftGain + rightGain;

//         // 更新答案
//         maxSum = Math.max(maxSum, priceNewpath);

//         // 返回节点的最大贡献值
//         return node.val + Math.max(leftGain, rightGain);
//     }
// }
