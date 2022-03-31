public class ShortestPath {
    
    
    static class Pair{
        int len = (int)1e9;
        String str = "";
    }
    
     public static Pair ShortestPathAns( int sr, int sc , int er, int ec , int[][] dir, String[] dis,int mat[][]){

    if( sr == er &&  sc == ec){
     Pair base = new Pair();
     base.len = 0;
      
      return base;
    }
     
    Pair ans = new Pair();
    mat[sr][sc] = 1; // block  

     

        for( int d = 0; d < dir.length ; d++) {
            
                int r = sr + dir[d][0];  // for row
                int c = sc +  dir[d][1]; // for column
    
                if( r >= 0 && c >= 0 && r<= er && c <= ec && mat[r][c] == 0) {
                    
                    Pair recans = ShortestPathAns(r,c,er,ec,dir,dis,mat);
                    if( recans.len != (int)1e9 && recans.len + 1 < ans.len) {
                        ans.len = recans.len + 1;
                        ans.str = recans.str + dis[d];
                    }
                    
                    
                }
          
        }
        mat[sr][sc] = 0; // unblock      
 
        return ans;
    }
        public static void main( String[] args){
          
              int[][] d = {{0,1},{1,0},{1,1},{-1,0},{1,-1},{-1,-1},{1,1},{-1,-1}};   
              String[] dis = {"H","V","D","U","n","e","w","s"};  // flood fill has 8 directions
            
              int[][] mat = {{1,0,0},{0,0,1}};
              Pair ans = ShortestPathAns(0,0,4,4,d,dis,mat);
    
    
        }



}
