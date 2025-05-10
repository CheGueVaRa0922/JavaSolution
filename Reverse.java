public class Reverse {
    //leetcode 206.反转链表
    /*思路：
            永远记住
            链表会不会断
            从哪里个指针开始操作;

     */
    public ListNode reverseList(ListNode head) {
        return reverse(null,head);
    }
    public ListNode reverse(ListNode pre,ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;
        pre = cur;
        return reverse(pre,temp);
    }
}
