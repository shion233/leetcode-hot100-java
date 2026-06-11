package graph.实现Trie前缀树208;

class Trie {
    /*
     * 做题思路：
     * - Trie 前缀树把字符串按字符逐层存储，每条从 root 出发的路径表示一个前缀。
     * - Node 中的 children 长度为 26，对应 'a' 到 'z' 的下一个节点；isend 标记当前节点是否是某个完整单词的结尾。
     * - insert 按字符向下走，不存在的节点就新建，遍历完整个 word 后把最后一个节点标记为单词结尾。
     * - search 和 startsWith 都是沿字符路径查找：search 需要最后节点 isend 为 true，startsWith 只要前缀路径存在即可。
     */
    Node root;
    class Node {
        boolean isend;
        Node[] children;

        public Node() {
            isend = false;
            children = new Node[26];
        }
    }
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new Node();
            }
            p = p.children[c - 'a'];
        }
        p.isend = true;
    }

    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return p.isend;
    }

    public boolean startsWith(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return true;
    }
}
