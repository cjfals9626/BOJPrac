import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static long P = 1000;
    static long[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        map = new long[n][n];

        long[][] resultMap = new long[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num % P;
            }
        }

        resultMap = recu(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sb.append(resultMap[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);

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
        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                long num = 0;
                for (int l = 0; l < n; l++){
                    num += ((arr1[i][l] % P) * (arr2[l][j] % P)) % P;
                }
                result[i][j] = num % P;
            }
        }
        return result;
    }
}