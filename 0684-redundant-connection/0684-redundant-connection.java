class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ancester = new int[edges.length+1];
        for(int i =0;i< edges.length+1; i++){
            ancester[i] = i;
        }
        for(int i =0;i<edges.length;i++){
            int[] tmp = edges[i];
            int anc1 = ancester[tmp[0]];
            int anc2 = ancester[tmp[1]];
            
            int rootans1 = find(anc1,ancester);
            int rootans2 = find(anc2, ancester);

            if(rootans1 == rootans2){
                return tmp;
            }
            if(rootans1 > rootans2){
               ancester[rootans1] = rootans2;
            }else{
                ancester[rootans2] = rootans1;
            }
        } 
        return null;
    }
int find(int node, int[] parent) {
    if (parent[node] != node) {
        parent[node] = find(parent[node], parent); // 将节点直接连接到根节点
    }
    return parent[node];
}
}