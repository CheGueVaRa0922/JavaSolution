public class MyLinkedList {
    //leetcode 707.设计链表
    /*思路：
            温故而知新
            链表吧
            核心思路：
                    你要记住这个链子会不会断？
                    你要在哪个指针的基础上进行操作？
            错误：
                    cur != null （删节点那个delete）
                    如果定义了一个长期的dummy_head 这个 != 可以不用写
                    临时定义的要写

     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    private int size;
    private ListNode head;



    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        while(index + 1 > 0){
            index--;
            cur = cur.next;

        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newpoint = new ListNode(val);
        ListNode cur = head;
        ListNode temp = cur.next;
        cur.next = newpoint;
        newpoint.next = temp;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newpoint = new ListNode(val);
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newpoint;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
            return;
        }
        ListNode cur = head;
        ListNode newpoint = new ListNode(val);
        ListNode temp = null;
        while(index > 0){
            index--;
            cur = cur.next;
        }
        temp = cur.next;
        cur.next = newpoint;
        newpoint.next = temp;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index > size - 1){
            return;
        }
        ListNode cur = head;

        while(index > 0){
            index--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;

    }
}
