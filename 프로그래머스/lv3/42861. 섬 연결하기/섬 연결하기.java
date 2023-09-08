import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        DisjointSet ds = new DisjointSet(n);

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int totalCost = 0;
        
        for(int[] val : costs) {
            int u = val[0];
            int v = val[1];
            if(!ds.union(u, v))
                continue;
            
            totalCost += val[2];
            n--;
        }
        
        return totalCost;
    }
    
    class DisjointSet {
        int[] parent;
        
        
        DisjointSet(int size) {
            parent = new int[size];
            for(int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        int find(int node) {
            if(parent[node] != node) 
                parent[node] = find(parent[node]);
            return parent[node];
        }
        
        boolean union(int u, int v) {
            int ru = find(u);
            int rv = find(v);
            
            if(ru == rv)
                return false;
            else
                parent[rv] = ru;
            
            return true;
        }
        
        
    }
}