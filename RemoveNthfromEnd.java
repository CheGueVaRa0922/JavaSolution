public class RemoveNthfromEnd {
    //leetcode 19.删除链表的倒数第n个节点

    /*思路：
            思考清楚在哪个节点上进行操作
            因为要删倒数第n个节点

            所以我们就要在倒数第n+1个节点上进行操作

            这题利用双指针的操作，让fast先走n+1步
            然后slow和fast同步
            这样依靠数学关系
            slow就能走到倒数第n+1个位置上
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //我们要在倒数第n+1个节点的基础上进行操作
        ListNode dummy_head = new ListNode();
        dummy_head.next = head;
        ListNode fast = dummy_head , slow = dummy_head;
        n++;
        while(n > 0){
            n--;
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast =fast.next;
        }
        slow.next = slow.next.next;
        return dummy_head.next;
    }
}
