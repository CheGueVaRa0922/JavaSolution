public class MyStack {
    /*leetcode 225.用队列实现栈
       我们的思路是什么？
       创建一个队列
       把元素放进队列
       然后再取出size - 1个元素重新放回队列
       这样就实现了后入先取
   */
    Queue<Integer> que;
    public MyStack() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.add(x);
    }

    public int pop() {
        rePosition();
        return que.poll();
    }

    public int top() {
        rePosition();
        int result = que.poll();
        que.add(result);
        return result;
    }

    public boolean empty() {
        return que.isEmpty();
    }
    private void rePosition(){
        int size = que.size();
        size--;
        while(size > 0){
            que.add(que.poll());
            size--;
        }
    }
}
