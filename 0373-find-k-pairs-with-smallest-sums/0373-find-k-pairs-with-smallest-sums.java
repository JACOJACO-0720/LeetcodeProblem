class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1,Node n2)->(Integer.compare(n1.xnum+n1.ynum,n2.xnum+n2.ynum )));
        pq.add(new Node(0,0,nums1[0],nums2[0]));
        while(res.size()<k){
            Node temp = pq.poll();
            List<Integer> tempres = new ArrayList<>();
            tempres.add(temp.xnum);tempres.add(temp.ynum);
            res.add(tempres);
            if(temp.x<nums1.length-1 && !hs.contains((temp.x+1)+"-"+temp.y)){
                hs.add((temp.x+1)+"-"+temp.y);
                pq.add(new Node(temp.x+1,temp.y,nums1[temp.x+1],nums2[temp.y]));
            }
            if(temp.y<nums2.length-1 && !hs.contains((temp.x)+"-"+(temp.y+1))){
                hs.add(temp.x+"-"+(temp.y+1));
                pq.add(new Node(temp.x,temp.y+1,nums1[temp.x],nums2[temp.y+1]));
            }

        
        }
        return res;
    }
    
    class Node{
        int x;
        int y;
        int xnum;
        int ynum;
        public Node(int x,int y, int xnum, int ynum){
            this.x = x;
            this.y=y;
            this.xnum=xnum;
            this.ynum=ynum;
        }
    }
}