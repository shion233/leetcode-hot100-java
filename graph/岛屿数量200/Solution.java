package graph.岛屿数量200;

class Solution {
    /*
     * 做题思路：
     * - 把网格看成图，字符 '1' 表示陆地，字符 '0' 表示水；一座岛屿就是上下左右连通的一片陆地。
     * - 外层双重循环扫描每个格子，遇到一个还没有被访问过的 '1'，说明发现了一座新岛屿，count 加一。
     * - dfs 从当前陆地出发，向上、下、左、右四个方向扩展，把同一座岛屿里的所有 '1' 都改成 '0'。
     * - 这样后续扫描不会重复统计已经访问过的陆地，越界或遇到非 '1' 时递归直接返回。
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void  dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (grid[row][col] != '1')
            return;
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
