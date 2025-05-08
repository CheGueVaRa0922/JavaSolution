public class MyQueue {
    //leetcode 239.滑动窗口求最大值
    Deque<Integer> deque = new LinkedList<>();
    public void pop(int val){
        if(!deque.isEmpty() && deque.peek() == val){
            deque.poll();
        }
    }
    public void add(int val){
        while(!deque.isEmpty() && deque.getLast() < val){
            deque.removeLast();
        }
        deque.add(val);
    }
    public int peek(){
        return deque.peek();
    }
}
class Solution {
    /*
        这题我们的大体思路就是
        设置一个Myqueue
        然后里面要有三个构造器
        pop构造器，到了这个位置再把对应元素弹出1
        add构造器：添加的这个数要把前面小于它的数全都消干净
        peek，就是取出口处的元素。
        先构造这个Myqueue，然后遍历k个元素，取出口作为第一个元素
        然后依次往下遍历

        错误：
                在pop构造器那里就不应该用poll来比对
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        for(int i = 0;i < k;i++){
            queue.add(nums[i]);
        }
        int num = 0;
        int []res = new int[nums.length - k + 1];
        res[num++] = queue.peek();
        for(int i = k;i < nums.length;i++){
            queue.pop(nums[i - k]);
            queue.add(nums[i]);
            res[num++] = queue.peek();
        }
        return res;
    }
}
