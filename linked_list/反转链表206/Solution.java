package linked_list.反转链表206;

/**
 * Definition for singly-linked list.
 */
class Solution {
    /*
     * 做题思路：
     * - 从第二个节点开始遍历，把当前节点依次插到已反转链表的头部。
     * - 先断开原 head 的 next，避免反转过程中形成环。
     * - 每次保存下一个待处理节点，再让当前节点指向新的头节点，最后更新 head。
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p=head.next;
        head.next=null;
        while (p != null) {
            ListNode temp=head;
            head=p;
            p=p.next;
            head.next=temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode dummy = new ListNode(0);   // 虚拟头节点
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        ListNode head = dummy.next;   // head 即链表 [1,2,3,4,5]
        ListNode node = new Solution().reverseList(head);
        // 打印链表，应输出：1 -> 2 -> 3 -> 4 -> 5
        ListNode p = node;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) System.out.print(" -> ");
            p = p.next;
        }
    }
}
