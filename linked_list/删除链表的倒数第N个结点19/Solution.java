package linked_list.删除链表的倒数第N个结点19;

class Solution {
    /*
     * 做题思路：
     * - 使用快慢指针让 p2 先走 n 步，这样 p1 和 p2 之间保持 n 个节点的距离。
     * - 当 p2 走到尾部附近时，p1 就停在待删除节点的前一个位置。
     * - 如果 p2 提前变成 null，说明要删除的是头节点，直接返回 head.next。
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null&& n-- > 0) {
            p2 = p2.next;
        }
        while (p2 != null&&p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2==null) {
            p1 =p1.next;
            return p1;
        }
        ListNode temp = p1.next;
        p1.next = temp.next;
        temp.next = null;
        return head;
    }
}