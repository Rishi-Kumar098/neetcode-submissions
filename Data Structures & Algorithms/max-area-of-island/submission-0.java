class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0)return 0;

        int maxArea=0;
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    int currentArea=0;
                    Queue<int[]> queue=new LinkedList<>();
                    queue.offer(new int[]{r,c});
                    grid[r][c]=0;
                    while(!queue.isEmpty()){
                        int[] cell=queue.poll();
                        currentArea++;
                        for(int[] dir:dirs){
                            int nr=cell[0]+dir[0];
                            int nc=cell[1]+dir[1];
                            if(nr>=0&& nr<rows&&nc>=0&& nc<cols && grid[nr][nc]==1){
                                queue.offer(new int[]{nr,nc});
                                grid[nr][nc]=0;
                            }
                        }

                    }
                    maxArea=Math.max(maxArea,currentArea);
                }
            }
        }
        return maxArea;
    }
}
