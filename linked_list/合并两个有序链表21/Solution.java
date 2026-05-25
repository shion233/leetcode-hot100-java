package linked_list.合并两个有序链表21;

class Solution {
    /*
     * 做题思路：
     * - 两个链表本身已经有序，所以只需要比较当前两个头节点，把较小的接到结果链表尾部。
     * - 使用哑节点 dummy 避免单独处理结果链表第一个节点。
     * - 当其中一个链表走完后，另一个链表剩余部分本来就是有序的，可以直接接到 tail 后面。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 辅助方法：根据数组创建链表
    public static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // 辅助方法：打印链表
    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
        System.out.println();
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // 哑节点
        ListNode tail = dummy;            // tail指向当前新链表的末尾

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // 链接剩余部分
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next; // 哑节点的下一个才是真正的头节点
    }
//    过于复杂
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode p=null,q=null;
//        if(list1!=null&&list2==null){
//            return list1;
//        }
//        if(list1==null&&list2!=null){
//            return list2;
//        }
//        if(list1==null&&list2==null){
//            return list1;
//        }
//        if(list1.val<=list2.val){
//            ListNode temp = list1;
//            list1 = list1.next;
//            temp.next = p;
//            p = temp;
//        }else if(list2.val<list1.val){
//            ListNode temp=list2;
//            list2=list2.next;
//            temp.next=p;
//            p=temp;
//        }
//        q=p;
//        while(list1!=null&&list2!=null){
//            if(list1.val<=list2.val){
//                ListNode temp=list1;
//                list1=list1.next;
//                temp.next=null;
//                q.next=temp;
//                q=q.next;
//            }else {
//                ListNode temp=list2;
//                list2=list2.next;
//                temp.next=null;
//                q.next=temp;
//                q=q.next;
//            }
//        }
//        while(list1!=null){
//            q.next=list1;
//            q=q.next;
//            list1=list1.next;
//            q.next=null;
//        }
//        while(list2!=null){
//            q.next=list2;
//            q=q.next;
//            list2=list2.next;
//            q.next=null;
//        }
//        return p;
//    }

    public static void main(String[] args) {
        // 构造测试链表
        ListNode l1 = buildList(new int[]{-9,3});
        ListNode l2 = buildList(new int[]{5,7});

        System.out.print("l1: ");
        printList(l1);
        System.out.print("l2: ");
        printList(l2);

        // 调用你的合并函数
        ListNode merged = new Solution().mergeTwoLists(l1, l2);
        System.out.print("合并结果: ");
        printList(merged);
    }
}
