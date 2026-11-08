
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // Combine position and speed into a 2D array for sorting
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // Calculate and store the time required to reach the target
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        
        // Sort cars based on their starting positions in ascending order
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        int fleets = 0;
        double currentFleetTime = 0.0;
        
        // Iterate backwards from the car closest to the target to the furthest
        for (int i = n - 1; i >= 0; i--) {
            // If this car takes more time than the leading fleet, it forms a new fleet
            if (cars[i][1] > currentFleetTime) {
                fleets++;
                currentFleetTime = cars[i][1]; // Update the bottleneck time for this fleet
            }
            // If cars[i][1] <= currentFleetTime, it catches up and merges into the existing fleet
        }
        
        return fleets;
    }
}
