package stack.字符串解码394;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    /*
     * 做题思路：
     * - 字符串解码存在嵌套括号，遇到 '[' 时需要保存当前上下文，遇到 ']' 时再恢复并拼接，所以使用栈来处理。
     * - numStack 保存每一层括号前解析出的重复次数，strStack 保存进入当前括号前已经构造好的字符串 previous。
     * - 遍历 s 时，数字字符累加到 num；遇到 '[' 就把 num 和 current 分别入栈，并开始构造括号内的新 current。
     * - 遇到 ']' 时弹出 repeat 和 previous，把当前 current 重复 repeat 次追加到 previous 后，再让 current 回到拼接后的结果。
     * - 普通字母直接追加到 current，遍历结束后 current 就是完整解码结果。
     * - 注释掉的旧代码是我最初的解法：用数字栈和字符栈处理，遇到 ']' 后弹出字符再反转、重复压回，流程更绕且字符串拼接成本更高；当前解法直接保存每层字符串上下文，更清晰。
     */
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();

        int num = 0;
        StringBuilder current = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(current);
                num = 0;
                current = new StringBuilder();
            } else if (c == ']') {
                int repeat = numStack.pop();
                StringBuilder previous = strStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
//    public String decodeString(String s) {
//        if (s == null || s.length()==0) return "";
//        if (s.length() == 1) return s;
//        ArrayDeque<Integer> istack = new ArrayDeque<>();
//        ArrayDeque<Character> cstack = new ArrayDeque<>();
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
//                int t = i;
//                while (s.charAt(t) != '[') {
//                    t++;
//                }
//                int k = Integer.valueOf(s.substring(i, t));
//                istack.push(k);
//                i=t-1;
//            }else if (s.charAt(i) == ']') {
//                Integer pop = istack.pop();
//                StringBuilder temp = new StringBuilder();
//                while (!cstack.isEmpty()) {
//                    Character c = cstack.pop();
//                    if (c == '[') {
//                        break;
//                    }else {
//                        temp.append(c);
//                    }
//                }
//                temp.reverse();
//                for (int j = 0; j < pop; j++) {
//                    for (int k = 0; k < temp.length(); k++) {
//                        cstack.push(temp.charAt(k));
//                    }
//                }
//            }else {
//                cstack.push(s.charAt(i));
//            }
//        }
//        while (!cstack.isEmpty()) {
//            res.append(cstack.pop());
//        }
//        res.reverse();
//        return res.toString();
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}

