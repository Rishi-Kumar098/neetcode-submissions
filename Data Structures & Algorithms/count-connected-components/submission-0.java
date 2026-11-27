class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        // Initially, every node is its own parent (n isolated components)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        int components = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent, rank)) {
                components--;
            }
        }
        
        return components;
    }
    
    // Find with path compression
    private int find(int node, int[] parent) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
    
    // Union by rank; returns true if two separate components were merged
    private boolean union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        
        if (rootU == rootV) {
            return false; // Already in the same component
        }
        
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            rank[rootU] += rank[rootV];
        } else {
            parent[rootU] = rootV;
            rank[rootV] += rank[rootU];
        }
        
        return true;
    }
}
