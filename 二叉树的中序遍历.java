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
    public List<Integer> inorderTraversal(TreeNode root) {

        //先定义一个乘装结果的集合
        // List<Integer> list = new ArrayList<Integer>();//错      把宿舍wifi换成手机热点就正确了（狗头）
        List<Integer> list = new ArrayList<>();//错                把宿舍wifi换成手机热点就正确了（狗头）
        // List<Integer> list = new ArrayList<Integer>();//对
        // List<Integer> lsit = new ArraryList<>();//错
        // List<Integer> list = new ArraryList<Integer>();//错

        inorder(root, list);

        return list;
    }

    //声明一个方法来递归地遍历所有节点,只需要两个参数，一个是一个又一个的节点，通过root.left或root.right来表示，
    //以便于能在每一层递归中获取到对应节点的值。而获取到的值肯定要装在一个集合中，方便最后结果返回，也就是上一个方法中的list
    public void inorder(TreeNode root, List<Integer> list){

        //递归终止条件
        if(root == null){
            return ;
        }

        //前序遍历

        inorder(root.left, list);

        //中序遍历
        list.add(root.val);

        inorder(root.right, list);

        //后序遍历

    }
}