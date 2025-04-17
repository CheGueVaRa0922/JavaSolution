public class Swap {
    //leetcode 24.两两交换链表元素
    /*思路：
            还是那句话
            这道题呢
            我们要从一对节点的前一个节点的指针开始操作
            因为如果要更新节点的话，就会断链子
            然后我们需要保存这些链子
            一次更新完之后记得迭代就可以

     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy_head = new ListNode();
        dummy_head.next = head;
        ListNode cur = dummy_head;
        ListNode temp = null , temp1 = null;
        while(cur.next != null && cur.next.next != null){
            temp = cur.next.next.next;
            temp1 = cur.next;
            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp;
            cur = cur.next.next;
        }
        return dummy_head.next;
    }
}
