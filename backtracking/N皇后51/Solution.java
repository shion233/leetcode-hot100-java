package backtracking.N皇后51;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - N 皇后需要在每一行放一个皇后，并保证任意两个皇后不在同一列、同一斜线，适合按行回溯。
     * - row 表示当前要放置皇后的行号，path 保存已经放好的棋盘行字符串。
     * - 每一行尝试所有 col，只有 isvalid 判断当前列、左上斜线、右上斜线都没有皇后时，才把这一行加入 path。
     * - 当 row == n 时，说明 n 行都已经合法放置完成，拷贝 path 加入结果；递归返回后移除最后一行，继续尝试其他列。
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return new ArrayList<List<String>>();
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int row = 0;
        backtracking(row,n,path,res);
        return res;
    }
    public void backtracking(int row, int n, List<String> path, List<List<String>> res) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isvalid(row,col,n,path))
                continue;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append('.');
            }
            stringBuilder.setCharAt(col, 'Q');
            path.add(stringBuilder.toString());
            backtracking(row + 1, n, path, res);
            path.remove(path.size() - 1);
        }
    }

    private boolean isvalid(int row, int col, int n, List<String> path) {
        // 1. 检查同一列
        for (int i = 0; i < row; i++) {
            if (path.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 2. 检查左上斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (path.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 3. 检查右上斜线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (path.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
