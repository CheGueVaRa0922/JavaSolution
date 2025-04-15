
class RemoveElement {
    public class RemoveElements {
        //leetcode 203.移除列表元素
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy_head = new ListNode();
            dummy_head.next = head;
            ListNode cur = dummy_head;
            while(cur != null && cur.next != null){
                if(cur.next.val == val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }

            }
            return dummy_head.next;
        }
}


