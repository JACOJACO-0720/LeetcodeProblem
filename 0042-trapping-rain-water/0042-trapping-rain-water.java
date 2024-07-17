
import java.util.ArrayList;

class Solution {
    public int trap(int[] height) {
        ArrayList<LocalMaximumComponent> localMaximum = new ArrayList<>();
        if (height.length == 0 || height.length == 1) {
            return 0;
        }
        boolean likelyOnLocalMaximum = false;
        if (height[0] > height[1]) {
            LocalMaximumComponent localMaximumComponent = new LocalMaximumComponent(0, 0, height[0]);
            localMaximum.add(localMaximumComponent);
        }
        if (height[0] == height[1]) {
            likelyOnLocalMaximum = true;
            LocalMaximumComponent localMaximumComponent = new LocalMaximumComponent(0, 0, height[0]);
            localMaximum.add(localMaximumComponent);
        }


        for (int i = 1; i < height.length - 1; i++) {
            if (height[i - 1] < height[i] && height[i + 1] < height[i]) {
                LocalMaximumComponent localMaximumComponent = new LocalMaximumComponent(i, i, height[i]);
                localMaximum.add(localMaximumComponent);
            } else if (height[i - 1] == height[i] && height[i + 1] == height[i]) {
                if (likelyOnLocalMaximum) {
                    localMaximum.get(localMaximum.size() - 1).setEnd(i);
                }
            } else if (height[i - 1] == height[i] && height[i + 1] < height[i]) {
                if (likelyOnLocalMaximum) {
                    localMaximum.get(localMaximum.size() - 1).setEnd(i);
                    likelyOnLocalMaximum = false;
                }
            } else if (height[i - 1] == height[i] && height[i + 1] > height[i]) {
                if (likelyOnLocalMaximum) {
                    localMaximum.remove(localMaximum.size() - 1);
                    likelyOnLocalMaximum = false;
                }
            } else if (height[i - 1] < height[i] && height[i + 1] == height[i]) {
                LocalMaximumComponent localMaximumComponent = new LocalMaximumComponent(i, i, height[i]);
                localMaximum.add(localMaximumComponent);
                likelyOnLocalMaximum = true;
            }
        }
        if (height[height.length - 1] > height[height.length - 2]) {
            LocalMaximumComponent localMaximumComponent = new LocalMaximumComponent(height.length - 1, height.length - 1, height[height.length - 1]);
            localMaximum.add(localMaximumComponent);
        }

        int sum = 0;


        int leftMaximumHeight = 0;
        for (LocalMaximumComponent localMaximumComponent : localMaximum) {

            if (localMaximumComponent.height < leftMaximumHeight) {
                localMaximumComponent.increment++;
            }
            if (localMaximumComponent.height > leftMaximumHeight) {
                leftMaximumHeight = localMaximumComponent.height;
            }
        }

        int rightMaximumHeight = 0;
        for (int i = localMaximum.size() - 1; i >= 0; i--) {
            if (localMaximum.get(i).height < rightMaximumHeight) {
                localMaximum.get(i).increment++;
            }
            if (localMaximum.get(i).height > rightMaximumHeight) {
                rightMaximumHeight = localMaximum.get(i).height;
            }
        }
        for (int i = 0; i < localMaximum.size(); i++) {

            if (localMaximum.get(i).increment==2) {
                localMaximum.remove(i);
                i--;
            }
        }

        while (!localMaximum.isEmpty()) {
            LocalMaximumComponent current = localMaximum.remove(localMaximum.size()-1);
            if (localMaximum.isEmpty()) {
                break;
            }

            LocalMaximumComponent next = localMaximum.get(localMaximum.size()-1);
            int threshold = Math.min(height[current.end], height[next.begin]);
            for (int i = next.end + 1; i < current.begin; i++) {

                if (height[i] < threshold) {
                    sum += threshold - height[i];
                }
            }
        }
        return sum;
    }

    static class LocalMaximumComponent {
        private final int begin;
        private int end;

        private final int height;

        private int increment;

        LocalMaximumComponent(int begin, int end, int height) {
            this.begin = begin;
            this.end = end;
            this.height = height;
            increment=0;

        }

        public void setEnd(int end) {
            this.end = end;
        }

    }

    public static void main(String[] args) {
        int[] test = {5, 5, 1, 7, 1, 1, 5, 2, 7, 6};
        Solution solution = new Solution();
        System.out.println(solution.trap(test));
    }
}