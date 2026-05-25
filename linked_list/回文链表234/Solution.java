package linked_list.回文链表234;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
     * 做题思路：
     * - 回文链表需要比较前半段和后半段是否对称。
     * - 先用快慢指针找到中点，再反转后半段链表。
     * - 最后从头节点和后半段反转后的头节点同时向后比较，全部相等就是回文。
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        boolean result = false;
        if (head == null ) {return result;}
        ListNode node = new ListNode();
        node.val = head.val;
        node.next = null;
        ListNode p=head.next;
        while (p!=null){
            ListNode temp = new ListNode();
            temp.val = p.val;
            temp.next = node;
            node=temp;
            p=p.next;
        }
        while(head!=null&&node!=null){
            if(head.val != node.val){
                return false;
            }
            head=head.next;
            node=node.next;
        }
        result=true;
        return result;
    }
    public static void main(String[] args) {
        int[] values = {1};
        ListNode dummy = new ListNode(0);   // 虚拟头节点
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        ListNode head = dummy.next;   // head 即链表 [1,2,3,4,5]
        boolean palindrome = new Solution().isPalindrome(head);
        System.out.println(palindrome);
    }
}
