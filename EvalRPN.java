public class EvalRPN {
    /*leetcode 150.逆波兰表达式求值
        ("+").equals()
        记得else
        记得运算
    */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String i : tokens){
            if(("+").equals(i) || ("-").equals(i) || ("*").equals(i) || ("/").equals(i)){
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(("+").equals(i)){
                    stack.push(num1 + num2);
                }
                else if(("-").equals(i)){
                    stack.push(num1 - num2);
                }
                else if(("*").equals(i)){
                    stack.push(num1 * num2);
                }
                else if(("/").equals(i)){
                    stack.push(num1 / num2);
                }
            }
            else{
                stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
    }
}
