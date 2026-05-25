package linked_list.环形链表141;

public class Solution {

    /*
     * 做题思路：
     * - 用快慢指针判断链表是否有环。
     * - 慢指针一次走一步，快指针一次走两步；如果有环，快指针最终会在环内追上慢指针。
     * - 如果快指针或 fast.next 先到 null，说明链表没有环。
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        boolean result = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }
        return result;
    }
}
