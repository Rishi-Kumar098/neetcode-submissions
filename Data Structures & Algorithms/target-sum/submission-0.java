class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(Math.abs(target)>sum||(sum+target)%2!=0||(sum+target)<0){
            return 0;
        }
        int subsetSum=(sum+target)/2;
        return countSubsets(nums,subsetSum);

    }
    private int countSubsets(int[] nums,int targetSum){
        int[] dp=new int[targetSum+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=targetSum;i>=num;i--){
                dp[i]+=dp[i-num];
            }
        }
        return dp[targetSum];
    }
}
