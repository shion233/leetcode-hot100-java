package linked_list.合并K个升序链表23;

class Solution {
    /*
     * 做题思路：
     * - 当前代码使用归并思想，把 k 个链表按 1、2、4... 的步长两两合并。
     * - 每一轮都会让链表数量大约减半，合并两个有序链表复用经典双指针写法。
     * - 注释掉的复杂解法是我最初直接把后续链表逐个插入第一条链表的思路，指针细节更绕；
     *   当前解法结构更稳定，复杂度也更容易分析。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 构造链表辅助方法：根据可变参数创建链表
    public static ListNode createList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : values) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int n = lists.length;
        // 外层循环控制步长：1, 2, 4, 8 ...
        for (int step = 1; step < n; step *= 2) {
            // 内层循环：按步长两两合并
            for (int i = 0; i + step < n; i += 2 * step) {
                // 合并 lists[i] 和 lists[i+step]，结果存入 lists[i]
                lists[i] = mergeTwoLists(lists[i], lists[i + step]);
                lists[i + step] = null; // 可选，帮助GC
            }
        }
        return lists[0];
    }

    // 标准的归并两个有序链表（之前已实现过）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
//    复杂解法
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//        int len = lists.length;
//        if (len == 1) return lists[0];
//        ListNode dummy = new ListNode(0);
//        dummy.next = lists[0];
//        ListNode cur = dummy;
//        for (int i = 1; i < len; i++) {
//            ListNode q = lists[i];
//            while (cur.next != null && q != null) {
//                if (cur.next.val <= q.val) {
//                    cur=cur.next;
//                }else  {
//                    ListNode temp = q.next;
//                    q.next=cur.next;
//                    cur.next=q;
//                    cur=q;
//                    q=temp;
//                }
//            }
//            if (q != null) {
//                cur.next = q;
//            }
//            cur=dummy;
//        }
//        return dummy.next;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[] {
                createList(1, 4, 5),
                createList(1, 3, 4),
                createList(2, 6)
        };
        ListNode node = solution.mergeKLists(lists);
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}