import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());

        dp = new int[100001];

        for (int i = 1 ; i * i <= 100000; i++){
            dp[i * i] = 1;
        }

        System.out.println(recu(n));
    }

    static int recu(int num){
        if (dp[num] == 0){
            dp[num] = num;

            for (int i = 1; i * i < num; i++){
                dp[num] = Math.min(dp[num], recu(num - (i * i)) + recu(i * i));
            }

        }
        return dp[num];
    }
}
