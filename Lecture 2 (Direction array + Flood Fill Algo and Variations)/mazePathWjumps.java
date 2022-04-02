import java.util.*;

public class mazePathWjumps{

    public static int mazePath( int sr, int sc , int er, int ec , int[][] dir, String[] dis, String psf){

        if( sr == er &&  sc == ec){
      System.out.println( psf);
      return 1;
        }

        int count = 0;

        for( int d = 0; d < dir.length ; d++) {

            for( int radius = 1; radius <= Math.max(er,ec); radius++) { // direction fixed radius varying
                int r = sr + radius * dir[d][0];  // for row
                int c = sc + radius * dir[d][1]; // for column
    
                if( r >= 0 && c >= 0 && r<= er && c <= ec) {
                    count += mazePath(r,c,er,ec,dir,dis,psf + dis[d]);
                }
            }
           
        }

        return count;
    }

    public static void main( String[] args){
      
          int[][] d = {{0,1},{1,0},{1,1}};
          String[] dis = {"H","V","D"};

          System.out.println(mazePath(0,0,2,2,d,dis,""));


    }

}

  