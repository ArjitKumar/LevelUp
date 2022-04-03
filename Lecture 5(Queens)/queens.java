// Leetcode N queens and N queens 2


import java.util.ArrayList;
import java.util.List;


public class queens {

      // tnq : total no of queens, qpsf : queen placed so far

    // tnq : total no of queens, qpsf : queen placed so far
    public static int queenCombination1D(boolean[] boxes, int tnq, int bno, int qpsf, String psf) {
        if (qpsf == tnq) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int bidx = bno; bidx < boxes.length; bidx++) {
            count += queenCombination1D(boxes, tnq, bidx + 1, qpsf + 1, psf + "b" + bidx + "q" + qpsf + " ");
        }
        return count;
    }

    // for queen permutation 1d there is no need for bidx variable start loop from 0-> for code check l007.java


    
   // better way =====> asummin the 2d matrix to be 1d matrix
    public static int queenCombination2D(boolean[][] boxes, int tnq, int bno, int qpsf, String psf) {
        if (qpsf == tnq) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for( int bidx = bno ; bidx < boxes.length * boxes.length; bidx++) {
              int r = bidx / boxes.length;
              int c = bidx % boxes.length;
            count += queenCombination2D(boxes, tnq, bidx + 1 ,qpsf + 1, psf + "(" + r + "," + c + ")");
        }
        
        return count;
    }
    // using 2 for loops

    public static int combination2dusing2loops(int queen,int boxes,int ith,int jth,String st){
        if(queen==0){
            System.out.println(st);
            return 1;
        }
        int count=0;
        for(int i=ith;i<boxes;i++){
            if(i!=ith){
                jth=0;
            }
            for(int j=jth;j<boxes;j++)
              count+=combination2dusing2loops(queen-1,boxes,i,j+1,st+"q"+queen+" ("+i+","+j+") "); 
          
        }
        return count;
    }
    public static int queenPermutation2D(boolean[][] boxes, int tnq, int qpsf, String psf) {
        if (qpsf == tnq) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for( int bidx = 0 ; bidx < boxes.length * boxes.length; bidx++) {
              int r = bidx / boxes.length;
              int c = bidx % boxes.length;
  /* this condition is important */  if( !boxes[r][c]) {
              boxes[r][c] = true;
            count += queenPermutation2D(boxes, tnq,qpsf + 1, psf + "(" + r + "," + c + ")");
            boxes[r][c] = false;
              }
        }
        
        return count;
    }

     // Nqueens(modified for leetcode submission) =================================================

    public static int Nqueens01(boolean[][] boxes, int tnq,int bno, int qpsf, String psf, List<String> smallans,List<List<String>> result) {
        if (qpsf == tnq) {
            // System.out.println(psf);
           smallans = new ArrayList<>();
           
            for( int i = 0 ; i < boxes.length; i++) {
                // smallans = new ArrayList<>();
                String f = "";
                for( int j = 0 ;  j < boxes[0].length; j++) {
                    if( boxes[i][j] == true) {
                        // System.out.print(boxes[i][j]);
                        // smallans.add("");
                        f +="Q";
                    }else{
                        // System.out.print(". ");
                        // smallans.add(".");
                        f +=".";
                    }
                }
                smallans.add(f);
                // result.add(smallans);
            }
            result.add(smallans);
            return 1;
        }
        int count = 0;
        for( int bidx = bno ; bidx < boxes.length * boxes.length; bidx++) {
              int r = bidx / boxes.length;
              int c = bidx % boxes.length;
  /* this condition is important */  if( isSafetoPlaceQueen(boxes, r, c)) {
              boxes[r][c] = true;
            count += Nqueens01(boxes, tnq,bidx + 1,qpsf + 1, psf +  r +  + c + ")", smallans, result);
            boxes[r][c] = false;
              }
        }
        
        return count;
    }

    // isSafetoPlacequeen =================================================

     public static boolean isSafetoPlaceQueen(boolean[][] boxes, int sr, int sc) {
         
        int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1}};
        for( int d = 0; d < dir.length ; d++) {
    
            for( int radius = 1; radius <= boxes.length ; radius++) { // direction fixed radius varying
                int r = sr + radius * dir[d][0];  // for row
                int c = sc + radius * dir[d][1]; // for column
    
                if( r >= 0 && c >= 0 && r < boxes.length && c < boxes[0].length) {
                    if( boxes[r][c] == true) return false;
                }else{
                    break;
                }
            }
           
        }
        return true;
     }


     // Nqueens permutation ===================================
     public static int nqueen_01_Perm(boolean[][] boxes, int tnq, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = 0; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if (!boxes[r][c] && isSafetoPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_01_Perm(boxes, tnq - 1, psf + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    public static void main(String... args) {
        boolean[][] boxes = new boolean[4][4];
        List<String> smallans = new ArrayList<>();
        List<List<String> > result = new ArrayList<>();
        System.out.println(Nqueens01(boxes, 4,0, 0, "", smallans, result));
        for(List<String> list : result) {
            System.out.print(list + " ");
        }
        // String str = "Arjit";
        // System.out.println(str);
        
        // for( int i = 0 ; i < boxes.length; i++) {
        //     for( int j = 0 ;  j < boxes[0].length; j++) {
        //         if( boxes[i][j] == true) {
        //             System.out.print(boxes[i][j]);
        //         }else{
        //             System.out.print(". ");
        //         }
        //     }
        //     System.out.println();
        // }
    }
    

}


 
