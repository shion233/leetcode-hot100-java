package backtracking.单词搜索79;

import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 单词搜索是在二维网格里找一条连续路径，适合从每个可能的起点出发做回溯搜索。
     * - exist 先枚举所有等于 word 第一个字符的位置，visited 记录当前路径已经走过的格子，避免同一个格子重复使用。
     * - backtracking 中的 n 表示当前要匹配 word 的第几个字符，越界、字符不匹配或已经访问过都直接返回 false。
     * - 当前字符匹配后，继续向上、下、左、右四个方向搜索 n + 1；递归结束后把 visited[x][y] 改回 false，恢复现场给其他路径使用。
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 ) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int n=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = backtracking(board, i, j, visited, n, word);
                    if (res) return true;
                }
            }
        }
        return false;
    }
    public boolean backtracking(char[][] board, int x, int y, boolean[][] visited,int n,String word) {
        if (x<0||y<0||x>=board.length || y>=board[0].length || board[x][y]!=word.charAt(n)||visited[x][y]) return false;
        if (n == word.length()-1) {
            return true;
        }
        visited[x][y]=true;
        boolean u = backtracking(board, x - 1, y, visited, n + 1, word);
        boolean d = backtracking(board, x + 1, y, visited, n + 1, word);
        boolean l = backtracking(board, x, y - 1, visited, n + 1, word);
        boolean r = backtracking(board, x, y + 1, visited, n + 1, word);
        boolean f = u||d||l||r;
        visited[x][y]=false;
        return f;
    }

}
