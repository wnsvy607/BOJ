import java.util.*;

class Solution {
    public int solution(int n, int[][] cp) {
        
        DisjointSet ds = new DisjointSet(n);
        boolean[][] visited = new boolean[n][n];
        

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || visited[i][j])
                    continue;
                if(cp[i][j] == 1) {
                    ds.union(i, j);
                    visited[i][j] = visited[j][i] = true;
                 }
            }
        }
        
        return getNumberOfNetworks(ds);
    }
    
    int getNumberOfNetworks(DisjointSet ds) {
        Set<Integer> set = new HashSet<>();
        
        for(int par : ds.parent) {
            set.add(ds.find(par));
        }
        
        return set.size();
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
            if(parent[node] != node) parent[node] = find(parent[node]);
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