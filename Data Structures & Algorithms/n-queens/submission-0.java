class Solution {
    private List<List<String>> result;
    private boolean[] rows;
    private boolean[] diag1;
    private boolean[] diag2;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        rows=new boolean[n];
        diag1=new boolean[2*n];
        diag2=new boolean[2*n];
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrack(0,n,board);
        return result;
    }
    private void backtrack(int c,int n,char[][] board){
        if(c==n){
            result.add(constructBoard(board));
            return;
        }
        for(int r=0;r<n;r++){
            if(rows[r]||diag1[r-c+n]||diag2[r+c]){
                continue;
            }
            board[r][c]='Q';
            rows[r]=true;
            diag1[r-c+n]=true;
            diag2[r+c]=true;
            backtrack(c+1,n,board);
            board[r][c]='.';
            rows[r]=false;
            diag1[r-c+n]=false;
            diag2[r+c]=false;
        }
    }
    private List<String> constructBoard(char[][] board){
        List<String> layout=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            layout.add(new String(board[i]));
        }
        return layout;
    }
}
