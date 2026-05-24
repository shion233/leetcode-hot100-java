package 两两交换链表中的节点24;

class Solution {
    /*
     * 做题思路：
     * - 两两交换链表节点时，使用哑节点统一处理头两个节点也要交换的情况。
     * - 每轮关注 prev 后面的两个节点 first、second，调整三条连接关系完成交换。
     * - 交换后 prev 移动到这一组的新尾节点，继续处理下一组。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            // 标记要交换的两个节点
            ListNode first = prev.next;
            ListNode second = first.next;

            // 执行交换
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // prev 前进两步，准备下一轮
            prev = first;
        }

        return dummy.next;
    }
//    核心思想：用 dummy 节点，每次交换 prev 后面的两个节点，然后移动 prev 两步。
//    public ListNode swapPairs(ListNode head) {
//        if (head==null||head.next==null)
//            return head;
//        ListNode dummyNode = new ListNode(0);
//        ListNode p=head,cur=dummyNode;
//        while (p!=null&&p.next!=null)
//        {
//            cur.next=p.next;
//            p.next=p.next.next;
//            cur=cur.next;
//            cur.next=null;
//            p=p.next;
//        }
//        p=head;
//        cur=dummyNode.next;
//        while (p!=null)
//        {
//            ListNode temp=p;
//            p=p.next;
//            temp.next=cur.next;
//            cur.next=temp;
//            if (temp.next==null)
//                break;
//            else
//                cur=temp.next;
//        }
//        cur.next.next=p;
//        return dummyNode.next;
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = new Solution().swapPairs(head);
    }
}