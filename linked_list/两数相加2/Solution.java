package linked_list.两数相加2;

class Solution {
    /*
     * 做题思路：
     * - 两个链表按逆序存储数字，所以可以从头节点开始像竖式加法一样逐位相加。
     * - p、q 分别遍历两个链表，某个链表提前结束时当前位按 0 处理。
     * - carry 保存进位，每一位新建一个 sum % 10 的节点，循环结束后如果还有进位再补一个节点。
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead =new ListNode(0);
        ListNode p=l1,q=l2,curr=dummyhead;
        int carry=0;
        while(p!=null|q!=null){
            int x=(p!=null)?p.val:0;
            int y=(q!=null)?q.val:0;
            int sum=carry+x+y;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null)
                p=p.next;
            if(q!=null)
                q=q.next;
        }
        if(carry>0)
            curr.next=new ListNode(carry);
        return dummyhead.next;
    }
}
