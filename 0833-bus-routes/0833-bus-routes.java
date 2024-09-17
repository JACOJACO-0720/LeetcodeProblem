class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {

            int[] temps = routes[i];

            for(int temp: temps){
                List<Integer> lst = hm.getOrDefault(temp, new ArrayList<Integer>());
                lst.add(i);
                hm.put(temp, lst);
            }

        }
        HashSet<Integer> busTaken = new HashSet<>();

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        List<Integer> first = hm.get(source);
        if(source==target){
            return 0;
        }
        if(first==null){
            return -1;
        }

        for (int f : first) {
            ad.push(f);
            busTaken.add(f);
        }

        int res = 0;
        while(!ad.isEmpty()){
            res++;
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                int temp = ad.poll();
                int[] next = routes[temp];
                for (int n : next) {
                    if(n==target){
                        return res;
                    }else{
                        List<Integer> bus = hm.get(n);
                        for (int b: bus) {
                            if(!busTaken.contains(b)){
                                ad.add(b);
                                busTaken.add(b);
                            }
                        }
                    }
                }



            }
        }
        return -1;



    }
}