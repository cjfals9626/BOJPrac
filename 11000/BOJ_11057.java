import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long dp[][] = new long[n][10];

        for (int i = 0; i < 10; i++){
            dp[0][i] = 1;
        }

        for (int l = 1; l < n; l++){
            for (int i = 0; i < 10; i++){
                for (int j = i; j < 10; j++){
                    //여기서도 mod 10007 해줘야 함.
                    //과정에서 범위가 넘어갈 수도 있으므로
                    dp[l][i] += dp[l-1][j] % 10007;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++){
            result += dp[n-1][i];
        }

        System.out.println(result % 10007);

    }
}