// class Solution {
//     public boolean isValid(String s) {
//         if(s.isEmpty()){
//             return true;
//         }

//         Stack<Character> stack = new Stack<Character>();
//         for(char c : s.toCharArray()){
//             if(c == '('){
//                 stack.push(')');
//             }
//             else if(c == '['){
//                 stack.push(']');
//             }
//             else if(c == '{'){
//                 stack.push('}');
//             }
//             else if(stack.isEmpty() || c != stack.pop()){
//                 return false;
//             }
//         }
//         if(stack.isEmpty()){
//             return true;
//         }
//         return false;
//         //return true;
//     }
// }














class Solution {
    public boolean isValid(String s) {
        //特殊情况考虑一下
        if(s.length() == 0){
            return true;
        }
        // if(s.length() % 2 == 1){
        //     return false;
        // }
       //设置一个栈，用来存储左边括号
       Stack<Character> stack = new Stack<>();
       //增强for循环遍历字符串
       for(char c : s.toCharArray()){
           if(c == '('){
               stack.push(')');
           }else if(c == '['){
               stack.push(']');
           }else if(c == '{'){
               stack.push('}');
           }else if(stack.isEmpty() || c != stack.pop()){//如果数组还没遍历完栈就空了，那么肯定有问题
                   return false;
           }
       }
    //    return true;
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}







/*
class Solution {
public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }
}
*/