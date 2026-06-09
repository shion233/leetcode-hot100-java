package graph.腐烂的橘子994;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /*
     * 做题思路：
     * - 腐烂会按分钟从所有烂橘子同时向四周扩散，本质是多源 BFS。
     * - 先扫描网格，fresh 统计新鲜橘子数量，queue 保存所有初始腐烂橘子的位置，作为 BFS 的第一层。
     * - 每一轮处理当前队列中的全部腐烂橘子，尝试把上、下、左、右的新鲜橘子变成腐烂橘子，并加入下一轮队列。
     * - rotted 用来判断这一分钟是否真的腐烂了新橘子，只有发生扩散时 minutes 才加一；最后还有 fresh 说明有橘子无法被腐烂，返回 -1。
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int fresh = 0;
        int minutes=0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(x-1>=0&&grid[x-1][y]==1){
                    fresh--;
                    grid[x-1][y]=2;
                    rotted=true;
                    queue.add(new int[]{x-1, y});
                }
                if(x+1<row&&grid[x+1][y]==1){
                    fresh--;
                    grid[x+1][y]=2;
                    rotted=true;
                    queue.add(new int[]{x+1, y});
                }
                if(y-1>=0&&grid[x][y-1]==1){
                    fresh--;
                    grid[x][y-1]=2;
                    rotted=true;
                    queue.add(new int[]{x, y-1});
                }
                if(y+1<col&&grid[x][y+1]==1){
                    fresh--;
                    grid[x][y+1]=2;
                    rotted=true;
                    queue.add(new int[]{x, y+1});
                }
            }
            if (rotted)
                minutes++;
        }
        return fresh!=0?-1:minutes;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(grid));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
