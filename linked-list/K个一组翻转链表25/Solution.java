package K个一组翻转链表25;

class Solution {
    /*
     * 做题思路：
     * - 先用哑节点统一处理头节点也会被翻转的情况。
     * - 每走到第 k 个节点，就把这一段临时断开，用头插法原地翻转这一组。
     * - 翻转后再把上一组尾部、当前组新尾部和下一组开头重新接回去。
     * - 上面注释掉的代码是我最初的写法，核心思路是对的，但变量含义复用太多；
     *   当前代码在大模型指导下主要优化了命名和连接步骤的表达，让链表边界更清楚。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
//    思路正确，但命名混乱，代码的“表达”没有跟上脑子里的正确思路。
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(k==1) return head;
//        ListNode dummynode = new ListNode(0);
//        dummynode.next=head;
//        ListNode p=dummynode,cur=head;
//        int count =1;
//        while(cur!=null&&cur.next!=null){
//            cur=cur.next;
//            count++;
//            if(count%k==0){
//                ListNode temp=cur;
//                cur=cur.next;
//                count++;
//                temp.next=null;
//                temp=p.next;
//                ListNode cont=temp;
//                p.next=null;
//                while(temp!=null){
//                    ListNode temp2=temp.next;
//                    temp.next=p.next;
//                    p.next=temp;
//                    temp=temp2;
//                }
//                p=cont;
//                p.next=cur;
//            }
//        }
//        return dummynode.next;
//    }

//    修改后的代码（算法结构完全不变，只改名/拆分变量）
public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prevGroupTail = dummy;   // 原 p
    ListNode iter = head;             // 原 cur，遍历指针
    int index = 1;                    // 原 count，当前节点序号（从1开始）

    while (iter != null && iter.next != null) {
        iter = iter.next;
        index++;

        if (index % k == 0) {
            // iter 现在是当前组的最后一个节点
            ListNode groupEnd = iter;            // 原 temp 的第一个含义
            iter = iter.next;                    // 移向下一组开头
            index++;
            groupEnd.next = null;                // 断开当前组尾部

            ListNode groupHead = prevGroupTail.next; // 原 temp 的第二个含义
            ListNode newGroupTail = groupHead;        // 原 cont，翻转后会成为组尾

            prevGroupTail.next = null;           // 断开前驱与组头的连接

            // 头插法翻转 groupHead 开头的链表
            ListNode toReverse = groupHead;      // 原 temp（翻转用）
            while (toReverse != null) {
                ListNode nextNode = toReverse.next; // 原 temp2
                toReverse.next = prevGroupTail.next;
                prevGroupTail.next = toReverse;
                toReverse = nextNode;
            }

            // 重新连接：让 prevGroupTail 指向翻转后的组尾，再链接下一组
            prevGroupTail = newGroupTail;
            prevGroupTail.next = iter;
        }
    }

    return dummy.next;
}
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        solution.reverseKGroup(head, 2);

    }
}
