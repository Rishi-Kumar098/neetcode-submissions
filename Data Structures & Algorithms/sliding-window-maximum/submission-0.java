class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0){
            return new int[0];
        }
        int n=nums.length;
        int[] result=new int[n-k+1];
        int ri=0;
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peekFirst()<i-k+1){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offerLast(i);
            if(i>=k-1){
                result[ri++]=nums[q.peekFirst()];
            }
        }
        return result;
    }
}
