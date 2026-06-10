package graph.课程表207;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 课程和先修关系可以看成有向图，prerequisites[i] = [to, from] 表示学 from 后才能学 to，所以建边 from -> to。
     * - 要判断能否完成所有课程，本质是判断这个有向图里有没有环；如果有环，环上的课程互相依赖，就无法完成。
     * - visited 用三种状态标记节点：0 表示未访问，1 表示当前递归路径中正在访问，2 表示已经确认无环。
     * - DFS 遇到 visited == 1 的节点说明回到了当前路径上的课程，存在环；遍历完所有后继课程后把当前节点标记为 2。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!Dfs(graph, i , visited))
                    return false;
            }
        }
        return true;
    }
    public boolean Dfs(List<List<Integer>> graph, int src, int[] visited) {
        if (visited[src] == 1) return false;
        if (visited[src] == 2) return true;
        visited[src] = 1;
        for (int i : graph.get(src)) {
            if (!Dfs(graph, i , visited))
                return false;
        }
        visited[src] = 2;
        return true;
    }
}
