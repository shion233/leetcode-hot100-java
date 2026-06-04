package backtracking.括号生成22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 括号生成要枚举所有合法括号串，适合用回溯逐步决定当前位置放左括号还是右括号。
     * - left 和 right 分别表示还剩多少个左括号、右括号可以使用，path 保存当前已经生成的括号前缀。
     * - 只要 left > 0，就可以继续放左括号；只有 right > left 时，说明当前前缀中左括号数量更多，才可以放右括号。
     * - 当 left 和 right 都为 0 时，说明已经生成一个长度为 2n 的合法括号串，加入结果集；递归返回后删除最后一个字符恢复现场。
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtracking(n, n, path, res);
        return res;
    }
    public void backtracking(int left,int right,StringBuilder path, List<String> res) {
        if (left == 0&&right == 0) {
            res.add(path.toString());
            return;
        }
        if (left > 0) {
            path.append("(");
            backtracking(left-1, right, path, res);
            path.deleteCharAt(path.length()-1);
        }
        if (right > left) {
            path.append(")");
            backtracking(left, right-1, path, res);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
