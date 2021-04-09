class Solution {
    //这道题很显然使用回溯，但是这道题的每个子集都是不定长的，也就是这个回溯的终止条件不好确定，这可如何是好？这个不但不用担心，反而应该高兴，
    //因为正是长度随意，所以每一步的路径都是正确结果，所以根本不用其它恶心的回溯终止条件，只用在每一步回溯决策时都将当前路径添加到最终的结果集
    //就可以了
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        //调用回溯方法
        trackback(ans, list, nums, 0);

        return ans;
    }

    //回溯方法(大容器，路径集，选项集，回溯后的新的数组遍历的起始)
    public void trackback(List<List<Integer>> ans, List<Integer> list, int[] nums, int start){
        //封装结果集
        ans.add(new ArrayList<Integer>(list));

        for(int i = start; i < nums.length; i++){
             //做决策
            list.add(nums[i]);
             //进入下一层决策树
            // trackback(ans, list, nums, start+1);//就从这里错起！因为这样每次都从数组的第二个数开始加起
            trackback(ans, list, nums, i+1);
            //取消决策
            list.remove(list.size() - 1);
        }
    }
}



























// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> subsets(int[] nums) {
//         res = new ArrayList<>();
//         backtrack(0, new ArrayList<Integer>(), nums, nums.length);
//         return res;
//     }

//     private void backtrack(int index, ArrayList<Integer> tmp, int[] nums, int n){
//         res.add(new ArrayList<Integer>(tmp));
//         for(int i = index; i < n; i++){
//             tmp.add(nums[i]);
//             backtrack(i + 1, tmp, nums, n);
//             tmp.remove(tmp.size() - 1);
//         }
//     }
// }
