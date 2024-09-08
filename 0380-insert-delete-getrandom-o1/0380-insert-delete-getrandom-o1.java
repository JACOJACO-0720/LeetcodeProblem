class RandomizedSet {
         HashMap<Integer, Integer> hm;
            List<Integer> lst;
    public RandomizedSet() {
        hm = new HashMap<>();
        lst = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }else{
            lst.add(val);
            hm.put( val,lst.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false;
        }else{
            int posi = hm.get(val);
            if(posi==lst.size()-1){
                lst.removeLast();
                hm.remove(val);
            }else{
                int temp = lst.removeLast();
                lst.set(posi, temp);
                hm.put(temp, posi);
                hm.remove(val);
            }
            return true;
        }
    }
    
    public int getRandom() {
        Random ramdom  =new Random();
        int next = ramdom.nextInt(lst.size());
        return lst.get(next);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */