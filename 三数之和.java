class Solution {
    //这道题两个字：巧妙！我们可以使用排序加双指针加去重操作解答。一般而言，加入让我们人类来寻找和为0的三个数的所有组合，我们一般会看着像就选了，
    //但是在电脑中，电脑可不能这么干，而且很容易找漏掉，这是我们不难想到使用暴力枚举，通过三重for循环来对该数组进行排列组合，最后判断一下挑出和
    //为0的三个数。但是这样时间复杂度太大，估计是n的3次方级别的，有没有更好的方法呢？当然有了，我们可以想想这样一个场景，当-1 + 0 + 1 == 0 之后
    //我们还需要尝试-1 + 0 + 2  吗？当然不需要了，因为2>1，根本就没有必要再循环遍历下去了，这样一来就节约了不少时间，但是这样做的一个要求就是
    //我们的数组必须是有序的，否则不能确定下一个数是否大于前一个数，所以这道题我们首先要对给定的数组进行排序。排序后，虽然优化了不少，但是其还是
    //三层for循环，所以时间复杂度还是立方级别的，那么我们还能再优化吗？当然可以，那就是双指针了。我们可以想象，当我们的第一层循环确定之后，开始
    //遍历第二层循环，这个时候第二层是从做往右遍历，如果这时候我们把第三层循环改为一个从右往左遍历的指针，这样左右指针就是一个此消彼长的关系，
    //那么我们不久可以大大减小时间复杂度了吗?只不过要注意，指针每移动一下，就要判断一下是否指针重合了，要时刻保证第二层的指针要在第三层的指针
    //左边或恰好重合。到这里，肯定有人要问跳出循环的条件了，没错，有递归，就要关注递归的终止条件，有循环也要关注循环的终止条件。这里第一层的
    //循环终止条件肯定是锁遍历的数大于0了，因为它都大于0了，它后面两个数大于或等于它，它们相加之和肯定不会等于0了。还有需要注意的是，在循环中，
    //如果有重复的数直接跳过，体现在代码里就是if判断一下，如果这次循环的数与上次循环的数相等，就直接continue，注意，为了防止地址越界，要加上
    //索引大于0这个条件。里层的循环也要查重，一样的if判断语句，而且要注意，里层循环还要负责检查三个数相加是否等于0，注意，右指针每移动一次，
    //就要判断一次，如果相加之和大于0，就直接左移，等于0就直接break，因为数组已经排序了，往后再移动指针只会得到相同的三元组护着根本就得不到满足
    //题意的三元组了。得到满足题意的三元组之后，就是封装三元组了，由于三元组输一个集合，而最终答案有很多个集合，所以我们就可以使用一个大大的集合：
    //List<List<Integer>>，第三层的while()循环每break一次，代表找到了一个满足题意的三元组，就将三个数封装进list中，第二层循环每终止一次，就
    //将一个三元组封装进List<List<Integer>>中，然后进行第一层循环的下一个数，最后当第一层循环的数遍历完了或者大于0时，说明找到了所有结果，返回
    //最终结果即可。
    public List<List<Integer>> threeSum(int[] nums) {
        //首先对数组进行排序
        Arrays.sort(nums);

        //然后提取出数组长度
        int n = nums.length;

        //乘装多个三元组的大容器
        List<List<Integer>> ans = new ArrayList<>();

        //第一层（第一个数）的遍历
        for(int first = 0; first < n; first++){
            //判断是否有重复的数
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
            //判断第一个数是否都大于0
            if(nums[first] > 0){
                break;//直接终止循环，没必要再循环下去了，直接跳到下方返回最终结果
            }

            //定义一个右指针，每次重新开启一个第一层循环，就重新生成一个指向最右边的右指针，这个指针无需在第二层循环每次都生成，因为第二第三层
            //指针是此消彼长的关系，第二层每向右移动一下，第三层就接着上次向左移动一下就行。
            int third = n-1;

            // //定义一个乘装单个三元组的集合
            // List<Integer> list = new ArrayList<>();
            
            //进行第二层循环
            for(int second = first + 1; second < n; second++){
                //判断是否有重复的数
                if(second>first+1 && nums[second]==nums[second-1]){//必须大于first+1，否则会出现数组中重复数不能用的情况
                    continue;//直接进行下一次循环
                }

                //右指针的移动
                while(third>second && nums[first]+nums[second]+nums[third] > 0){//不能相等，相等意味着第二个数与第三个数用同一个数了
                    third--;
                }

                //如果指针重合就说明再也没有符合题意的三元组了，直接结束这一次的第一层循环,也就是当前的所有第二层循环。
                if(third==second){
                    break;//这个if必须放在下一个if前面，否则就会出现一个数用两边的情况
                }

                //如果等于0就break;
                if(nums[first]+nums[second]+nums[third] == 0){
                     //定义一个乘装单个三元组的集合
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                    // break;//直接结束当前所有的第二层循环
                    //不要break，否则有些第二层与第三层此消彼长的符合题意的将会被漏掉
                }

            }

            // //如果集合不为null就说明在的二层循环中找到了符合题意的三元组并封装了起来，这时候我们在第一层循环中封装所有符合题意的三元组
            // if(list != null   /*!list.equals(null)*/){
            //     ans.add(list);
            // }//注意：ans是二维数组，这样判断怎么都不为null

        }

        return ans;
    }
}




























// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         // 枚举 a
//         for (int first = 0; first < n; ++first) {
//             // 需要和上一次枚举的数不相同
//             if (first > 0 && nums[first] == nums[first - 1]) {
//                 continue;
//             }
//             // c 对应的指针初始指向数组的最右端
//             int third = n - 1;
//             int target = -nums[first];
//             // 枚举 b
//             for (int second = first + 1; second < n; ++second) {
//                 // 需要和上一次枚举的数不相同
//                 if (second > first + 1 && nums[second] == nums[second - 1]) {
//                     continue;
//                 }
//                 // 需要保证 b 的指针在 c 的指针的左侧
//                 while (second < third && nums[second] + nums[third] > target) {
//                     --third;
//                 }
//                 // 如果指针重合，随着 b 后续的增加
//                 // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
//                 if (second == third) {
//                     break;
//                 }
//                 if (nums[second] + nums[third] == target) {
//                     List<Integer> list = new ArrayList<Integer>();
//                     list.add(nums[first]);
//                     list.add(nums[second]);
//                     list.add(nums[third]);
//                     ans.add(list);
//                 }
//             }
//         }
//         return ans;
//     }
// }
