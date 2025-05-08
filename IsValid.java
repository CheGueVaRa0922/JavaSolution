public class IsValid {
    /*leetcode 20.有效的括号
        这题只有三种情况
        左括号多了
        括号不匹配
        右括号多了
        我们的判断方法是
        如果遇到左括号，就把对应的右括号放进去
        对应的出错情况会有
        当我匹配完了，栈里边还有剩
        匹配到右括号时不匹配
        还没等我匹配完栈就空了
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(')');
            }
            else if(s.charAt(i) == '['){
                stack.push(']');
            }
            else if(s.charAt(i) == '{'){
                stack.push('}');
            }
            else{
                if(stack.isEmpty() || stack.pop() != s.charAt(i)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
