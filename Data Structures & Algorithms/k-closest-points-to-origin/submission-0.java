
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap: Sorted by squared distance in descending order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA); 
        });

        // Iterate through all points
        for (int[] point : points) {
            maxHeap.offer(point);
            
            // Keep the heap size bounded to k elements
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Collect the k closest points
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
