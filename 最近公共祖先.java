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
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root==null || root==p || root==q){
//             return root;
//         }
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
//         if(left==null && right==null){
//             return null;
//         }
//         if(left==null){
//             return right;
//         }
//         if(right==null){
//             return left;
//         }
//         return root;
//     }
// }



//

//class Solution {
  //  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //    if(root == null || root == p || root == q) return root;
     //   TreeNode left = lowestCommonAncestor(root.left, p, q);
       // TreeNode right = lowestCommonAncestor(root.right, p, q);
        //if(left == null && right == null) return null; // 1.
        //if(left == null) return right; // 3.
        //if(right == null) return left; // 4.
       // return root; // 2. if(left != null and right != null)
   // }
//}






    class Solution {
    //这道题还是有一定难度的，因为其不好想。但是这道题的框架结构还是二叉树的后序遍历。为啥说这道题不好想呢，因为它把情况的分类总结得太精妙了。
    //它还是用递归的思想，先递归到最底层，然后判断这里是否有指定的节点，如果有就返回这个节点给上一层递归方法。上一层递归方法接收到这个返回值后
    //就需要继续判断，因为它要看一看自己的另外一个孩子是否也有指定的节点，如果判断到另外一个孩子也有指定的节点，那么毋庸置疑，我这个节点就是
    //题目中要找的公共祖先。在这里可能有人要问了，那假如我这个公共祖先上面还有好几层递归方法，每个后面都有判断语句，那我最后回溯完后拿到的
    //返回值还是我们之前找的那个公共祖先吗？这里就体现了我说的这个将情况分类得很精妙的了，它的情况分类有四种，第一种，左右孩子返回的递归方法值
    //都没有指定的节点，那我们就向上层递归方法返回一个null供他们操作。第二种，左孩子返回的值有指定节点，右孩子返回的值没有指定节点，那就说明
    //右孩子没有希望成为公共祖先，所以直接返回左孩子上层递归方法，供他们操作，注意这里没有回溯完之前，我们不能判断这个左孩子是不是针对公共祖先，
    //就是可能他只有一个指定的节点，另一个指定的节点还在十万八千里之外呢，所以一直假设是公共祖先，等到回溯完之后发现其它支路都返回null，发也就是
    //到了最外层的递归方法的判断了，此时返回的值还是那个公共祖先，所以最后能够返回正确的结果。但是如果中途发现其它支路也有只当的节点，那就说明
    //这两条支路都不是公共祖先，只是恰巧每个支路都有一个指定的节点罢了，那我们就把这两条支路的父节点设置为公共祖先，然后再一层层回溯，最终将这个
    //父节点当作公共祖先返回出去。这也就是第四种情况，就是两个孩子都不为空，那我就返回这个父节点。然后就剩下第三种情况，第三种情况与第二种相同，
    //不再赘述。注意，这里的递归终止条件就是当前的这个节点等于指定的节点中的任何一个，然后别忘了，当我们递归到最底层时，还是没有找到指定的节点，
    //这时候我们就需要再加上一个终止条件，那就是当前节点为null时，我们也要返回root来终止该支路的递归。至于为何一定要返回root，那是为了统一方便，
    //当我们找到指定节点时，返回该节点，那么就可以将该节点假设为公共祖先了，当我们没有找到指定节点时，递归方法还会再往下一层判断一下，因为下一层
    //肯定是null，所以返回root就是返回null，而到了上一层，我们返回的这个null又可以作为四种情况的判断条件，从而准确地执行整个逻辑。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //后序遍历位置需要加入的判断语句，从而实现情况的分类
        if(left==null && right==null){
            return null;//左右孩子都不是指定节点或者都不包含指定节点，这个节点肯定也没希望
        }
        if(left == null){
            return right;//只有左孩子没有指定节点，右孩子有，那么这个节点还是很有希望的，
                            //暂且将其视为公共祖先返回给上一层的递归方法再进行判断操作
        }
        if(right == null){
            return left;//同上
        }

     return root;//除了以上三种情况，说明肯定是左右孩子各有一个指定节点，所以他是公共祖先毋庸置疑了，但是还是要将他返回给上层递归方法继续回溯
                //不过不用担心，其它支路都是null了，在接下来的回溯中是影响不到他的
    }
}



