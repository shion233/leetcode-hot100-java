package linked_list.排序链表148;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    /*
     * 做题思路：
     * - 链表排序适合用归并排序，因为合并两个有序链表可以原地改指针完成。
     * - 先用快慢指针找到链表中点并断开，把链表分成两半。
     * - 分别递归排序左右两半，最后按合并两个有序链表的方式合并。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. 计算链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0); // 虚拟头结点，简化操作
        dummy.next = head;

        // 2. subLen 表示当前要合并的子链表长度，每次翻倍
        for (int subLen = 1; subLen < length; subLen *= 2) {
            ListNode prev = dummy;      // prev 用来串联已合并的部分
            ListNode curr = dummy.next; // 当前待处理的起点

            while (curr != null) {
                // 3. 切出第一段长度为 subLen 的子链表
                ListNode head1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next; // 第二段的起点
                curr.next = null;           // 切断第一段结尾
                curr = head2;

                // 4. 切出第二段长度为 subLen 的子链表（可能不足长）
                if (curr != null) {
                    for (int i = 1; i < subLen && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = curr.next; // 剩余未处理部分的起点
                    curr.next = null;          // 切断第二段结尾
                    curr = next;
                }

                // 5. 合并 head1 和 head2，并把 prev 接到合并后的链表上
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next; // prev 走到当前已合并部分的末尾
                }
            }
        }
        return dummy.next;
    }

    // 合并两个有序链表（经典题目 21）
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
//    题目的本意：链表的归并排序
//    public ListNode sortList(ListNode head) {
//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode p = head;
//        int n=0;
//        while (p != null) {
//            list.add(p.val);
//            p = p.next;
//        }
//        p=head;
//        Collections.sort(list);
//        while(p!=null){
//            p.val=list.get(n++);
//            p=p.next;
//        }
//        return head;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode node = solution.sortList(head);
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
