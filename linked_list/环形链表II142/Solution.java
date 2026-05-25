package linked_list.环形链表II142;

public class Solution {
    /*
     * 做题思路：
     * - 先用快慢指针判断是否有环，并找到第一次相遇点。
     * - 相遇后，一个指针从头节点出发，另一个从相遇点出发，两者每次都走一步。
     * - 它们再次相遇的位置就是入环节点，这是由链表入环前距离和环内距离关系决定的。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode buildLinkedList(int[] values, int pos) {
        if (values == null || values.length == 0) return null;

        // 创建所有节点
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
        }

        // 连接 next 指针
        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // 设置环
        if (pos >= 0 && pos < values.length) {
            nodes[values.length - 1].next = nodes[pos];
        }

        return nodes[0]; // 返回头节点
    }
    public ListNode detectCycle(ListNode head) {
        ListNode pos=null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] head = {3, 2, 0, -4};
        int pos = 1;

        // 构造链表
        ListNode list = buildLinkedList(head, pos);

        // 找到索引为 1 的节点（环的入口）
        ListNode cycleEntry = new Solution().detectCycle(list);

        // 输出结果
        if (cycleEntry != null) {
            System.out.println("环的入口节点值为: " + cycleEntry.val); // 2
        } else {
            System.out.println("无环");
        }
    }
}
