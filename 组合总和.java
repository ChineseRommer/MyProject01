class Solution {
    //这道题还是一道回溯算法题，还是想那三个部分：做决策，进入下一层决策树，取消决策。首先是做决策，这也像是多叉树的深度遍历
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //乘装最终结果的容器
        List<List<Integer>> ans = new ArrayList<>();

        //乘装单个路径的容器
        List<Integer> list = new ArrayList<>();

        //调用回溯方法
        trackback(ans, list, candidates, target, 0);

        return ans;
    }

    //回溯方法,方法参数分别为：最终结果的大容器，路径集，选项集，目标值,开始变量
    public void trackback(List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int start){
        //回溯终止条件
        if(target == 0){
            // ans.add(list);//封装数据
            ans.add(new ArrayList<Integer>(list));//为啥要这样写？
            return ;
        }
        if(target < 0){
            return ;
        }

        // //做决策
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            trackback(ans, list, candidates, target - candidates[i], i);
            // list.remove(candidates[list.size() - 1]);
            list.remove(list.size() - 1);
        }
        // // //直接跳过，不再使用这个数
        // // trackback(ans, list, candidates, target-candidates[index], index++);
        // //再次使用这个数
        // if(target > 0){
        //     list.add(candidates[index]);
        //     //进入下一层决策树
        //     trackback(ans, list, candidates, target-candidates[index], 0);
        //     //取消决策
        //     list.remove(candidates[list.size()-1]);
        // }
    }
}






























// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         List<Integer> combine = new ArrayList<Integer>();
//         dfs(candidates, target, ans, combine, 0);
//         return ans;
//     }

//     public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
//         if (idx == candidates.length) {
//             return;
//         }
//         if (target == 0) {
//             ans.add(new ArrayList<Integer>(combine));
//             return;
//         }
//         // 直接跳过
//         dfs(candidates, target, ans, combine, idx + 1);
//         // 选择当前数
//         if (target - candidates[idx] >= 0) {
//             combine.add(candidates[idx]);
//             dfs(candidates, target - candidates[idx], ans, combine, idx);
//             combine.remove(combine.size() - 1);
//         }
//     }
// }