class Solution {
    //这道题官方题解写的是个狗屁，一点也不好理解，还没我自己找的别的大佬的好理解
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //定义一个乘装结果的容器
        List<Integer> list = new ArrayList<>();
        //对索引做标记
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);//避免下面做标记，把原有的正数改成负数，造成负索引的错误
            //获取这个数组元素理想情况下的索引（就是它本身减1）
            int index = num - 1;
            //将索引对应的真实值改为负数
            if(nums[index] > 0){//这样是为了避免有重复数，改了第一次成为了负数，又改第二次，又变成了正数
                nums[index] *= -1;
            }
        }

        //数组凡是有数字对应的理想索引位置都被改成了负数，剩下是整数的都是没出现过的
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);//没出现过的数字是正数对应的索引+1
            }
        }

        return list;
    }
}





























// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         //用来存放结果
//         List<Integer> res = new ArrayList<>(); 
//         //1. 遍历下数组的元素，对对应的索引位置的元素作标记
//         int len = nums.length;
//         for(int i = 0; i < len; i++){
//             int num = Math.abs(nums[i]);  //由于数组的元素有可能被*-1，所以取绝对值
//             int index = num - 1;
//             if(nums[index] > 0){
//                 nums[index] *= -1;
//             }
//         }      
//         // 寻找没有标记的索引位置
//         for(int i = 0; i < len; i++){
//             if(nums[i] > 0){
//                 int num = i + 1;  //将索引转化为对应的元素
//                 res.add(num);
//             }     
//         }
//         return res;
//     }
// }


