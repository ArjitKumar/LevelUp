
    //   ======================== 8 variations of tree and coin change permutation ==================================

import java.util.*;

public class coinChange {

    public static int coinChangePermutaion_Inf(int[] coin ,  int tar , String psf) {
         
        if(tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;

            for( int i = 0 ; i < coin.length ; i++) {
                if( tar - coin[i] >= 0) {
                    count += coinChangePermutaion_Inf(coin, tar - coin[i], psf + coin[i] + " ");
                }
            }
        
        return count;
    }


    // idx playes a important role here

    public static int coinChangeCombination_Inf(int[] coin ,  int tar ,int idx ,String psf) {
         
        if(tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;

            for( int i = idx ; i < coin.length ; i++) {
                if( tar - coin[i] >= 0) {
                    count += coinChangeCombination_Inf(coin, tar - coin[i],i, psf + coin[i] + " ");
                }
            }
        
        return count;
    }


    public static int coinChangeCombination_Single(int[] coin ,  int tar ,int idx ,String psf) {
         
        if(tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;

            for( int i = idx ; i < coin.length ; i++) {
                if( tar - coin[i] >= 0) {
                    count += coinChangeCombination_Single(coin, tar - coin[i],i+1, psf + coin[i] + " ");
                }
            }
        
        return count;
    }

       // use visited array
    public static int coinChangePermutaion_Single(int[] coin , int tar ,String psf) {
         
        if(tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;

            for( int i = 0 ; i < coin.length ; i++) {
                if( coin[i] > 0 && tar - coin[i] >= 0) {
                    int val = coin[i];
                    coin[i] = -coin[i];  // making negative

                    count += coinChangePermutaion_Single(coin, tar - val,psf + val + " ");

                    coin[i] = -coin[i]; // making positive
                }
            }
        
        return count;
    }


    // Coin change combination single coin using binary subsequence ===============================================

    public static int coinChangecombination_Single_Using_Binary_Subsequence(int[] coin , int tar ,int idx, String psf) {
         
        if(tar == 0 || idx == coin.length) { // 2 basecases
            if( tar == 0) {
                System.out.println(psf);       // we get our answer when target is 0

                return 1;
            }  
            return 0;
           
        }

        int count = 0;
        if( tar - coin[idx] >= 0) {
            count += coinChangecombination_Single_Using_Binary_Subsequence(coin, tar - coin[idx], idx + 1, psf + coin[idx] + " ");
           
        }
        count += coinChangecombination_Single_Using_Binary_Subsequence(coin, tar, idx + 1, psf);

        return count;
    }


    public static int coinChangecombination_Infinite_Using_Binary_Subsequence(int[] coin , int tar ,int idx, String psf) {
         
        if(tar == 0 || idx == coin.length) { // 2 basecases
            if( tar == 0) {
                System.out.println(psf);       // we get our answer when target is 0

                return 1;
            }  
            return 0;
           
        }

        int count = 0;
        if( tar - coin[idx] >= 0) {
            count += coinChangecombination_Infinite_Using_Binary_Subsequence(coin, tar - coin[idx], idx , psf + coin[idx] + " ");
           
        }
        count += coinChangecombination_Infinite_Using_Binary_Subsequence(coin, tar, idx + 1, psf);

        return count;
    }

    public static int coinChangePermutaion_Infinte_Using_Binary_Subsequence(int[] coin , int tar ,int idx, String psf) {
         
        if(tar == 0 || idx == coin.length) { // 2 basecases
            if( tar == 0) {
                System.out.println(psf);       // we get our answer when target is 0

                return 1;
            }  
            return 0;
           
        }

        int count = 0;
        if( tar - coin[idx] >= 0) {
            // passing 0 kyinki sb coins aa skte hain

            count += coinChangePermutaion_Infinte_Using_Binary_Subsequence(coin, tar - coin[idx], 0, psf + coin[idx] + " ");
           
        }
        count += coinChangePermutaion_Infinte_Using_Binary_Subsequence(coin, tar, idx + 1, psf);

        return count;
    }
    
    
    
    
    public static int coinChangePermutaion_Single_Using_Binary_Subsequence(int[] coin , int tar ,int idx, String psf) {
         
        if(tar == 0 || idx == coin.length) { // 2 basecases
            if( tar == 0) {
                System.out.println(psf);       // we get our answer when target is 0

                return 1;
            }  
            return 0;
           
        }

        int count = 0;
        if( coin[idx] > 0 && tar - coin[idx] >= 0) {
            // passing 0 kyinki sb coins aa skte hain
            int val = coin[idx];
            coin[idx] = -coin[idx];  // making negative

            count += coinChangePermutaion_Single_Using_Binary_Subsequence(coin, tar - val, 0, psf + val + " ");

            coin[idx] = -coin[idx]; // making positive

           
        }
        count += coinChangePermutaion_Single_Using_Binary_Subsequence(coin, tar, idx + 1, psf);

        return count;
    }






    public static void main(String[] args) {

        int[] coin = {0,0,1,1,0,1};
        // System.out.println(coinChangePermutaion_Inf(coin,10,""));
        // System.out.println(coinChangeCombination_Inf(coin,10,0,""));
        // System.out.println(coinChangeCombination_Single(coin,10,0,"")); 
        System.out.println(coinChangePermutaion_Single(coin,3,""));
        // System.out.println(coinChangecombination_Single_Using_Binary_Subsequence(coin,10,0,""));
        // System.out.println(coinChangePermutaion_Infinte_Using_Binary_Subsequence(coin,10,0,""));
        // System.out.println(coinChangePermutaion_Infinte_Using_Binary_Subsequence(coin,10,0,""));
        // System.out.println(coinChangePermutaion_Single_Using_Binary_Subsequence(coin,10,0,""));

    }
}