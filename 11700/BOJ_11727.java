import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2){
            dp[2] = 3;
        }

        recu(n);
        System.out.println(dp[n]);
    }
    static int recu(int num){
        if (dp[num] == 0){
            dp[num] = ((recu(num - 2) * 2) + recu(num - 1)) % 10007;
        }
        return dp[num];
    }
}
