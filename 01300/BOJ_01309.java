import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());

         dp = new int[n + 1];

         dp[1] = 3;
         if (n >= 2){
             dp[2] = 7;
         }
        System.out.println(recu(n));
    }

    static int recu(int num){
        if (dp[num] == 0){
            dp[num] = (recu(num - 1) * 2 + recu(num - 2)) % 9901;
        }
        return dp[num];
    }
}
