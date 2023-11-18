import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static long P = 1000000007;
    static long n;

    static long[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());


        map = new long[2][2];
        map[0][0] = map[1][0] = map[0][1] = 1;
        map[1][1] = 0;

        long[][] result = recu(n);

        System.out.println(result[0][1]);

    }
    static long[][] recu(long exp){

        if (exp == 1){
            return map;
        }

        long[][] tmp = recu(exp/2);

        if (exp % 2 == 1){
            return cal(cal(tmp, tmp), map);
        }else{
            return cal(tmp, tmp);
        }
    }

    static long[][] cal(long[][] arr1, long[][] arr2){
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                long num = 0;
                for (int l = 0; l < 2; l++){
                    num += ((arr1[i][l] % P) * (arr2[l][j] % P)) % P;
                }
                result[i][j] = num % P;
            }
        }
        return result;
    }
}