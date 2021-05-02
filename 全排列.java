//这是我少有的不看题解直接自己写出来的中等难度的算法。
class Solution {
    //这道题显然使用动态规划,可以看作是一个多叉树的遍历,做决策，进入下一层决策树，取消决策。回溯终止条件就是数组的长度变成0了
    public List<List<Integer>> permute(int[] nums) {
        //乘装最终结果的大集合
        List<List<Integer>> ans = new ArrayList<>();
        //乘装单个结果的集合
        List<Integer> list = new ArrayList<>();
        //调用回溯方法
        trackback(ans, nums, list);//乘装结果的集合，选择集，结果集，结果的长度

        //返回结果
        return ans;
    }

    public void trackback(List<List<Integer>> ans, int[] nums, List<Integer> list){
        //回溯终止条件
        if(nums.length == 0){
            //封装结果
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i = 0; i < nums.length; i++){
            //做决策
            list.add(nums[i]);
            //进入下一层决策树
                int[] temp = new int[nums.length];
                temp = nums;
                //删除数组中的这个元素
                int[] arr = new int[nums.length - 1];
                for(int j = 0; j < i; j++){
                    arr[j] = nums[j];
                }
                for(int j = i; j < nums.length - 1; j++){
                    arr[j] = nums[j + 1];
                }
            trackback(ans, arr, list);
            //取消决策
                //恢复被删除的元素
                nums = temp;
                for(int j = 0; j < list.size(); j++){//删除结果集中不再需要的元素
                    if(list.get(j).equals(nums[i])){
                        list.remove(j);
                    }
                }
        }
        
    }
}



































// import java.util.ArrayList;
// import java.util.List;


// public class Solution {

//     public List<List<Integer>> permute(int[] nums) {
//         int len = nums.length;
//         // 使用一个动态数组保存所有可能的全排列
//         List<List<Integer>> res = new ArrayList<>();
//         if (len == 0) {
//             return res;
//         }

//         boolean[] used = new boolean[len];
//         List<Integer> path = new ArrayList<>();

//         dfs(nums, len, 0, path, used, res);
//         return res;
//     }

//     private void dfs(int[] nums, int len, int depth,
//                      List<Integer> path, boolean[] used,
//                      List<List<Integer>> res) {
//         if (depth == len) {
//     res.add(new ArrayList<>(path));
//     return;
// }
//         // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
//         for (int i = 0; i < len; i++) {
//             if (!used[i]) {
//                 path.add(nums[i]);
//                 used[i] = true;

//                 dfs(nums, len, depth + 1, path, used, res);
//                 // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
//                 used[i] = false;
//                 path.remove(path.size() - 1);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int[] nums = {1, 2, 3};
//         Solution solution = new Solution();
//         List<List<Integer>> lists = solution.permute(nums);
//         System.out.println(lists);
//     }
// }