
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        
        // Case 1: Add all intervals that come strictly before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Case 2: Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the final merged new interval
        result.add(newInterval);
        
        // Case 3: Add all remaining intervals that come strictly after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        // Convert the list back to a 2D primitive array
        return result.toArray(new int[result.size()][]);
    }
}
