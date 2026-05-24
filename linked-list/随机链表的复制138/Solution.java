package 随机链表的复制138;

class Solution {
    /*
     * 做题思路：
     * - 不使用 HashMap 时，可以把复制节点插入到原节点后面，形成 原1->拷1->原2->拷2 的结构。
     * - 这样原节点的 random 如果指向某个节点，那么拷贝节点的 random 就应该指向 original.random.next。
     * - 最后再把交错链表拆开，恢复原链表，同时串出复制链表。
     */
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(0);
        Node p=head,curr=dummy,q=null;
        while (p != null) {
            Node temp = new Node(0);
            temp.val = p.val;
            temp.next = p.next;
            p.next = temp;
            p=temp.next;
        }
        p=head;
        q=p.next;
        while(q!=null&&q.next!=null){
            if(p.random!=null){
                q.random=p.random.next;
                p=p.next.next;
                q=q.next.next;
            }else {
                p=p.next.next;
                q=q.next.next;
            }
        }
        if(p.random!=null){
            q.random=p.random.next;
        }
        p=head;
        q=head.next;
        while (q!=null&&q.next!=null){
            Node temp = q;
            q=q.next;
            curr.next=temp;
            curr=curr.next;
            curr.next=null;
            p.next=q;
            p=p.next;
            q=q.next;
        }
        p.next=null;
        curr.next=q;
        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建节点
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        // 构造 next 指针
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 构造 random 指针
        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        // head
        Node head = node0;
        Solution solution = new Solution();
        Node node = solution.copyRandomList(head);
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
