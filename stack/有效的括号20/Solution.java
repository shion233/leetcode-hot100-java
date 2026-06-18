package stack.有效的括号20;

import java.util.LinkedList;

class Solution {
    /*
     * 做题思路：
     * - 括号匹配满足“后出现的左括号要先被匹配”，这是典型的后进先出结构，所以用 LinkedList 当作栈。
     * - 遍历字符串 s，遇到左括号 '('、'{'、'[' 就用 addFirst 入栈，等待后面的右括号匹配。
     * - 遇到右括号时，如果 stack 为空，说明没有对应的左括号，直接返回 false。
     * - 否则 removeFirst 弹出最近的左括号 c1，再根据当前右括号 c 判断类型是否对应，不对应就返回 false。
     * - 遍历结束后，如果 stack 还有剩余左括号，说明没有全部闭合，也返回 false；代码没有注释掉的旧解法，当前思路符合本题常见栈解法。
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
            }
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char c1 = stack.removeFirst();
                if(c==')'&&c1!='('){
                    return false;
                }else if(c=='}'&&c1!='{'){
                    return false;
                }else if(c==']'&&c1!='['){
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("["));
    }
}
