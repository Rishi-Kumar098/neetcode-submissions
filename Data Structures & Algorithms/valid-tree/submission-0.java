class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition: A valid tree with n nodes must have exactly n - 1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];
        // Initially, each node is its own parent (n separate components)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Process each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // If they share the same root, adding this edge creates a cycle
            if (rootU == rootV) {
                return false;
            }

            // Union: Connect the components
            parent[rootU] = rootV;
        }

        // If it has n - 1 edges and no cycles, it must be fully connected
        return true;
    }

    // Find operation with path compression optimization
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
}
