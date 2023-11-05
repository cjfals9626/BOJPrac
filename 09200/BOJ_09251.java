import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static char[] arr1;
    static char[] arr2;

    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        arr1 = new char[s1.length()];
        arr2 = new char[s2.length()];

        for (int i = 0; i < arr1.length; i++){
            arr1[i] = s1.charAt(i);
        }
        for (int i = 0; i < arr2.length; i++){
            arr2[i] = s2.charAt(i);
        }

        dp = new Integer[arr1.length][arr2.length];

        System.out.println(recu(arr1.length - 1, arr2.length - 1));

    }

    static int recu(int a, int b){

        if(a <= -1 || b <= -1){
            return 0;
        }

        if (dp[a][b] == null){
            if (arr1[a] == arr2[b]){
                dp[a][b] = recu(a - 1 , b - 1) + 1;
            }else{
                dp[a][b] = Math.max(recu(a - 1, b), recu(a, b-1));
            }
        }
        return dp[a][b];
    }
}


