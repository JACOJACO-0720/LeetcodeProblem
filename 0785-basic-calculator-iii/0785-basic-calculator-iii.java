class Solution {
    public int calculate(String s) {
        if (s == null)
            return 0;
        Queue<Character> q = new LinkedList();
        for (char c : s.toCharArray())
            q.offer(c);
        return cal(q);
    }

    private int cal(Queue<Character> q) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char prevOp = '+';
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '(') {
                num = cal(q);
            } else if ("+-*/".indexOf(c) != -1) {
                eval(stack, num, prevOp);
                num = 0;
                prevOp = c;
            } else if (c == ')') {
                break;
            }
        }
        eval(stack, num, prevOp);
        return stack.stream().mapToInt(a -> a).sum();
    }

    private void eval(Stack<Integer> stack, int num, char op) {
        switch (op) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
            default:
                break;
        }
    }
}