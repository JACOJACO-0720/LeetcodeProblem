import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        String[] cleaned = path.split("/+");
        Deque<String> deque = new ArrayDeque<>();
        for (String dir : cleaned) {
            if (dir.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                deque.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) {
            return "/";
        }
        for (Iterator<String> it = deque.descendingIterator(); it.hasNext(); ) {
            String dir = it.next();
            sb.append("/");
            sb.append(dir);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/../sdsds/";
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath(path));
    }
}