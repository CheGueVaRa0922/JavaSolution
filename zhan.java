public class zhan {
    //leetcode 232.用栈实现队列
    /*

        我首先要构建一个入栈和一个出栈
        然后呢pop和peek就从出栈里取东西
        push就要放进这个入栈里头
        思考清楚dumpstack的意义是什么？
        就是把入栈里的东西全都放在出栈里头

        错误：
             忘记给push里加参数了
    */
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpstack();
        return stackOut.pop();
    }

    public int peek() {
        dumpstack();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    private void dumpstack(){
        if(!stackOut.isEmpty()){
            return;
        }
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}
}
