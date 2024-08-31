import javax.management.MBeanAttributeInfo;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        PriorityQueue<Node> pq = new PriorityQueue(new myComparator());
        for (int i = 0; i < damage.length; i++) {

            int tmp = 0;
            if(health[i]%power==0){
                tmp = health[i]/power;
            }else{
                tmp = health[i]/power+1;
            }
            Node tmpNode = new Node(damage[i],health[i],tmp,damage[i]/(float)tmp );
            pq.add(tmpNode);
        }
        //9,8,7,6  1,2,2,2

        //3,3,3,3  1,2,3,4
        int curD = 0;
        long sumD = 0;
        for (int i = 0; i < damage.length; i++) {
            curD+=damage[i];
        }
        while(!pq.isEmpty()){
            Node tmpNode = pq.poll();
            int tmpNum = tmpNode.num;
            for (int i = 0; i < tmpNum; i++) {
                sumD+=curD;
            }
            curD -= tmpNode.damage;
        }
        return sumD;

    }
    class Node{
        int damage;
        int health;
        int num ;
        float pernum;
        public Node(int damage, int health, int num, float pernum){
            this.damage=damage;
            this.health =health;
            this.num = num;
            this.pernum = pernum;
        }
    }
    class myComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            int res = Float.compare(o2.pernum, o1.pernum);
            return res;
        }
    }
    public static void main(String[] args) {
        int power =4;
        int[] damage = {1,2,3,4};
        int[] health = {4,5,6,8};
        Solution solution = new Solution();
        System.out.println(solution.minDamage(power, damage,health ));

    }
}