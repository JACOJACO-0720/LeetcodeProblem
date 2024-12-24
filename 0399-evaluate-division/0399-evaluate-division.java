class Solution {
    private int[] parent;
    private double[] val;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var h = new HashMap<String, Integer>();
        var size = 0;
        for(var e : equations){
            if(!h.containsKey(e.get(0))){
                h.put(e.get(0),size++);
            }
            if(!h.containsKey(e.get(1))){
                h.put(e.get(1),size++);
            }
        }
        
        parent = new int[size];
        val = new double[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
            val[i] = 1.0d;
        }
        
        for(int i = 0;  i < equations.size(); i++){
            var e = equations.get(i);
            var idx0 = h.get(e.get(0));
            var idx1 = h.get(e.get(1));
            union(idx0, idx1, values[i]);
        }
        
        var n = queries.size();
        var result = new double[n];
        for(int i = 0; i < n; i++){
            var q = queries.get(i);
            var s1 = q.get(0);
            var s2 = q.get(1);
            
            var idx1 = h.get(s1);
            var idx2 = h.get(s2);
            if(idx1 == null || idx2 == null){
                result[i] = -1.0d;
                continue;
            }

            if(idx1 == idx2){
                result[i] = 1.0d;
                continue;
            }
            
            var a = find(idx1);
            var b = find(idx2);
            if(a != b){
                result[i] = -1.0d;
                continue;
            }
            else{
                result[i] = val[idx1] / val[idx2];
            }
        }
        
        return result;
    }
    
    private int find(int x){
        if(x == parent[x]) return x;
        
        var v = 1.0d;
        var a = x;
        while(a != parent[a]){
            v = v * val[a];
            a = parent[a];
        }
        
        parent[x] = a;
        val[x] = v;
        return a;
    }
    
    private void union(int x, int y, double v){
        var a = find(x);
        var b = find(y);
        if(a == b) return;
        
        parent[a] = b;
        val[a] = v * (val[y] / val[x]);
    }
}
