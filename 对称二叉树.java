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
//     public boolean isSymmetric(TreeNode root) {
//         // TreeNode p = root.left;
//         // TreeNode q = root.right;
//         return check(root, root);
//     }
//     public boolean check(TreeNode p, TreeNode q){
//         if(p==null && q==null){
//             return true;
//         }
//         if(p==null || q==null){
//             return false;
//         }
//         return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
//     }
// }


class Solution {
    //这道题很容易想到就是使用双指针。按照正常人的思维，想要判断是否为堆成二叉树，一般都会比较堆成的两点数值是否相等，
    //那么我们如何比较对称的两点，并且让比较的对象从根节点一层层地下移呢？我们可以使用递归。想象一下，我们首先只能得到根节点root，
    //然后就是比较根节点的左右孩子的数值是否相等，若相等也不能高兴得太早，我们还要比较左右孩子的右左孩子是否相等。这里递归的思想就
    //被充分运用了，我们创造的这个递归方法一定是有两个参数，其中一个放左孩子，另一个放右孩子。至于递归终止条件，我们可以想象比较已经
    //到达了最底层的叶子节点了，再使用递归方法的左右孩子就会得到null值，所以我们必须在这里就“迷途知返”，所以递归终止条件就是判断该节点
    //是否有null，如果有null就终止向前递归，转而往回递归。但是终止返回是true还是false呢？如果左右指针指向的两个节点都为null，那就是
    //合法的，返回true，如果两个节点值一个为null，另一个不为null，那我们就判断为不对称false。这也为防止中途有节点过早没有左右孩子而
    //能够更早地判断为false而提供基础。
    public boolean isSymmetric(TreeNode root) {
       return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q){
        //递归终止条件
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){//这里虽然包含了两节点都为null的情况，但是这中情况在上一个判断语句中已经判断，故而不会进入到这个判断中
            return false;
        }

        //若成功跳过以上两个判断，说明左右指针指向的节点都不为null，递归还没有“寿终正寝”，还需要继续递归下去
        return p.val==q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}






