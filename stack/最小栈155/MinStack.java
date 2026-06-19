package stack.最小栈155;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    /*
     * 做题思路：
     * - 题目要求 push、pop、top 和 getMin 都尽量做到 O(1)，所以不能每次 getMin 时重新遍历整个栈。
     * - stack 保存正常入栈的所有元素，minStack 专门保存“当前最小值”的变化历史。
     * - push 时，如果 minStack 为空，或者新 value 小于等于当前最小值 minStack.peek()，就把 value 同时压入 minStack。
     * - pop 时，先从 stack 弹出 value；如果这个 value 正好等于 minStack 栈顶，说明当前最小值被移除了，也要同步弹出 minStack。
     * - top 直接返回 stack.peek()，getMin 直接返回 minStack.peek()；代码没有注释掉的旧解法，当前思路符合本题常见双栈解法。
     */
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        int value = stack.pop();

        if (value == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
