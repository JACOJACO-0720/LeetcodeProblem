class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {

        int[] result = new int[state.length];
        Stack<int[]> enterStack = new Stack<>();
        Stack<int[]> exitStack = new Stack<>();
        for (int i = state.length - 1; i >= 0; i--) {
            if (state[i] == 0) {
                int[] temp = { arrival[i], i };
                enterStack.push(temp);
            } else {
                int[] temp = { arrival[i], i };
                exitStack.push(temp);
            }
        }
        int time = 0;
        int currentState = 1; // 1 means exit; 0 means enter
        while (!enterStack.isEmpty() && !exitStack.isEmpty()) {
            if (currentState == 0) {

                int[] temp = enterStack.peek();
                int positime = temp[0];
                int posi = temp[1];
                if (positime > time) {
                    int[] oppotemp = exitStack.peek();
                    int oppopositime = oppotemp[0];
                    int oppoposi = oppotemp[1];
                    if (oppopositime <= time) {
                        result[oppoposi] = time;
                        time++;
                        exitStack.pop();
                        currentState = 1;
                    } else {
                        time++;
                        currentState = 1;
                        continue;
                    }

                } else {
                    result[posi] = time;
                    time++;
                    enterStack.pop();
                }

            } else {
                int[] temp = exitStack.peek();
                int positime = temp[0];
                int posi = temp[1];
                if (positime > time) {
                    int[] oppotemp = enterStack.peek();
                    int oppopositime = oppotemp[0];
                    int oppoposi = oppotemp[1];
                    if (oppopositime <= time) {
                        result[oppoposi] = time;
                        time++;
                        enterStack.pop();
                        currentState = 0;
                    } else {
                        time++;
                        currentState = 1;
                        continue;
                    }
                } else {
                    result[posi] = time;
                    time++;
                    exitStack.pop();
                }
            }

        }
        while (!enterStack.isEmpty()) {
            int[] temp = enterStack.peek();
            int positime = temp[0];
            int posi = temp[1];
            if (positime > time) {
                time++;
            } else {
                result[posi] = time;
                time++;
                enterStack.pop();
            }
        }
        while (!exitStack.isEmpty()) {
            int[] temp = exitStack.peek();
            int positime = temp[0];
            int posi = temp[1];
            if (positime > time) {
                time++;
            } else {
                result[posi] = time;
                time++;
                exitStack.pop();
            }
        }
        return result;
    }

}