
/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return 0;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int e = 0;

        for (int s = 0; s < n; s++) {
            if (starts[s] < ends[e]) {
                rooms++; // Need a new room
            } else {
                e++;     // Earliest meeting ended; reuse its room
            }
        }

        return rooms;
    }
}
