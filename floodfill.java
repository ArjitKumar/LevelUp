public class floodfill {
    public static int flood( int sr, int sc , int er, int ec , int[][] dir, String[] dis, String psf, boolean[][] visited){

    if( sr == er &&  sc == ec){
      System.out.println( psf);
      return 1;
    }

    visited[sr][sc] = true;   // ate hi mark lga lo 

        int count = 0;

        for( int d = 0; d < dir.length ; d++) {

            // for( int radius = 1; radius <= Math.max(er,ec); radius++) { // direction fixed radius varying
                int r = sr + dir[d][0];  // for row
                int c = sc +  dir[d][1]; // for column
    
                if( r >= 0 && c >= 0 && r<= er && c <= ec && visited[r][c] == false) {
                    
                    count += flood(r,c,er,ec,dir,dis,psf + dis[d], visited);
                    
                }
            // }
           
        }
        visited[sr][sc] = false;           // neighbours explore krne k baad false mark krdo basically dfs h
 
        return count;
    }

    public static void main( String[] args){
      
          int[][] d = {{0,1},{1,0},{1,1},{-1,0},{1,-1},{-1,-1},{1,1},{-1,-1}};   
          String[] dis = {"H","V","D","U","n","e","w","s"};  // flood fill has 8 directions
          boolean[][] visited = new boolean[5][5];

          System.out.println(flood(0,0,4,4,d,dis,"", visited));


    }

}
