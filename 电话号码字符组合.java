class Solution {
    //这是一道典型的回溯算法题，通过输入电话号码的组合来实现电话号码锁对应的字母的组合。说到这里，我们不难想到，想要将数字映射成为字母，
    //我们肯定是需要借用map。而最终的结果集会有多组组合，所以我们需要使用List<String>来乘装最终的结果。说到回溯算法，我们首先要想到
    //回溯算法的基本框架，就是三大部分：做选择，进入下一层决策树，取消选择。这个做选择就是将选择集中的一个选项添加到路径集中。进入下一层
    //决策树就是trackback()方法，其参数一定包括新的路径集和选择集，注意，由于选择集一般不好更新，或者实时更新不方便，所以我们干脆就不更新了，
    //直接通过一个for循环来遍历选择集，然后排除不符合题意的选项（continue;）。而最后一个取消选择就是最巧妙的了，因为我们回溯算法，都是先递归，
    //后取消选择，我们不妨想象一下，加入我们一直递归到最后一层，遇到递归终止条件（一般来说就是index的长度（路径长度）与选择集的长度相等，
    //那就说明我们把决策树的这一支路走完了），我们就会开始从下往上返回了，但是返回之前，我们需要取消选择，为什么呢？因为我们走完这一支路后，
    //已经将路径封装到结果集中了，我们需要的是继续寻找其它结果，走其它的路径，这其实就是遍历一颗多叉树，当我们想要走另一条路时，就要先把
    //之前那一条路的最后一个节点删除掉，否则接下来选择的路将会是在原路径下直接添加，导致结果错误。等到这一层决策树遍历完成之后，就会继续
    //返回到更上一层决策树，但是还是一样，返回之前还是要将现在这一层之前做的选择给删除掉，然后再返回，这样就一层一层的返回，一层一层的做决策，
    //最终就能便利整颗决策树，并将所有符合题意的结果封装进结果集中。
    public List<String> letterCombinations(String digits) {
        //乘装所有结果的结果集
        List<String> combinations = new ArrayList<>();

        //非空判断
        if (digits.length() == 0) {
            return combinations;
        }

        // //乘装单个结果的路径集
        // StringBuffer combination = null;

        // //路径长度
        // int index = 0;

        //将数字与字母对应起来
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        //调用回溯方法
        trackback(combinations, new StringBuffer(), digits, 0, phoneMap);

        return combinations;
    }

    //回溯算法方法，参数分别是乘装所有结果的结果集，单个路径的字符串（路径集），选择集（所有可用的数字），索引（表示当前路径的长度）
    public void trackback(List<String> combinations, StringBuffer combination, String digits, 
                            int index, Map<Character, String> phoneMap){
        //回溯终止条件
        if(index == digits.length()){
            //说明该路径走完了，封装结果
            combinations.add(combination.toString());
        }else{
            //否则说明该路径还没走完，我们需要通过当前的数字索引找到数字，再通过数字找到对应字母，然后通过回溯对字母进行排列组合
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for(int i = 0; i < lettersCount; i++){
                //选择路径
                combination.append(letters.charAt(i));
                //进行下一层决策树
                trackback(combinations, combination, digits, index + 1, phoneMap);
                //取消选择
                combination.deleteCharAt(index);
            }
        }
    }
}




























// class Solution {
//     public List<String> letterCombinations(String digits) {
//         List<String> combinations = new ArrayList<String>();
//         if (digits.length() == 0) {
//             return combinations;
//         }
//         Map<Character, String> phoneMap = new HashMap<Character, String>() {{
//             put('2', "abc");
//             put('3', "def");
//             put('4', "ghi");
//             put('5', "jkl");
//             put('6', "mno");
//             put('7', "pqrs");
//             put('8', "tuv");
//             put('9', "wxyz");
//         }};
//         backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
//         return combinations;
//     }

//     public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
//         if (index == digits.length()) {
//             combinations.add(combination.toString());
//         } else {
//             char digit = digits.charAt(index);
//             String letters = phoneMap.get(digit);
//             int lettersCount = letters.length();
//             for (int i = 0; i < lettersCount; i++) {
//                 combination.append(letters.charAt(i));
//                 backtrack(combinations, phoneMap, digits, index + 1, combination);
//                 combination.deleteCharAt(index);
//             }
//         }
//     }
// }