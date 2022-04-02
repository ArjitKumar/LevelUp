import java.util.*;

public class mazePath{

    public static int mazePath( int sr, int sc , int er, int ec , int[][] dir, String[] dis, String psf,int[][] matrix){

    if( sr == er &&  sc == ec){
      System.out.println( psf);
      return 1;
        }
        
        matrix[sr][sc] -= 1;
        int count = 0;

        for( int d = 0; d < dir.length ; d++) {
            int r = sr + dir[d][0];  // for row
            int c = sc + dir[d][1]; // for column

            if( r >= 0 && c >= 0 && r<= er && c <= ec) {
                matrix[r][c] = matrix[r][c] - 1;
                count += mazePath(r,c,er,ec,dir,dis,psf + dis[d], matrix);
            }
        }

        return count;
    }

    public static void main( String[] args){
      
          int[][] d = {{0,1},{1,0}};
          String[] dis = {"H","V"};
          int[][] matrix = {{3,2},{1,3}};

          int count = (mazePath(0,0,matrix.length - 1,matrix[0].length - 1,d,dis,"", matrix));
        //   System.out.println(count);
        //   int ans = 0;
          for( int i = 0 ; i < matrix.length ; i++) {
              for( int j = 0 ; j < matrix[0].length; j++) {
                        //    if(matrix[i][j] != 0) {
                        //             ans++;
                        //             break;
                        //    }
                        System.out.print(matrix[i][j] + " ");
              }
              System.out.println();
          }
        // if( ans != 0) {
        //     System.out.println("No");
        // }else{
        //     System.out.println("Yes");
        // }

    }

}

  