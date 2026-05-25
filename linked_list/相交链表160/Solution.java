package linked_list.相交链表160;

public class Solution {
    /*
     * 做题思路：
     * - 两条链表如果相交，从交点开始后面的节点引用完全相同。
     * - 先分别计算两条链表长度，让较长链表先走长度差。
     * - 之后两个指针同步向后走，第一次引用相等的位置就是交点；如果没有相等则不相交。
     */
    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA;
        ListNode lb = headB;
        ListNode r = null;
        int lenA = 0, lenB = 0;
        int n=0;
        if (headA == headB) {
            return headA;
        }
        while (headA != null) {
            lenA++;
            headA = headA.next;
        }
        while (headB != null) {
            lenB++;
            headB = headB.next;
        }
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                la = la.next;
            }
            n=lenB;
        }
        if (lenA <= lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                lb = lb.next;
            }
            n=lenA;
        }
        for (int i = 0; i < n; i++) {
            if (la == lb) {
                r=la;
                break;
            }
            la = la.next;
            lb = lb.next;
        }
        return r;
    }
}
