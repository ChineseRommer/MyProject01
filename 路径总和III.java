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
    //这道题我是看了一个叫刘辉的大佬的题解立马豁然开朗，感觉他真的是精通递归，且看他的解题思想吧！
    //假设从根节点出发，一层层的向下遍历，并将每条路径的每个遍历的节点的值都加起来，如果等于目标值，那就路径数加1，如果最终遍历到最底层，
    //并且还没能达到目标值，那就说明该路径不行，返回0。注意，在找到一个成功路径后，计数加1，然后不能立马返回，避免往下再遍历时，恰巧两节点
    //一个是1，另一个是-1，那么加起来仍然符合题意，所以计数还要加一，所以不能立马返回，而是应该继续前序遍历下去。但是这只是从根节点出发，
    //假如不从根节点出发也行，那怎么办，那就把题目给的那个方法再递归一下嘛，最终结果应该是
    // return dfs(root) + pathSum(root.left) + pathSum(root.right); 如此就可以实现从所有节点出发递归遍历求和的操作了。


        //定义一个记录总数的变量
        int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        //这个方法自身的递归终止条件
        if(root == null){
            return 0;
        }

        //调用递归方法
        dfs(root, targetSum);
        // return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        //返回最终结果
        return count;
    }

    //递归方法
    public void dfs(TreeNode root, int targetSum){
        //递归终止条件
        if(root == null){//终止条件不可用小于0，因为可能下一层的节点恰好是正数，最后相加满足题意
            return ;
        }

        //前序遍历的操作
        if(root.val == targetSum){
            count++;//不能立马返回，以免遗漏
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);

        return ;
    }
}
































// /**
//      * 路径总和
//      *
//      * @param root 二叉树根节点
//      * @param sum 路径和
//      * @return 满足路径总和的路径总数
//      */
//     public static int pathSum(TreeNode root, int sum) {
//         if (root == null) {
//             // 树为空直接返回
//             return 0;
//         }

//         // 当前节点加上左右节点的路径数即为满足路径总和的路径总数
//         return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//     }

//     /**
//      * 路径总和
//      *
//      * @param root 二叉树根节点
//      * @param sum 路径和
//      * @return 以当前节点开始满足路径总和的路径总数
//      */
//     public static int dfs(TreeNode root, int sum) {
//         if (root == null) {
//             // 已经过了叶节点，没有找到符合条件的路径
//             return 0;
//         }

//         int count = 0;
//         if (root.val == sum) {
//             // 到当前节点的一条路径满足条件
//             count = 1;
//         }

//         // 递归左子树和右子树，返回可能的路径总数
//         count += dfs(root.left, sum - root.val);
//         count += dfs(root.right, sum - root.val);

//         return  count;
//     }