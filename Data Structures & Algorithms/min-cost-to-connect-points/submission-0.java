
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int totalCost = 0;
        int edgesUsed = 0;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        // Start from point 0 with 0 connection cost
        minDist[0] = 0;

        while (edgesUsed < n) {
            int currNode = -1;
            int currMinEdge = Integer.MAX_VALUE;

            // 1. Pick the unvisited node with the smallest distance to the MST
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minDist[i] < currMinEdge) {
                    currMinEdge = minDist[i];
                    currNode = i;
                }
            }

            // 2. Include this node in the MST
            totalCost += currMinEdge;
            visited[currNode] = true;
            edgesUsed++;

            // 3. Update distances to remaining unvisited nodes
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int dist = Math.abs(points[currNode][0] - points[nextNode][0]) +
                               Math.abs(points[currNode][1] - points[nextNode][1]);
                    
                    if (dist < minDist[nextNode]) {
                        minDist[nextNode] = dist;
                    }
                }
            }
        }

        return totalCost;
    }
}
