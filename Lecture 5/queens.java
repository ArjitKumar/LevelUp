// public class queens {

//     // tnq : total no of queens, qpsf : queen placed so far

//     public static int queenPermutation1D(boolean[] boxes,int tnq, int bno, int qpsf, String psf) {
//         if (qpsf == tnq) {
//             System.out.println(psf);
//             return 1;
//         }
//         int count = 0;


        
//         return count;
//     }

//     public static void main(String... args) {
//         boolean[] boxes = new boolean[6];
//         System.out.println(queenPermutation1D(boxes, 3, 0, 0, ""));
//     }

// }

public class queens {

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

    public static int queenPermutation1D(boolean[] boxes, int tnq, int bno, int qpsf, String psf) {
        if (qpsf == tnq) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for( int bidx = bno ; bidx < boxes.length ; bidx++) {
            boxes[bidx] = true;
            count += queenPermutation1D(boxes, tnq, bno, qpsf + 1, psf)
        }
        
        return count;
    }

    public static void main(String... args) {
        boolean[] boxes = new boolean[6];
        System.out.println(queenCombination1D(boxes, 3, 0, 0, ""));
    }

}