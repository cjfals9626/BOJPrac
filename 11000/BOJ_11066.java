import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            int chapters = Integer.parseInt(br.readLine());
            long[][] dp = new long[chapters+1][chapters+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] sum = new long[chapters + 1];
            for (int j = 1; j <= chapters; j++){
                sum[j] = sum[j-1] + Long.parseLong(st.nextToken());
            }


            for (int d = 1; d < chapters; d++){
                for (int s = 1; s <= chapters; s++){
                    int e = s+d;
                    if (e > chapters){
                        break;
                    }else{
                        dp[s][e] = Long.MAX_VALUE;
                        for (int j = 0; j < e - s; j++){
                            dp[s][e] = Math.min(dp[s][e], dp[s][s + j] + dp[s + j + 1][e] + (sum[e] - sum[s-1]));
                        }
                    }
                }
            }

            sb.append(dp[1][chapters]).append('\n');

        }
        System.out.println(sb);

    }

}