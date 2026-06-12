package linked_list.LRU缓存146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    /*
     * 做题思路：
     * - LRU 要同时满足 O(1) 查询和 O(1) 调整最近使用顺序，所以用 HashMap + 双向链表。
     * - map 负责通过 key 直接找到节点，链表负责维护从最久未使用到最近使用的顺序。
     * - get 命中后把节点移动到尾部；put 更新旧节点也移动到尾部，新增时容量满就删除头部后的旧节点。
     * - head 和 tail 是哑节点，用来简化删除头节点、插入尾节点时的边界判断。
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }else  {
            Node node = map.get(key);
            moveToTail(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        }  else  {
            if (map.size() >= capacity) {
                map.remove(head.next.key);
                removeNode(head.next);
                Node node = new Node(key, value);
                map.put(key, node);
                addToTail(node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                addToTail(node);
            }
        }

    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }
}
